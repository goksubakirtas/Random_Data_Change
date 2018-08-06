package com.example.Random_Data_Change.user_data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u.name from User u")
    public List<String> getName();

    @Query("select u from User u")
    public List<String> getAllUser();

}
