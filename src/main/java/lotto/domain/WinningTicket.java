package lotto.domain;

public class WinningTicket {

    private Lotto numbers;

    public Lotto getNumbers() {
        return numbers;
    }

    public void setNumbers(Lotto numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
