
package com.lisway.transport.model.server.route;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Properties implements Serializable {

    @SerializedName("companies")
    private List<Company> companies = new ArrayList<Company>();

    /**
     * 
     * @return
     *     The companies
     */
    public List<Company> getCompanies() {
        return companies;
    }

    /**
     * 
     * @param companies
     *     The companies
     */
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
