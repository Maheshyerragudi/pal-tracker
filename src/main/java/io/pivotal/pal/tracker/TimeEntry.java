package io.pivotal.pal.tracker;


import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry() {
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.id=timeEntryId;
        this.projectId=projectId;
        this.userId=userId;
        this.date=date;
        this.hours=hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
     this.projectId=projectId;
     this.userId=userId;
     this.date=date;
     this.hours=hours;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEntry entry = (TimeEntry) o;

        if (id != entry.id) return false;
        if (projectId != entry.projectId) return false;
        if (userId != entry.userId) return false;
        if (hours != entry.hours) return false;
        return date.equals(entry.date);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + hours;
        return result;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
