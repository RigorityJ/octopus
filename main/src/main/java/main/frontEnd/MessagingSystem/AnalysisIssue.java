package main.frontEnd.MessagingSystem;

import main.analyzer.backward.UnitContainer;
import main.rule.engine.RuleList;
import main.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The class containing the specific analysis issue information.
 * The "flat" structure to be transformed to various formats.
 *
 * <p>STATUS: IC</p>
 *
 * @author franceme
 * @since V01.00.01
 */
public class AnalysisIssue {

    //region Attributes
    private String fullPathName = "";
    private String className = "";
    private RuleList rule;
    private Stack methods;
    private ArrayList<AnalysisLocation> locations;
    private String issueInformation = "";
    private String issueCause = "";
    //endregion

    //region Constructors

    public AnalysisIssue(String sootString, Integer ruleNumber, String Info, List<String> sourcePaths) {
        String className = Utils.retrieveClassNameFromSootString(sootString);
        String methodName = Utils.retrieveMethodFromSootString(sootString);
        Integer lineNum = Utils.retrieveLineNumFromSootString(sootString);
        String constant = null;


        if (sootString.contains("constant keys") || ruleNumber == 3)
            constant = Utils.retrieveFoundMatchFromSootString(sootString);


        if (lineNum >= 0)
            this.addMethod(methodName, new AnalysisLocation(lineNum));
        else
            this.addMethod(methodName);

        this.className = className;
        this.rule = RuleList.getRuleByRuleNumber(ruleNumber);

        if (constant != null)
            Info += " Value found = \"" + constant + "\".";

        this.issueInformation = Info;

        if (sourcePaths.size() == 1) {
            String fullSource = sourcePaths.get(0);
            if (fullSource.endsWith(":dir"))
                this.fullPathName = Utils.osPathJoin(fullSource.replace(":dir", ""), "src", "main", "java", className.replace(".", System.getProperty("file.separator")) + ".java");
            else
                this.fullPathName = Utils.osPathJoin(fullSource, "src", "main", "java", className.replace(".", System.getProperty("file.separator")));
        }
        else {
            for (String in : sourcePaths)
                if (in.contains(className))
                    this.fullPathName = in;

            this.fullPathName = "UNKNOWN";
        }
    }

    public AnalysisIssue(UnitContainer unit, Integer ruleNumber, String sootString, List<String> sourcePaths) {
        Integer lineNum;
        String constant = null;


        if (sootString.contains("constant keys") || ruleNumber == 3)
            constant = Utils.retrieveFoundMatchFromSootString(sootString);


        String methodName = Utils.retrieveMethodFromSootString(unit.getMethod());

        if ((lineNum = unit.getUnit().getJavaSourceStartLineNumber()) >= 0) {
            AnalysisLocation tempLoc = new AnalysisLocation(lineNum);
            if (unit.getUnit().getJavaSourceStartColumnNumber() >= 0) {
                tempLoc.setColStart(unit.getUnit().getJavaSourceStartColumnNumber());
                tempLoc.setColEnd(unit.getUnit().getJavaSourceStartColumnNumber());
            }

            this.addMethod(methodName, tempLoc);
        }

        this.className = Utils.retrieveClassNameFromSootString(unit.getMethod());
        this.rule = RuleList.getRuleByRuleNumber(ruleNumber);

        if (sootString.startsWith("Found")) {
            this.issueInformation = Utils.retrieveFoundPatternFromSootString(sootString);

            if (this.issueInformation.equals("UNKNOWN") && constant != null)
                this.issueInformation = "Found constant = \"" + constant + "\".";
            else if (this.issueInformation.equals("UNKNOWN") && constant == null)
                this.issueInformation = sootString;
            else if (constant != null)
                this.issueInformation += " Value found = \"" + constant + "\".";

        }
        else //Cause
        {
            this.issueCause = Utils.retrieveCauseFromSootString(sootString);
            if (lineNum <= 0) {
                this.addMethod(methodName,
                        new AnalysisLocation(
                                Utils.retrieveLineNumFromSootString(sootString)));
            }


            if (constant != null)
                this.issueCause += " Value found = \"" + constant + "\".";
        }

        if (this.getMethods().empty())
            this.addMethod(methodName);


        if (sourcePaths.size() == 1) {
            String fullSource = sourcePaths.get(0);
            if (fullSource.endsWith(":dir"))
                this.fullPathName = Utils.osPathJoin(fullSource.replace(":dir", ""), "src", "main", "java", className.replace(".", System.getProperty("file.separator")) + ".java");
            else
                this.fullPathName = Utils.osPathJoin(fullSource, "src", "main", "java", className.replace(".", System.getProperty("file.separator")));
        }
        else {
            for (String in : sourcePaths)
                if (in.contains(className))
                    this.fullPathName = in;

            this.fullPathName = "UNKNOWN";
        }
    }

    //endregion

    //region Getters/Setters

    /**
     * <p>Setter for the field <code>fullPathName</code>.</p>
     *
     * @param fullPathName a {@link java.lang.String} object.
     */
    public void setFullPathName(String fullPathName) {
        this.fullPathName = fullPathName;
    }


    /**
     * <p>Getter for the field <code>fullPathName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFullPathName() {
        return fullPathName;
    }

    /**
     * <p>Getter for the field <code>className</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getClassName() {
        return className;
    }

    /**
     * <p>Getter for the field <code>rule</code>.</p>
     *
     * @return a {@link main.rule.engine.RuleList} object.
     */
    public RuleList getRule() {
        return rule;
    }

    /**
     * <p>getRuleId.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getRuleId() {
        return rule.getRuleId();
    }

    /**
     * <p>Getter for the field <code>methods</code>.</p>
     *
     * @return a {@link java.util.Stack} object.
     */
    public Stack getMethods() {

        if (this.methods == null) {
            this.methods = new Stack();
        }

        return this.methods;
    }

    /**
     * <p>Getter for the field <code>locations</code>.</p>
     *
     * @return a {@link java.util.ArrayList} object.
     */
    public ArrayList<AnalysisLocation> getLocations() {

        if (this.locations == null) {
            this.locations = new ArrayList<AnalysisLocation>();
        }

        return locations;
    }

    /**
     * <p>addLocation.</p>
     *
     * @param newLocation a {@link AnalysisLocation} object.
     */
    public void addLocation(AnalysisLocation newLocation) {
        this.getLocations().add(newLocation);
    }

    /**
     * <p>addMethod.</p>
     *
     * @param methodName a {@link java.lang.String} object.
     */
    public void addMethod(String methodName) {
        this.getMethods().push(String.valueOf(methodName));
    }

    /**
     * <p>addMethod.</p>
     *
     * @param methodName a {@link java.lang.String} object.
     * @param location   a {@link AnalysisLocation} object.
     */
    public void addMethod(String methodName, AnalysisLocation location) {
        location.setMethodNumber(this.getMethods().size());
        this.getMethods().push(String.valueOf(methodName));

        this.addLocation(location);
    }

    /**
     * <p>Getter for the field <code>issueInformation</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIssueInformation() {
        return issueInformation;
    }

    /**
     * <p>Getter for the field <code>issueCause</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIssueCause() {
        return issueCause;
    }
    //endregion
}