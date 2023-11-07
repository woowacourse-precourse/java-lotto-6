package lotto.vo;

public final class TicketCount {
    private final int count;

    private TicketCount(int count) {
        this.count = count;
    }

    public static TicketCount from(int count) {
        return new TicketCount(count);
    }

    public int getCount() {
        return count;
    }

    public void forEach(Runnable action) {
        for (int i = 0; i < count; i++) {
            action.run();
        }
    }
}
