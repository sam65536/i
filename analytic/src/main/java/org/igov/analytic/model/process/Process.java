/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igov.analytic.model.process;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.igov.analytic.model.attribute.Attribute;
import org.igov.analytic.model.source.SourceDB;
import org.igov.model.core.AbstractEntity;
import org.igov.util.JSON.JsonDateDeserializer;
import org.igov.util.JSON.JsonDateSerializer;
import org.joda.time.DateTime;

/**
 *
 * @author olga
 */
@javax.persistence.Entity
public class Process extends AbstractEntity{
    
    @JsonProperty(value = "sID_")
    @Column
    private String sID_;
    
    @JsonProperty(value = "oSourceDB")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nID_SourceDB")
    //@ManyToOne(targetEntity = SourceDB.class)
    //@JoinColumn(name = "nID_SourceDB")
    private SourceDB oSourceDB;
    
    @JsonProperty(value = "oDateStart")
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @Type(type = DATETIME_TYPE)
    @Column
    private DateTime    oDateStart ;
    
    @JsonProperty(value = "oDateFinish")
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @Type(type = DATETIME_TYPE)
    @Column
    private DateTime    oDateFinish ;
    
    @JsonProperty(value = "sID_Data")
    @Column(name = "sID_Data")
    private String data;
    
    @JsonProperty(value = "aAttribute")
    @OneToMany(mappedBy = "oProcess", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Attribute> aAttribute = new ArrayList();
    
    @JsonProperty(value = "aProcessTask")
    @OneToMany(mappedBy = "oProcess", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProcessTask> aProcessTask = new ArrayList();

    public String getsID_() {
        return sID_;
    }

    public void setsID_(String sID_) {
        this.sID_ = sID_;
    }

    public SourceDB getoSourceDB() {
        return oSourceDB;
    }

    public void setoSourceDB(SourceDB oSourceDB) {
        this.oSourceDB = oSourceDB;
    }

    public DateTime getoDateStart() {
        return oDateStart;
    }

    public void setoDateStart(DateTime oDateStart) {
        this.oDateStart = oDateStart;
    }

    public DateTime getoDateFinish() {
        return oDateFinish;
    }

    public void setoDateFinish(DateTime oDateFinish) {
        this.oDateFinish = oDateFinish;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Attribute> getaAttribute() {
        return aAttribute;
    }

    public void setaAttribute(List<Attribute> aAttribute) {
        this.aAttribute = aAttribute;
    }

    public List<ProcessTask> getaProcessTask() {
        return aProcessTask;
    }

    public void setaProcessTask(List<ProcessTask> aProcessTask) {
        this.aProcessTask = aProcessTask;
    }
  
}
