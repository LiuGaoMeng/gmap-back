package com.xmeng.mapdemo.camera.service.impl;

import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmeng.mapdemo.camera.domain.Camera;
import com.xmeng.mapdemo.camera.mapper.CameraMapper;
import com.xmeng.mapdemo.camera.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CameraServiceImpl implements CameraService {
    @Autowired
    private CameraMapper cameraMapper;
    @Override
    public Map<String, Object> list(Camera camera, Integer pageNum, Integer pageSize) {
        Map<String,Object> resultMap=new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> list=cameraMapper.list(camera);
        PageInfo<Map<String,Object>> pageList=new PageInfo<>(list);
        resultMap.put("data",pageList.getList());
        resultMap.put("total",pageList.getTotal());
        return resultMap;
    }

    @Override
    public ResultForm save(Camera camera) {
        int addFalg=0,updateFalg=0;
        if (camera.getId()!=null&&camera.getId()!=""){
             addFalg=cameraMapper.update(camera);
        }
        else{
            camera.setId(UUID.randomUUID().toString());
            updateFalg=cameraMapper.add(camera);
        }
        if (addFalg>0||updateFalg>0) {
            return new ResultForm(true, "操作成功！");
        }
        else{
            return new ResultForm(false, "操作失败！");
        }
    }

    @Override
    public ResultForm delete(String[] ids) {
        int delFalg=cameraMapper.delete(ids);
        if (delFalg>0){
            return new ResultForm(true,"删除成功!");
        }else{
            return new ResultForm(false,"删除失败!");
        }

    }

    @Override
    public Camera getById(String id) {
        Camera camera=cameraMapper.getById(id);
        return camera;
    }
}
