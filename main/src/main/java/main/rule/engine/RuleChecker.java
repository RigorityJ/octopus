package main.rule.engine;

import java.io.IOException;
import java.util.List;

/**
 * The interface of the RuleChecker class. Used to generate the structure of the various rules being checked.
 *
 * @author RigorityJTeam
 * @since 1.0
 */
public interface RuleChecker
{

	/**
	 * The checkRule will verify the allocated rules for the given source.
	 * Any failed rules will be printed to the commandline.
	 *
	 * @param type                  the type of engine to be used for the processing
	 * @param projectJarPath        the path to the used jar(s)
	 * @param projectDependencyPath the path to the dependencies of the project
	 */
	public void checkRule(EngineType type, List<String> projectJarPath, List<String> projectDependencyPath) throws IOException;
}