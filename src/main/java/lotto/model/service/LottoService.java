package lotto.model.service;

import lotto.model.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public List<Lotto> initLottoList(int purchaseAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lottoNumbers = pickLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public List<Integer> pickLottoNumbers() {
        List<Integer> pickUniqueNumbersInRange = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(pickUniqueNumbersInRange);

        return pickUniqueNumbersInRange;
    }
}
