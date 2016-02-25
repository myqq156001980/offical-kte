package com.weibo.dip.kte.jmx;

import java.util.List;

import com.weibo.dip.kte.jobs.IndexerJobManager;
import com.weibo.dip.kte.jobs.IndexerJobStatusEnum;
import com.weibo.dip.kte.jobs.IndexerJobStatus;

public class KafkaEsIndexerStatus implements KafkaEsIndexerStatusMXBean {

	protected IndexerJobManager indexerJobManager;
	private int failedJobs;
	private int cancelledJobs;
	private int stoppedJobs;
	private int hangingJobs;

	public KafkaEsIndexerStatus(IndexerJobManager indexerJobManager) {
		this.indexerJobManager = indexerJobManager;
	}

	public boolean isAlive() {
			return true;
	}

	public List<IndexerJobStatus> getStatuses() {
		return indexerJobManager.getJobStatuses();
	}

	public int getCountOfFailedJobs() {
		failedJobs = 0;
		for (IndexerJobStatus jobStatus : indexerJobManager.getJobStatuses()) {
			if (jobStatus.getJobStatus().equals(IndexerJobStatusEnum.Failed)){
				failedJobs++;
			}
		}
		return failedJobs;
	}

	public int getCountOfStoppedJobs() {
		stoppedJobs = 0;
		for (IndexerJobStatus jobStatus : indexerJobManager.getJobStatuses()) {
			if (jobStatus.getJobStatus().equals(IndexerJobStatusEnum.Stopped)){
				stoppedJobs++;
			}
		}
		return stoppedJobs;
	}
	
	public int getCountOfHangingJobs() {
		hangingJobs = 0;
		for (IndexerJobStatus jobStatus : indexerJobManager.getJobStatuses()) {
			if (jobStatus.getJobStatus().equals(IndexerJobStatusEnum.Hanging)){
				hangingJobs++;
			}
		}
		return hangingJobs;
	}

	public int getCountOfCancelledJobs() {
		cancelledJobs = 0;
		for (IndexerJobStatus jobStatus : indexerJobManager.getJobStatuses()) {
			if (jobStatus.getJobStatus().equals(IndexerJobStatusEnum.Cancelled)){
				cancelledJobs++;
			}
		}
		return cancelledJobs;
	}

}
