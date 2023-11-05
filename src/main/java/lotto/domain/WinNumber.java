package lotto.domain;

import java.util.List;
import lotto.valid.WinNumberValid;

public class WinNumber {

    private final List<Integer> lottoNums;

    public WinNumber(String lottoNum) {
        this.lottoNums = WinNumberValid.validWinNumber(lottoNum);
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }
}
