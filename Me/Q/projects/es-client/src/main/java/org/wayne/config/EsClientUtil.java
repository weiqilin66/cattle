package org.wayne.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @TODO:
 * @author: lwq
 */
public class EsClientUtil {

    private static RestClient client;

    public static RestClient getInstance(List<Map<String,Object>> mapList){
        if (client==null) {
            final String host = "192.168.2.2";
            final RestClientBuilder builder = RestClient.builder(
                    new HttpHost(host,9202,"http")
            );
            client = builder.build();
        }
        return client;

    }
}
