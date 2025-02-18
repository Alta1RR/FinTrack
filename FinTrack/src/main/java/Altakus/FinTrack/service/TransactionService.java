package Altakus.FinTrack.service;

import Altakus.FinTrack.model.Transaction;
import Altakus.FinTrack.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

}
