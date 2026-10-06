package adapter.repository;

import domain.entity.Transaction;
import domain.entity.TransactionType;
import domain.repository.ITransactionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionRepository implements ITransactionRepository {
    private final List<Transaction> data = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Transaction> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Transaction> findById(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public Transaction save(String description, double amount, TransactionType type) {
        Transaction t = new Transaction(++idCounter, description, amount, type);
        data.add(t);
        return t;
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(t -> t.getId() == id);
    }

    @Override
    public void update(Transaction transaction) {
    }
}
