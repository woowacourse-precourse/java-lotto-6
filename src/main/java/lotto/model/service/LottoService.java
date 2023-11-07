package lotto.model.service;

import lotto.model.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.util.constant.Constant.*;

public class LottoService {

    public List<Lotto> initLottoList(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount)
                .mapToObj(e -> new Lotto(pickLottoNumbers()))
                .toList();
    }

    public List<Integer> pickLottoNumbers() {
        List<Integer> pickUniqueNumbersInRange = new ArrayList<>(pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBER_SIZE));
        Collections.sort(pickUniqueNumbersInRange);

        return pickUniqueNumbersInRange;
    }
}
