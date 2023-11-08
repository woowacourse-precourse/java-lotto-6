package lotto.model;

import java.util.Objects;
import lotto.utils.Constants;

public class LottoNumber {
    // Fields, Constructors
    private final int RANGE_MIN = Constants.RANGE_MIN.getValue();
    private final int RANGE_MAX = Constants.RANGE_MAX.getValue();
    private final int number;

    public LottoNumber(String string) {
        int number = parseToNumber(string);
        validate(number);
        this.number = number;
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }


    // Features
    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


    // Internal Implements
    private int validate(int number) {
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
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

}
