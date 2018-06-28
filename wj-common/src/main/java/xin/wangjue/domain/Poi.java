package xin.wangjue.domain;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.io.Serializable;

@ExcelTarget("poi")
public class Poi implements Serializable {
    private Integer id;
    @Excel(name = "地库中心" ,orderNum = "1" ,needMerge = true)
    private String wms;
    @Excel(name = "客户类型" ,orderNum = "3")
    private String customType;
    @Excel(name = "VIN码" , orderNum = "2")
    private String vin;

    public Poi(String wms, String customType, String vin) {
        this.wms = wms;
        this.customType = customType;
        this.vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWms() {
        return wms;
    }

    public void setWms(String wms) {
        this.wms = wms;
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
