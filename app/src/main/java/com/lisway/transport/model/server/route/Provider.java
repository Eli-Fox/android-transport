
package com.lisway.transport.model.server.route;

import com.google.gson.annotations.SerializedName;

public class Provider {

    @SerializedName("provider_icon_url")
    private String providerIconUrl;
    @SerializedName("disclaimer")
    private String disclaimer;
    @SerializedName("ios_itunes_url")
    private String iosItunesUrl;
    @SerializedName("ios_app_url")
    private String iosAppUrl;
    @SerializedName("android_package_name")
    private String androidPackageName;
    @SerializedName("display_name")
    private String displayName;

    /**
     * 
     * @return
     *     The providerIconUrl
     */
    public String getProviderIconUrl() {
        return providerIconUrl;
    }

    /**
     * 
     * @param providerIconUrl
     *     The provider_icon_url
     */
    public void setProviderIconUrl(String providerIconUrl) {
        this.providerIconUrl = providerIconUrl;
    }

    /**
     * 
     * @return
     *     The disclaimer
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * 
     * @param disclaimer
     *     The disclaimer
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    /**
     * 
     * @return
     *     The iosItunesUrl
     */
    public String getIosItunesUrl() {
        return iosItunesUrl;
    }

    /**
     * 
     * @param iosItunesUrl
     *     The ios_itunes_url
     */
    public void setIosItunesUrl(String iosItunesUrl) {
        this.iosItunesUrl = iosItunesUrl;
    }

    /**
     * 
     * @return
     *     The iosAppUrl
     */
    public String getIosAppUrl() {
        return iosAppUrl;
    }

    /**
     * 
     * @param iosAppUrl
     *     The ios_app_url
     */
    public void setIosAppUrl(String iosAppUrl) {
        this.iosAppUrl = iosAppUrl;
    }

    /**
     * 
     * @return
     *     The androidPackageName
     */
    public String getAndroidPackageName() {
        return androidPackageName;
    }

    /**
     * 
     * @param androidPackageName
     *     The android_package_name
     */
    public void setAndroidPackageName(String androidPackageName) {
        this.androidPackageName = androidPackageName;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
