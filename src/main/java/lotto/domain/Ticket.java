package lotto.domain;

public class Ticket {

    private Integer id;
    private Lotto numbers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public void setTicket(Lotto numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
