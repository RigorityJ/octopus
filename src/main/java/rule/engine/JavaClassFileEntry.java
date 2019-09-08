package rule.engine;

import frontEnd.Interface.outputRouting.ExceptionHandler;
import frontEnd.MessagingSystem.routing.EnvironmentInformation;
import lombok.extern.log4j.Log4j2;

/**
 * <p>JavaClassFileEntry class.</p>
 *
 * @author CryptoguardTeam
 * Created on 2019-01-17.
 * @version 03.07.01
 * @since 01.01.11
 *
 * <p>The method in the Engine handling Java Class File(s) Scanning.</p>
 */
@Log4j2
public class JavaClassFileEntry implements EntryHandler {

    /**
     * {@inheritDoc}
     */
    public void Scan(EnvironmentInformation generalInfo) throws ExceptionHandler {

        log.trace("Starting scanner looper");
        for (RuleChecker ruleChecker : CommonRules.ruleCheckerList) {
            log.info("Checking the rule: " + ruleChecker.getClass().getSimpleName());
            ruleChecker.checkRule(generalInfo.getSourceType(), generalInfo.getSource(), generalInfo.getDependencies(), generalInfo.getSourcePaths(), generalInfo.getOutput());
        }
        log.trace("Scanner looper stopped");
    }


}
