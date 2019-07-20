package com.bravostudio.mandiriwth2019.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jouvyalifpradewo on 2019-07-20.
 */
public class Response {
    @SerializedName("Exception")
    @Expose
    private Exception exception;
    @SerializedName("cif")
    @Expose
    private Cif cif;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Cif getCif() {
        return cif;
    }

    public void setCif(Cif cif) {
        this.cif = cif;
    }
}
