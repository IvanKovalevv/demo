package com.phonebook.repo;

import com.phonebook.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record, Long> {
}
