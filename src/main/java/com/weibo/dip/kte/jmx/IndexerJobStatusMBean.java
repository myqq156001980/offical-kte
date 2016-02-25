package com.weibo.dip.kte.jmx;

import com.weibo.dip.kte.jobs.IndexerJobStatusEnum;

public interface IndexerJobStatusMBean {
	long getLastCommittedOffset();
	IndexerJobStatusEnum getJobStatus();
	int getPartition();
}
