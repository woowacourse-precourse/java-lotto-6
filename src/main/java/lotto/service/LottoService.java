package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;

public class LottoService {
    private static final LottoService instance = new LottoService();

    public static LottoService getInstance() {
        return instance;
    }

    private LottoService() {
    }

    public List<Lotto> getLottoNumbers(int buyAmount) {
        List<Lotto> userLottos = new ArrayList<>();
        for (int i = 0; i < buyAmount; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            userLottos.add(lotto);
        }
        return userLottos;
    }
}
