FROM openjdk:11.0.3-jdk

RUN apt-get update
RUN apt update

RUN yes|apt-get install zip
RUN apt-get install -y python3-pip
RUN apt-get update

# add requirements.txt, written this way to gracefully ignore a missing file
COPY . .
RUN ([ -f requirements.txt ] \
    && pip3 install --no-cache-dir -r requirements.txt) \
        || pip3 install --no-cache-dir jupyter jupyterlab

USER root

# Download the kernel release
RUN curl -L https://github.com/SpencerPark/IJava/releases/download/v1.3.0/ijava-1.3.0.zip > ijava-kernel.zip

# Unpack and install the kernel
RUN unzip ijava-kernel.zip -d ijava-kernel \
  && cd ijava-kernel \
  && python3 install.py --sys-prefix


# Set up the user environment

ENV NB_USER runner
ENV NB_UID 1000
ENV HOME /home/$NB_USER

RUN adduser --disabled-password \
    --gecos "Default user" \
    --uid $NB_UID \
    $NB_USER

COPY . $HOME
RUN chown -R $NB_UID $HOME

USER $NB_USER

# Installing SDK Man
RUN curl -s "https://get.sdkman.io" | bash
#RUN apt-get update
RUN /bin/bash -c "source /home/runner/.sdkman/bin/sdkman-init.sh"

# Installing Java and Maven, removing some unnecessary SDKMAN files 
RUN bash -c "source /home/runner/.sdkman/bin/sdkman-init.sh && \
    yes | sdk install java 7.0.262-zulu && \
    yes | sdk install java 8.0.252-zulu && \
    yes | sdk install gradle 6.0 && \
    yes | sdk install jbang 0.20.0 && \
    rm -rf runner/.sdkman/archives/* && \
    rm -rf runner/.sdkman/tmp/*"

RUN bash -c "echo \"export JAVA_HOME=/home/runner/.sdkman/candidates/java/8.0.252-zulu\">>/home/runner/.bash_aliases"
RUN bash -c "echo \"export JAVA7_HOME=/home/runner/.sdkman/candidates/java/7.0.262-zulu\">>/home/runner/.bash_aliases"

# Launch the notebook server
WORKDIR $HOME
CMD ["jupyter", "lab", "--ip", "0.0.0.0"]