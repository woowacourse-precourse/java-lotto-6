package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;

public class LottoService {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

    public List<Lotto> getLottoNumbers(int buyAmount) {
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < buyAmount; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            userLottos.add(lotto);
        }
        return userLottos;
    }
}
