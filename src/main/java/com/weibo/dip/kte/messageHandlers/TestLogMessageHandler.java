package com.weibo.dip.kte.messageHandlers;

import com.weibo.dip.kte.ConsumerConfig;
import com.weibo.dip.kte.MessageHandler;
import com.weibo.dip.kte.mappers.TestMapper;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by fpschina on 16/2/19.
 */
public class TestLogMessageHandler extends MessageHandler {
    private Logger logger = LoggerFactory.getLogger(TestLogMessageHandler.class);
    private String[] slits = null;
    private TestMapper testLogMapper = null;
    private ObjectMapper mapper = new ObjectMapper();

    public TestLogMessageHandler(TransportClient client, ConsumerConfig config) throws Exception {
        super(client, config);
        logger.info("Initialized org.elasticsearch.kafka.consumer.messageHandlers.AccessLogMessageHandler");
    }

    @Override
    public byte[] transformMessage(byte[] inputMessage, Long offset) throws Exception {
        String outputMessageStr = this.convertToJson(new String(inputMessage, "UTF-8"));
        return outputMessageStr.getBytes();
    }

    public String convertToJson(String rawMsg) throws IOException {
        slits = rawMsg.split("&");
        testLogMapper = new TestMapper();
        testLogMapper.setUrl(slits[0]);
        testLogMapper.setTime(slits[1]);
        return mapper.writeValueAsString(testLogMapper);
    }

}
