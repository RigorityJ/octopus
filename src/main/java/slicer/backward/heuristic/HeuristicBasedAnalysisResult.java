/* Licensed under GPL-3.0 */
package slicer.backward.heuristic;

import analyzer.backward.UnitContainer;
import java.util.List;
import java.util.Map;
import slicer.backward.property.PropertyAnalysisResult;
import soot.SootMethod;

/**
 * HeuristicBasedAnalysisResult class.
 *
 * @author franceme
 * @version 03.07.01
 */
public class HeuristicBasedAnalysisResult {

  private String instruction;
  private SootMethod method;
  private List<UnitContainer> analysis;
  private Map<String, List<PropertyAnalysisResult>> propertyUseMap;

  /**
   * Constructor for HeuristicBasedAnalysisResult.
   *
   * @param instruction a {@link java.lang.String} object.
   * @param method a {@link soot.SootMethod} object.
   * @param analysis a {@link java.util.List} object.
   * @param propertyUseMap a {@link java.util.Map} object.
   */
  public HeuristicBasedAnalysisResult(
      String instruction,
      SootMethod method,
      List<UnitContainer> analysis,
      Map<String, List<PropertyAnalysisResult>> propertyUseMap) {
    this.instruction = instruction;
    this.method = method;
    this.analysis = analysis;
    this.propertyUseMap = propertyUseMap;
  }

  /**
   * Getter for the field <code>instruction</code>.
   *
   * @return a {@link java.lang.String} object.
   */
  public String getInstruction() {
    return instruction;
  }

  /**
   * Getter for the field <code>method</code>.
   *
   * @return a {@link soot.SootMethod} object.
   */
  public SootMethod getMethod() {
    return method;
  }

  /**
   * Getter for the field <code>analysis</code>.
   *
   * @return a {@link java.util.List} object.
   */
  public List<UnitContainer> getAnalysis() {
    return analysis;
  }

  /**
   * Getter for the field <code>propertyUseMap</code>.
   *
   * @return a {@link java.util.Map} object.
   */
  public Map<String, List<PropertyAnalysisResult>> getPropertyUseMap() {
    return propertyUseMap;
  }
}
