package com.zhou.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.ssm.dao.PictureDao;
import com.zhou.ssm.entity.Picture;
import com.zhou.ssm.service.PictureService;


@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureDao pd;

    public List<Picture> findPicture(Map<String, Object> map) {
        return pd.findPictures(map);
    }

    public Long getTotalPicture(Map<String, Object> map) {
        return pd.getTotalPictures(map);
    }

    public int addPicture(Picture picture) {
        if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
            return 0;
        }
        return pd.insertPicture(picture);
    }

    public int updatePicture(Picture picture) {
        if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
            return 0;
        }
        return pd.updPicture(picture);
    }

    public int deletePicture(String id) {
        return pd.delPicture(id);
    }

    public Picture findById(String id) {
        return pd.findPictureById(id);
    }

}
