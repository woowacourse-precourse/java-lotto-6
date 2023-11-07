package lotto.model;

public class LottoNumber {
    // Fields, Constructor
    private final int number;

    public LottoNumber(String string) {
        int number = validate(string);
        this.number = number;
    }


    // Features
    public int getNumber() {
        return number;
    }


    // Internal Implements
    private int validate(String string) {
        int number = parseToNumber(string);
        validateRange(number);

        return number;
    }

    private int parseToNumber(String string) {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    private void validateRange(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

}
