
package com.lisway.transport.model.server.route;

import com.google.gson.annotations.SerializedName;

public class ProviderAttributes {

    @SerializedName("vbb")
    private Provider vbb;
    @SerializedName("drivenow")
    private Provider drivenow;
    @SerializedName("car2go")
    private Provider car2go;
    @SerializedName("google")
    private Provider google;
    @SerializedName("nextbike")
    private Provider nextbike;
    @SerializedName("callabike")
    private Provider callabike;

    /**
     * 
     * @return
     *     The vbb
     */
    public Provider getVbb() {
        return vbb;
    }

    /**
     * 
     * @param vbb
     *     The vbb
     */
    public void setVbb(Provider vbb) {
        this.vbb = vbb;
    }

    /**
     * 
     * @return
     *     The drivenow
     */
    public Provider getDrivenow() {
        return drivenow;
    }

    /**
     * 
     * @param drivenow
     *     The drivenow
     */
    public void setDrivenow(Provider drivenow) {
        this.drivenow = drivenow;
    }

    /**
     * 
     * @return
     *     The car2go
     */
    public Provider getCar2go() {
        return car2go;
    }

    /**
     * 
     * @param car2go
     *     The car2go
     */
    public void setCar2go(Provider car2go) {
        this.car2go = car2go;
    }

    /**
     * 
     * @return
     *     The google
     */
    public Provider getGoogle() {
        return google;
    }

    /**
     * 
     * @param google
     *     The google
     */
    public void setGoogle(Provider google) {
        this.google = google;
    }

    /**
     * 
     * @return
     *     The nextbike
     */
    public Provider getNextbike() {
        return nextbike;
    }

    /**
     * 
     * @param nextbike
     *     The nextbike
     */
    public void setNextbike(Provider nextbike) {
        this.nextbike = nextbike;
    }

    /**
     * 
     * @return
     *     The callabike
     */
    public Provider getCallabike() {
        return callabike;
    }

    /**
     * 
     * @param callabike
     *     The callabike
     */
    public void setCallabike(Provider callabike) {
        this.callabike = callabike;
    }

}
