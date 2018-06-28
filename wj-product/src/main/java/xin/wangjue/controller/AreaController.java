package xin.wangjue.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.wangjue.domain.entity.Area;
import xin.wangjue.service.AreaService;

@RestController
@RequestMapping("/areas")
@Api("Swagger 初次尝试")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ApiOperation("获取分页列表信息")
    @ApiResponses({
            @ApiResponse(code=400,message="呵呵搭"),
            @ApiResponse(code=404,message="404你懂得！")
    })
    @ApiImplicitParam(name = "pageInfo" ,value = "分页基础信息" ,dataType = "PageInfo")
    @RequestMapping(value = "" ,method = RequestMethod.POST)
    public Page<Area> getAreaList(@RequestBody PageInfo pageInfo) {
        return areaService.listAreaPage(1,10);
    }

    @ApiOperation("获取单个信息")
    @ApiImplicitParam(name = "id" ,value = "主键ID" ,required = true ,dataType = "Long")
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Area getArea(@PathVariable Long id) {
        return areaService.findAreaById(id);
    }
}
