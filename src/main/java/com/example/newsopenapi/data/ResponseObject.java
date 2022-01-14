package com.example.newsopenapi.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseObject implements Serializable {
    @SerializedName("pagination")
    private PaginationObject paginationObject;
    @SerializedName("data")
    private List<NewsObject> newsObjects;

    public ResponseObject()
    {

    }

    public PaginationObject getPaginationObject()
    {
        return paginationObject;
    }

    public List<NewsObject> getNewsObjectList()
    {
        return newsObjects;
    }
}
