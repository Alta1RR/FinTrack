package Altakus.FinTrack.repository;

import Altakus.FinTrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // Метод для поиска пользователя по email
    User findByUsername(String username); //  Метод для поиска пользователя по Username
}
