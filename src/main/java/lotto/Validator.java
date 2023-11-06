package lotto;

public class Validator {

    int validateCash(int cash) {
        int validCash;

        if (cash % 1000 != 0) {
            throw new IllegalArgumentException();
        }

        validCash = cash / 1000;

        return validCash;
    }
}
