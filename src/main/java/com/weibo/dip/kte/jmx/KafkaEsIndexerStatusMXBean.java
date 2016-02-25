package com.weibo.dip.kte.jmx;

import java.util.List;

import com.weibo.dip.kte.jobs.IndexerJobStatus;

public interface KafkaEsIndexerStatusMXBean {
	boolean isAlive();
	List <IndexerJobStatus> getStatuses();
	int getCountOfFailedJobs();
	int getCountOfCancelledJobs();
	int getCountOfStoppedJobs();
	int getCountOfHangingJobs();

}
