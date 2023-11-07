package lotto.system.shop.domain.ticket;

public abstract class Ticket<T> {

    private final T source;

    protected Ticket(T source) {
        this.source = source;
    }

    public T getSource() {
        return source;
    }
}
