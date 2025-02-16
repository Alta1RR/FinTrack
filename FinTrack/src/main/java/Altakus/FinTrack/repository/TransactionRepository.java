package Altakus.FinTrack.repository; // <---- Исправленный пакет

import Altakus.FinTrack.model.Transaction; // <----  Импорт вашей сущности Transaction
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> { // <---- Исправленный тип JpaRepository
    Transaction findByDate(Date date); // Метод для поиска Транкзации по дате
}