package sattar.androidnewsapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NewsDao {

    // Добавление News в бд
    @Insert
    void insert(News... news);

    // Удаление News из бд
    @Delete
    void delete(News news);

    // Получение всех News из бд
    @Query("SELECT * FROM news")
    List<News> getAll();

    // Получение всех News из бд с условием
    @Query("SELECT * FROM news WHERE id LIKE :id")
    List<News> getById(int id);

}