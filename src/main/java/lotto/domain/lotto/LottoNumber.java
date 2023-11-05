package lotto.domain.lotto;


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
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
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
