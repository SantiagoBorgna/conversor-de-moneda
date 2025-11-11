package com.conversor.api;

import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    private String result;

    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")
    private double conversionRate;

    @SerializedName("conversion_result")
    private double conversionResult;

    // Constructor vacio
    public ApiResponse() {
    }

    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }
}