package xin.wangjue.dao;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Component;
import xin.wangjue.domain.entity.Area;

import java.util.List;

@Component
public interface AreaDao {

    List<Area> listArea();

    Page<Area> listAreaPage();

    Area findAreaById(long id);
}
