package com.gz.his.contorller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.gz.his.entity.HospitalInfo;
import com.gz.his.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class HospitalContorller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getHospitalInfo", consumes = "application/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public String getHospitalInfo(@RequestBody HospitalInfo h) throws Exception{

        Result result=new Result();
        if(h!=null || h.getHospitalId()!=null){
            HospitalInfo hospitalInfo=null;
            try {
                hospitalInfo =
                        jdbcTemplate.queryForObject("select * from hospital_info where hospital_id=? ",new BeanPropertyRowMapper<>(HospitalInfo.class),h.getHospitalId());

            }catch (Exception e){

            }

            if(hospitalInfo!=null){
                result.resultCode=0;
                result.resultDesc="成功";
                result.service="getHospitalInfo";
                result.hospitalId=hospitalInfo.getHospitalId();
                result.hospitalName=hospitalInfo.getHospitalName();
                result.addr=hospitalInfo.getAddr();
                result.tel=hospitalInfo.getTel();
                result.webSite=hospitalInfo.getWebSite();
                result.hospArea=hospitalInfo.getHospArea();
                result.hospLevel=hospitalInfo.getHospLevel();
                result.desc=hospitalInfo.getDesc();
                result.maxRegDays=hospitalInfo.getMaxRegDays();
                result.startRegTime=hospitalInfo.getStartRegTime();
                result.stopRegTime=hospitalInfo.getStopRegTime();
                result.stopBookTimeA=hospitalInfo.getStopBookTimeA();
                result.stopBookTimeM=hospitalInfo.getStopBookTimeM();
                if(result.desc==null){
                    result.desc="";
                }
            }else{
                result.resultCode=1;
                result.resultDesc="未查询到";
                result.service="getHospitalInfo";
            }
        }else{
            result.resultCode=2;
            result.resultDesc="请传入参数";
            result.service="getHospitalInfo";
        }

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        //System.out.println(xmlMapper.writeValueAsString(result));
        return xmlMapper.writeValueAsString(result);
    }

}
