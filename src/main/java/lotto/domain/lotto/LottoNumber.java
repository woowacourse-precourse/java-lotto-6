package lotto.domain.lotto;


import lotto.global.constant.message.ErrorMessage;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }


    public Integer getValue() {
        return number;
    }

    private void validate(int number) {
        validateNumbersRange(number);
    }

    private void validateNumbersRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return this.number == ((LottoNumber) o).number;
    }
}
