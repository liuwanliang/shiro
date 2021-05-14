package com.gz.his.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

@JacksonXmlRootElement(localName ="res")
public class Result {

    public int resultCode;
    public String resultDesc;

    @JacksonXmlProperty(isAttribute = true,localName = "service")
    public String service;
    public Integer hospitalId;
    public String hospitalName;
    public String addr;
    public String tel;
    public String webSite;
    public Integer hospLevel;
    public Integer hospArea;
    public String desc;
    public Integer maxRegDays;
    public String startRegTime;
    public String stopRegTime;
    public String stopBookTimeM;
    public String stopBookTimeA;

    /*private int resultCode;
    private String resultDesc;
    private String service;


    public void setService(String service) {
        this.service = service;
    }

    @JacksonXmlProperty(isAttribute = true,localName = "service")
    public String getService() {
        return service;
    }

    *//*@XmlElement(name="")
    private HospitalInfo hospitalInfo;*//*

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

   *//* public void setHospitalInfo(HospitalInfo hospitalInfo) {
        this.hospitalInfo = hospitalInfo;
    }*//*

    public int getResultCode() {
        return resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    *//*public HospitalInfo getHospitalInfo() {
        return hospitalInfo;
    }*/
}
