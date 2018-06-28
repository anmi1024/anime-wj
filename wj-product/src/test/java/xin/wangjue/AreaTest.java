package xin.wangjue;

import com.github.pagehelper.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import xin.wangjue.dao.AreaDao;
import xin.wangjue.domain.entity.Area;
import xin.wangjue.service.AreaService;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AreaTest {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private AreaService areaService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_listArea() {
        List<Area> areaList = areaDao.listArea();
        areaList.forEach(t -> System.out.println(t.getAreaName()+"---"+t.getCreateTime()));
    }

    @Test
    public void test_findAreaById() {
        Area area = areaDao.findAreaById(1);
        Assert.assertEquals("440104",area.getAreaCode());
    }

    @Test
    public void test_listAreaPage() {
        Page<Area> areas = areaService.listAreaPage(1,10);
        System.out.println(areas.getPages()+"-----"+areas.getTotal());
        areas.getResult().forEach(t -> System.out.println(t.getAreaName()+"---"+t.getCreateTime()));
    }

    @Test
    public void test_mockMvc_areas() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/areas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }


    @Test
    public void test() {

    }


}
