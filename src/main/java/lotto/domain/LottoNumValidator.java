package lotto.domain;

import lotto.util.Constants;
import lotto.util.Util;

import java.util.Collections;
import java.util.List;


public class LottoNumValidator {
    private final String lottoInput;
    public static List<Integer> lottoNums = null;
    public LottoNumValidator(String inputLottoNum) {
        this.lottoInput = inputLottoNum;
        Lotto.isRightNums(lottoInput);
        this.lottoNums = Util.toList(inputLottoNum);
        Collections.sort(this.lottoNums);
    }
}