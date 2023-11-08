package lotto.domain;

import static lotto.exception.ExceptionMessage.OUT_OF_LOTTO_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(){
        int lottoNumber = createLottoNumber();
        validateLottoNumberLength(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber(int lottoNumber) {
        validateLottoNumberLength(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int createLottoNumber(){
        return Randoms.pickNumberInRange(1,45);
    }

    private void validateLottoNumberLength(int lottoNumber) {
        if((lottoNumber < 1) || ( lottoNumber > 46)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_LENGTH.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}