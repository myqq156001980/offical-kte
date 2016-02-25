#!/bin/sh

java -Xmx1g -cp target/kafka-es-indexer-2.0.jar:target/kafka-es-indexer-2.0-lib/* com.weibo.dip.kte.KafkaIndexerDriver src/main/resources/kafka-es-indexer.properties


