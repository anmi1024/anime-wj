package xin.wangjue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.wangjue.dao.AreaDao;
import xin.wangjue.domain.entity.Area;
import xin.wangjue.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Page<Area> listAreaPage(int pageNO, int pageSize) {
        PageHelper.startPage(pageNO,pageSize);
        return areaDao.listAreaPage();
    }

    @Override
    public Area findAreaById(long id) {
        return areaDao.findAreaById(id);
    }
}
