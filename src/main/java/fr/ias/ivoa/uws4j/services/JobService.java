package fr.ias.ivoa.uws4j.services;

import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.ias.ivoa.uws4j.domain.JobList;

@Component
public class JobService {

	public Optional<JobList> getJobListByName(String jobListName) {
		return Optional.ofNullable(null);
	}

}
