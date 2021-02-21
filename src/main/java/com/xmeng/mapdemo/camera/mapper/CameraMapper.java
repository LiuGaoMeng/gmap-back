package com.xmeng.mapdemo.camera.mapper;

import com.xmeng.mapdemo.camera.domain.Camera;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CameraMapper {
    List<Map<String, Object>> list(Camera camera);

    int delete(String[] ids);

    Camera getById(@Param("id") String id);

    int update(Camera camera);

    int add(Camera camera);
}
