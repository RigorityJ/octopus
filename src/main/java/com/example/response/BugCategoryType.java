//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.26 at 05:36:24 PM EST 
//


package com.example.response;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for BugCategoryType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BugCategoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="group" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="bytes" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author drmonster
 * @version $Id: $Id
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BugCategoryType")
public class BugCategoryType {

    @XmlAttribute(name = "group", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String group;
    @XmlAttribute(name = "code", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String code;
    @XmlAttribute(name = "count", required = true)
    protected int count;
    @XmlAttribute(name = "bytes", required = true)
    protected int bytes;

    /**
     * Gets the value of the group property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     *
     * @param value allowed object is
     *              {@link java.lang.String}
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link java.lang.String}
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the count property.
     *
     * @return a int.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     *
     * @param value a int.
     */
    public void setCount(int value) {
        this.count = value;
    }

    /**
     * Gets the value of the bytes property.
     *
     * @return a int.
     */
    public int getBytes() {
        return bytes;
    }

    /**
     * Sets the value of the bytes property.
     *
     * @param value a int.
     */
    public void setBytes(int value) {
        this.bytes = value;
    }

}
