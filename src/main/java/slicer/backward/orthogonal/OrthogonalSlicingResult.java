package slicer.backward.orthogonal;

import analyzer.backward.UnitContainer;
import slicer.backward.MethodCallSiteInfo;
import slicer.backward.property.PropertyAnalysisResult;

import java.util.List;
import java.util.Map;

/**
 * Created by RigorityJTeam on 10/14/16.
 *
 * @author franceme
 * @version 03.07.01
 */
public class OrthogonalSlicingResult {

    private MethodCallSiteInfo callSiteInfo;
    private List<UnitContainer> analysisResult;
    private Map<String, List<PropertyAnalysisResult>> propertyUseMap;

    /**
     * <p>Getter for the field <code>callSiteInfo</code>.</p>
     *
     * @return a {@link slicer.backward.MethodCallSiteInfo} object.
     */
    public MethodCallSiteInfo getCallSiteInfo() {
        return callSiteInfo;
    }

    /**
     * <p>Setter for the field <code>callSiteInfo</code>.</p>
     *
     * @param callSiteInfo a {@link slicer.backward.MethodCallSiteInfo} object.
     */
    public void setCallSiteInfo(MethodCallSiteInfo callSiteInfo) {
        this.callSiteInfo = callSiteInfo;
    }

    /**
     * <p>Getter for the field <code>analysisResult</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<UnitContainer> getAnalysisResult() {
        return analysisResult;
    }

    /**
     * <p>Setter for the field <code>analysisResult</code>.</p>
     *
     * @param analysisResult a {@link java.util.List} object.
     */
    public void setAnalysisResult(List<UnitContainer> analysisResult) {
        this.analysisResult = analysisResult;
    }

    /**
     * <p>Getter for the field <code>propertyUseMap</code>.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, List<PropertyAnalysisResult>> getPropertyUseMap() {
        return propertyUseMap;
    }

    /**
     * <p>Setter for the field <code>propertyUseMap</code>.</p>
     *
     * @param propertyUseMap a {@link java.util.Map} object.
     */
    public void setPropertyUseMap(Map<String, List<PropertyAnalysisResult>> propertyUseMap) {
        this.propertyUseMap = propertyUseMap;
    }
}