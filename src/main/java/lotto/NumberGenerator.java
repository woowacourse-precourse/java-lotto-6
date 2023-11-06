package lotto;

import java.util.List;

public class NumberGenerator {
    private List<Integer> lottoNumbers;

    public void generateLottoNumbers() {
        lottoNumbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
