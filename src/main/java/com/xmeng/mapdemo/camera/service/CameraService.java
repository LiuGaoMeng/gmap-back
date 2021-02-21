package com.xmeng.mapdemo.camera.service;

import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.xmeng.mapdemo.camera.domain.Camera;

import java.util.Map;

public interface CameraService {
    Map<String, Object> list(Camera camera, Integer pageNum, Integer pageSize);

    ResultForm save(Camera camera);

    ResultForm delete(String[] ids);

    Camera getById(String id);
}
