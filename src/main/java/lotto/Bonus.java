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
        if(!isValidRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(int number) {
        if(number < 1 || number > 45) {
            return false;
        }
        return true;
    }

    public int getNumber() {
        return number;
    }
}
