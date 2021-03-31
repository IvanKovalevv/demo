package com.phonebook.controller;

import com.phonebook.exceptions.NotFoundException;
import com.phonebook.model.Record;
import com.phonebook.repo.RecordRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("records")
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

    @PutMapping
    public Record update(@PathVariable(value = "id") Record recordFromDb, @RequestBody Record record) {
        Record records = recordRepo.findById(record.getId()).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(records, recordFromDb, "id");
        return recordRepo.save(recordFromDb);
    }

    @DeleteMapping
    public void delete(@RequestBody Record record) {
        recordRepo.delete(record);
    }


}
