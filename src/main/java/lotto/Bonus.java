package lotto;

public class Bonus {
    private final int number;

    public Bonus(int number, Lotto winningNumbers) {
        validate(number, winningNumbers);
        this.number = number;
    }

    private void validate(int number, Lotto winningNumbers) {
        if(winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }
}
