package com.phonebook.controller;

import com.phonebook.domain.Record;
import com.phonebook.repo.RecordRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("records/{id}")
public class RecordController {
    private final RecordRepo recordRepo;

    @Autowired
    public RecordController(RecordRepo recordRepo) {
        this.recordRepo = recordRepo;
    }

    @GetMapping("{id}")
    public Record getRecordById(@PathVariable(value = "id") Record record) {
        return record;
    }

    @PostMapping
    public Record create(@RequestBody Record record) {
        return recordRepo.save(record);
    }

    @PutMapping("{id}")
    public Record update(@PathVariable(value = "id") Record recordFromDb,
                       @RequestBody Record record) {
        BeanUtils.copyProperties(record, recordFromDb, "id");
        return recordRepo.save(recordFromDb);
    }

    @DeleteMapping
    public void delete(@PathVariable(value = "id") Record record) {
        recordRepo.delete(record);
    }
}
