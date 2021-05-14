package com.gz.his.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HospitalInfo {

    private Integer hospitalId;
    private String hospitalName;
    private String addr;
    private String tel;
    private String webSite;
    private Integer hospLevel;
    private Integer hospArea;
    private String desc;
    private Integer maxRegDays;
    private String startRegTime;
    private String stopRegTime;



    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public void setHospLevel(int hospLevel) {
        this.hospLevel = hospLevel;
    }

    public void setHospArea(int hospArea) {
        this.hospArea = hospArea;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setMaxRegDays(int maxRegDays) {
        this.maxRegDays = maxRegDays;
    }

    public void setStartRegTime(String startRegTime) {
        this.startRegTime = startRegTime;
    }

    public void setStopRegTime(String stopRegTime) {
        this.stopRegTime = stopRegTime;
    }

    public void setStopBookTimeM(String stopBookTimeM) {
        this.stopBookTimeM = stopBookTimeM;
    }

    public void setStopBookTimeA(String stopBookTimeA) {
        this.stopBookTimeA = stopBookTimeA;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getAddr() {
        return addr;
    }

    public String getTel() {
        return tel;
    }

    public String getWebSite() {
        return webSite;
    }

    public Integer getHospLevel() {
        return hospLevel;
    }

    public Integer getHospArea() {
        return hospArea;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getMaxRegDays() {
        return maxRegDays;
    }

    public String getStartRegTime() {
        return startRegTime;
    }

    public String getStopRegTime() {
        return stopRegTime;
    }

    public String getStopBookTimeM() {
        return stopBookTimeM;
    }

    public String getStopBookTimeA() {
        return stopBookTimeA;
    }

    private String stopBookTimeM;
    private String stopBookTimeA;




}
