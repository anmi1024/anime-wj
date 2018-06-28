package xin.wangjue.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import xin.wangjue.domain.Poi;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PoiTest {
    public static void main(String[] args) {
        try {
            new PoiTest().test();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void test() throws Throwable{
        List list = new ArrayList();
        list.add(new Poi("bj","cs","011"));
        list.add(new Poi("sh","dsc","022"));
        list.add(new Poi("cs","hh","033"));
        HSSFWorkbook workbook = (HSSFWorkbook) ExcelExportUtil.exportExcel(new ExportParams("111","222","333"),Poi.class,list);
        workbook.write(new FileOutputStream("/Users/anmi/Desktop/wangjue/temp/test.xlsx"));
    }
}
