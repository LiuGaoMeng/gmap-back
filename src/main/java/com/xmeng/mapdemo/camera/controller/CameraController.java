package com.xmeng.mapdemo.camera.controller;

import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.xmeng.mapdemo.camera.domain.Camera;
import com.xmeng.mapdemo.camera.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("cameraRestController")
@RequestMapping("/camera")
public class CameraController {
    @Autowired
    private CameraService cameraService;
    @RequestMapping("/list")
    public Map<String,Object> list(Camera camera, @RequestParam(value = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "999999999") Integer pageSize){
        return cameraService.list(camera,pageNum,pageSize);
    }
    @RequestMapping("/save")
    public ResultForm save(@RequestBody Camera camera){
        return cameraService.save(camera);
    }
    @RequestMapping("/delete")
    public ResultForm delete(@RequestBody String[] ids){
        return cameraService.delete(ids);
    }
    @RequestMapping("/getById")
    public Camera getById(@RequestParam("id") String id){
        return cameraService.getById(id);
    }

}
