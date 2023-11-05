package lotto.domain;

public class LottoNumber {
    private static final Integer MAX_LOTTO_NUMBER = 45;
    private static final Integer MIN_LOTTO_NUMBER = 1;



    private Integer lottoNumber;


    public LottoNumber(Integer intNumber) {
        validateRange(intNumber);
    }

    private void validateRange(Integer intNumber) {
        if (intNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 수로 구성되어야합니다");
        }

        if (intNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하의 수로 구성되어야합니다");
        }
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }
}
