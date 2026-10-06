package domain.entity;

import java.util.Comparator;

public enum SortOption {
    AMOUNT_ASC(Comparator.comparingDouble(Transaction::getAmount)),
    AMOUNT_DESC(Comparator.comparingDouble(Transaction::getAmount).reversed()),
    INCOME_FIRST(Comparator.comparing((Transaction t) -> t.getType() == TransactionType.INCOME ? 0 : 1)),
    EXPENSE_FIRST(Comparator.comparing((Transaction t) -> t.getType() == TransactionType.EXPENSE ? 0 : 1));

    private final Comparator<Transaction> comparator;

    SortOption(Comparator<Transaction> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Transaction> comparator() {
        return comparator;
    }
}
