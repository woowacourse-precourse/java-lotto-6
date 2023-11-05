package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoRamdomNumbers {

    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public List<Lotto> generateRandomLottoNumbers(String readNumber) {
        int lottoCount = Integer.valueOf(readNumber) / 1000;
        for (int index = 0; index < lottoCount; index++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }
}
