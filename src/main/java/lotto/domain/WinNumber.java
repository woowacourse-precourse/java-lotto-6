package lotto.domain;

import java.util.List;
import lotto.valid.WinNumberValid;

public class WinNumber {

    private final List<Integer> lottoNums;

    public WinNumber(String lottoNum) {
        List<Integer> lottoNums = WinNumberValid.validWinNumber(lottoNum);
        this.lottoNums = lottoNums;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }
}
