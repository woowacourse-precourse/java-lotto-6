package lotto.domain.vo;

public class TicketCount {
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
}
