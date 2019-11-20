package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;


@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository=timeEntryRepository;

    }
@PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
    TimeEntry timeEntry1=timeEntryRepository.create(timeEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeEntry1) ;
    }
@GetMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry timeRead=timeEntryRepository.find(timeEntryId);

   if(timeRead==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    return ResponseEntity.ok(timeRead);
    }
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeList=timeEntryRepository.list();
        return ResponseEntity.status(HttpStatus.OK).body(timeList);
    }
@PutMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> update(@PathVariable long timeEntryId, @RequestBody TimeEntry timeEntry) {
    TimeEntry timeUpdate=timeEntryRepository.update(timeEntryId,timeEntry);
    if(timeUpdate==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    return ResponseEntity.status(HttpStatus.OK).body(timeUpdate);
}
    @DeleteMapping("{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {
         timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
