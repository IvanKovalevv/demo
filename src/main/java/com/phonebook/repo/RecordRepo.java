package com.phonebook.repo;

import com.phonebook.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepo extends JpaRepository<Record, Long> {
}
