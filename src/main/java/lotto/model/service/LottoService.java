package lotto.model.service;

import lotto.model.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.constant.Constant.*;

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
        List<Integer> pickUniqueNumbersInRange = new ArrayList<>(pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBER_SIZE));
        Collections.sort(pickUniqueNumbersInRange);

        return pickUniqueNumbersInRange;
    }
}
