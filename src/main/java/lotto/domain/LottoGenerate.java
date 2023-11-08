package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerate {

    public List<Lotto> generateLottoNumbers(int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

}

