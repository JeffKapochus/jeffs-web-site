package com.thisguywritescode.repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.thisguywritescode.models.ContactSubmission;

@Component
@Repository
public interface ContactSubmissionRepository extends JpaRepository<ContactSubmission, Integer> {

	List<ContactSubmission> findByName(String name) throws DataAccessException;

	List<ContactSubmission> findByEmail(String email) throws DataAccessException;

}
