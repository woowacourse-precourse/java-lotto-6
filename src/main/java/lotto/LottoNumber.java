package lotto;

import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public boolean calculateScore(int number) {
        return lottoNumber.contains(number);
    }
}
