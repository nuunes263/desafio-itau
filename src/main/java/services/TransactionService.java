package services;

import model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction (Transaction transaction){
        transactions.add(transaction);
    }
}
