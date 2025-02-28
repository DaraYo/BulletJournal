package com.example.bullet_journal.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bullet_journal.model.Task;

import java.util.List;

@Dao
public interface TaskEventDao {

    @Query("SELECT * FROM task_event WHERE id=:id")
    Task get(Long id);

    @Query("SELECT * FROM task_event WHERE day_id=:id AND type='TASK' AND deleted = 0 ORDER BY date")
    List<Task> getAllTasksForDay(Long id);

    @Query("SELECT * FROM task_event WHERE day_id=:id AND type='EVENT' AND deleted = 0 ORDER BY date")
    List<Task> getAllEventsForDay(Long id);

    @Query("SELECT * FROM task_event WHERE day_id=:id AND date > :millis AND deleted = 0 AND status = 0 ORDER BY date")
    List<Task> getFollowingTasksAndEventsForDay(Long id, long millis);

    @Query("SELECT * FROM task_event WHERE day_id=:id AND deleted = 0 ORDER BY date")
    List<Task> getAllForDay(Long id);

    @Query("SELECT * FROM task_event")
    List<Task> getAll();

    @Query("SELECT * FROM task_event WHERE firestore_id IS NULL AND synced = 0")
    List<Task> getAllForInsert();

    @Query("SELECT * FROM task_event WHERE firestore_id IS NOT NULL AND synced = 0")
    List<Task> getAllForUpdate();

    @Query("SELECT * FROM task_event WHERE deleted = 1")
    List<Task> getAllForDelete();

    @Insert
    long insert(Task task);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);


}
