package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private HashMap<Long,TimeEntry> timeEntryHashMap=new HashMap<>();
    private Long currentId=1L;

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(timeEntryHashMap.values());
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id=currentId;
        TimeEntry entry=new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryHashMap.put(id,entry);
        ++currentId;
        return entry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntryHashMap.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id) ==null) return null;
        TimeEntry updatedEntry=new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryHashMap.replace(id,updatedEntry);
        return updatedEntry;
    }

    @Override
    public void delete(long timeEntryId) {
        timeEntryHashMap.remove(timeEntryId);
    }
}
