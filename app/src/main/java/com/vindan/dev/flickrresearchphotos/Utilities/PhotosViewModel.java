package com.vindan.dev.flickrresearchphotos.Utilities;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vindan.dev.flickrresearchphotos.models.apiPhotosModel.Photo;

import java.util.List;

public class PhotosViewModel extends ViewModel {
    private MutableLiveData<List<Photo>> list = new MutableLiveData<>();

    public MutableLiveData<List<Photo>> getList() {
        return list;
    }

    public void setList(MutableLiveData<List<Photo>> list) {
        this.list = list;
    }
}
