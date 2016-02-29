package com.weibo.dip.kte;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * 根据需要创建索引,将不需要全文检索的字段的属性设置为 not_analyzed,还可以设置其他属性
 * Created by fpschina on 16/2/29.
 */
public class CreateIndex {
    private TransportClient client = null;

    public CreateIndex() throws UnknownHostException {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "dip-application")
                .build();
        client = TransportClient.builder().settings(settings).build();
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.13.56.52"), 9300));
    }

    public static void myPrint() throws IOException {
        XContentBuilder builder = XContentFactory
                .jsonBuilder()
                .startObject()
                .startObject("sina")
                .startObject("properties")

                .startObject("article_title")
                .field("type", "string")
                .field("store", "yes")
                .field("index", "not_analyzed")
                .endObject()

                .startObject("article_content")
                .field("type", "string")
                .field("store", "no")
                .field("index", "analyzed")
                .endObject()

                .startObject("article_url")
                .field("type", "string")
                .field("store", "yes")
                .field("index", "not_analyzed")
                .endObject()

                .endObject()
                .endObject()
                .endObject();

        System.out.println(builder.string());
    }


    public void createIndex() throws IOException {
        XContentBuilder builder = XContentFactory
                .jsonBuilder()
                .startObject()
                .startObject("sina")
                .startObject("properties")

                .startObject("article_title")
                .field("type", "string")
                .field("store", "yes")
                .field("index", "not_analyzed")
                .endObject()

                .startObject("article_content")
                .field("type", "string")
                .field("store", "no")
                .field("index", "analyzed")
                .endObject()

                .startObject("article_url")
                .field("type", "string")
                .field("store", "yes")
                .field("index", "not_analyzed")
                .endObject()

                .endObject()
                .endObject()
                .endObject();

        System.out.println(builder.string());
        client.admin().indices().prepareCreate("pages").execute().actionGet();

        PutMappingRequest putMappingRequest = Requests.putMappingRequest("pages").type("sina").source(builder);
        client.admin().indices().putMapping(putMappingRequest).actionGet();

        client.close();


    }

    public void postData() throws IOException {
        IndexResponse response = client.prepareIndex("pages", "sina", null)
                .setSource(jsonBuilder()
                        .startObject()
                        .field("article_title", "myTitle")
                        .field("article_content", "myContent")
                        .field("article_url", "www.sina.com")
                        .endObject()
                )
                .execute()
                .actionGet();

    }

    public static void main(String[] args) {
        try {
            CreateIndex indexTest = new CreateIndex();
            indexTest.createIndex();
            indexTest.postData();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
