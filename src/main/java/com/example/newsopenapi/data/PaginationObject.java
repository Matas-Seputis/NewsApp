package com.example.newsopenapi.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaginationObject implements Serializable {

    @SerializedName("limit")
    private String limit;

    @SerializedName("offset")
    private String offset;

    @SerializedName("count")
    private String count;

    @SerializedName("total")
    private String total;

    public PaginationObject()
    {
    }

    public String getLimit()
    {
        return limit;
    }

    public String getOffset()
    {
        return offset;
    }

    public String getCount()
    {
        return count;
    }

    public String getTotal()
    {
        return total;
    }
}
