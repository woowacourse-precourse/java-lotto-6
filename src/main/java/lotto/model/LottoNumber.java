package lotto.model;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

public class LottoNumber {
    private List<Integer> lottoNumbers;
    private String SEPERATOR = ",";

    public LottoNumber() {
        this.generateLottoNumbers();
    }

    private void generateLottoNumbers() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.START_NUMBER.getValue(),
                LottoConstant.END_NUMBER.getValue(),
                LottoConstant.DIGITS.getValue()
        );
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
