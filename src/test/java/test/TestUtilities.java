package test;

import frontEnd.MessagingSystem.routing.inputStructures.ScarfXMLId;
import frontEnd.argsIdentifier;
import util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class TestUtilities {

    public static final Boolean isLinux = !System.getProperty("os.name").contains("Windows");

    public static final String basePath = System.getProperty("user.dir");
    public static final String scarfArgs = Utils.osPathJoin(basePath, "src", "main", "resources", "Scarf", "sample.properties");
    public static final String srcOneGrv = Utils.osPathJoin(basePath, "samples", "testable-jar");
    public static final String jarOne = Utils.osPathJoin(basePath, "samples", "testable-jar.jar");
    public static final String srcOneGrvDep = Utils.osPathJoin(basePath, "samples", "testable-jar", "build", "dependencies");
    public static final String testPath = Utils.osPathJoin(basePath, "build", "tmp");
    public static final String pathToSchema = Utils.osPathJoin(basePath, "src", "main", "resources", "Scarf", "Scarf.xsd");
    public static final String pathToSchemaValidation = Utils.osPathJoin(basePath, "src", "main", "java", "com", "example", "response", "package-info.java");
    public static final String pathToAPK = Utils.osPathJoin(basePath, "samples", "app-debug.apk");

    public static String makeArg(argsIdentifier id, String value) {
        return makeArg(id.getId(), value);
    }

    public static String makeArg(argsIdentifier id) {
        return id.getArg() + " ";
    }

    public static String makeArg(ScarfXMLId id, String value) {
        return makeArg(id.getId(), value);
    }

    public static String makeArg(String id, String value) {
        return "-" + id + " " + value + " ";
    }

    public static Boolean validateXML() {
        File scarfXMLMarshaller = new File(pathToSchemaValidation);
        if (!scarfXMLMarshaller.exists() || !scarfXMLMarshaller.isFile())
            return false;
        try {
            List<String> contents = Files.readAllLines(scarfXMLMarshaller.toPath(), Charset.forName("UTF-8"));
            if (contents.contains("@javax.xml.bind.annotation.XmlSchema(namespace = \"https://www.swamp.com/com/scarf/struct\", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)"))
                return true;
            else
                return false;
        } catch (IOException e) {
            return false;
        }
    }
}
