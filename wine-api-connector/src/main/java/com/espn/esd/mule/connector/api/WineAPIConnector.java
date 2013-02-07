/**
 * This file was automatically generated by the Mule Development Kit
 */
package com.espn.esd.mule.connector.api;

//import java.io.IOException;
//import org.mule.api.annotations.Connector;
//import org.mule.api.annotations.Connect;
//import org.mule.api.annotations.ValidateConnection;
//import org.mule.api.annotations.ConnectionIdentifier;
//import org.mule.api.annotations.Disconnect;
//import org.mule.api.ConnectionException;
//import org.mule.api.annotations.Configurable;
//import org.mule.api.annotations.Processor;
//import org.mule.api.annotations.rest.RestCall;
//import org.mule.api.annotations.rest.RestQueryParam;
//import org.mule.api.annotations.rest.RestUriParam;

import java.io.IOException;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.rest.RestCall;
import org.mule.api.annotations.rest.RestUriParam;
import org.mule.api.annotations.rest.RestQueryParam;


//http://services.wine.com/api/beta2/service.svc/json/catalog?size=1&filter=categories(490+143)&apiKey=XXXX


/**
 * Cloud Connector
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="wineapi", friendlyName="Wine Center API", schemaVersion="1.0-SNAPSHOT")
public abstract class WineAPIConnector
{    
    /**
     * Configurable
     */
    @Configurable
    @RestQueryParam("apikey")
    private String apikey = null;

    /**
     * Set property
     *
     * @param apiKey My property
     */
    public void setApikey(String apiKey)
    {
        this.apikey = apiKey;
    }

    /**
     * Get property
     */
    public String getApikey()
    {
        return this.apikey;
    }



     /*
     * 
     * 
     *         wine apis
     * 
     * 
     */    
    
    
     /**
     * List all wines by category
     *
     * {@sample.xml ../../../doc/WineAPI-connector.xml.sample wineapi:wine-by-category}
     *
     * @param categories name of category example categories(490+143)
     * @return json
     * @throws IOException connecting to the wine api
     * 
     * http://services.wine.com/api/beta2/service.svc/json/catalog?size=1&filter=categories(490+143)&apiKey=3XXXX
     */
    @Processor
    @RestCall(uri = "http://services.wine.com/api/beta2/service.svc/json/catalog?size=1&filter={categories}",
            method = org.mule.api.annotations.rest.HttpMethod.GET)
    public abstract String wineByCategory(@RestUriParam("categories") String categories) throws IOException;
        
    
    
}
