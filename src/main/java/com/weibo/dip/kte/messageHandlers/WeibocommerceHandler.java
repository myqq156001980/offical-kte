package com.weibo.dip.kte.messageHandlers;

import com.google.gson.Gson;
import com.sun.javafx.collections.MappingChange;
import com.weibo.dip.kte.ConsumerConfig;
import com.weibo.dip.kte.MessageHandler;
import com.weibo.dip.kte.mappers.WeiboecommerceMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fpschina on 16/2/24.
 */
public class WeibocommerceHandler extends MessageHandler {
    private Logger logger = LoggerFactory.getLogger(WeibocommerceHandler.class);
    private String[] splittedMsg = null;
    private WeiboecommerceMapper weiboCommerceMapper = new WeiboecommerceMapper();
    private ObjectMapper mapper = new ObjectMapper();


    public WeibocommerceHandler(TransportClient client, ConsumerConfig config) throws Exception {
        super(client, config);
        logger.info("Initialized org.elasticsearch.kafka.consumer.messageHandlers.WeibommerceHandler");
    }


    @Override
    public byte[] transformMessage(byte[] inputMessage, Long offset) throws Exception {
        String outputMessageStr = this.convertToJson(new String(inputMessage, "UTF-8"), offset);
        return outputMessageStr.getBytes();
    }

    public String convertToJson(String rawMsg, Long offset) throws Exception {
        this.splittedMsg = rawMsg.split("\t");
        for (int i = 0; i < this.splittedMsg.length; i++) {
            this.splittedMsg[i] = this.splittedMsg[i].trim();
        }

        Map<String, Object> jMap = new HashMap<>();
        jMap.put("dataType", splittedMsg[0]);
        jMap.put("@timestamp", splittedMsg[1]);
        jMap.put("cTime", splittedMsg[2]);
        jMap.put("clientIP", splittedMsg[3]);
        jMap.put("serverIP", splittedMsg[4]);
        jMap.put("requestID", splittedMsg[5]);
        jMap.put("requestURL", splittedMsg[6]);
        jMap.put("responseTime", splittedMsg[7]);
        jMap.put("code", splittedMsg[8]);
        jMap.put("msg", splittedMsg[9]);
        jMap.put("dataLen", splittedMsg[10]);
        jMap.put("dataVal", splittedMsg[11]);

        Gson gson = new Gson();

        return gson.toJson(jMap);

//
//        weiboCommerceMapper.setDataType(splittedMsg[0]);
//        weiboCommerceMapper.setTimeStamp(splittedMsg[1]);
//        weiboCommerceMapper.setcTime(splittedMsg[2]);
//        weiboCommerceMapper.setClientIP(splittedMsg[3]);
//        weiboCommerceMapper.setServerIP(splittedMsg[4]);
//        weiboCommerceMapper.setRequestID(splittedMsg[5]);
//        weiboCommerceMapper.setRequestURL(splittedMsg[6]);
//        weiboCommerceMapper.setCode(splittedMsg[7]);
//        weiboCommerceMapper.setMsg(splittedMsg[8]);
//        weiboCommerceMapper.setDataLen(splittedMsg[9]);
//        weiboCommerceMapper.setDataVal(splittedMsg[11]);

//        return mapper.writeValueAsString(weiboCommerceMapper);

    }


}
