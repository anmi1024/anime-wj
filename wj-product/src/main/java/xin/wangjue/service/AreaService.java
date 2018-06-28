package xin.wangjue.service;

import com.github.pagehelper.Page;
import xin.wangjue.domain.entity.Area;

public interface AreaService {
    Page<Area> listAreaPage(int pageNO ,int pageSize);

    Area findAreaById(long id);
}
