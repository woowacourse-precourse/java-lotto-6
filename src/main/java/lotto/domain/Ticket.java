package lotto.domain;

public class Ticket {

    private final Integer value;

    public Ticket(Integer value) {
        this.value = value;
    }

    public Integer toValue() {
        return value;
    }
}
