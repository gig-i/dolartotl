package com.example.dolartotl.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    private boolean success;
    private String terms;
    private String privacy;
    private float timestamp;
    private String source;

    @SerializedName("quotes")
    quotes QuotesObject;


    // Getter Methods

    public boolean getSuccess() {
        return success;
    }

    public String getTerms() {
        return terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public quotes getQuotes() {
        return QuotesObject;
    }

    // Setter Methods

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setQuotes(quotes quotesObject) {
        this.QuotesObject = quotesObject;
    }
}


