package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository  {
    public List<TimeEntry> list();

    TimeEntry create(TimeEntry timeEntry);

    TimeEntry find(long timeEntryId);

    TimeEntry update(long id, TimeEntry timeEntry);

    void delete(long timeEntryId);
}
