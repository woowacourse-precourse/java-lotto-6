package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoConstant;

public class PlayerLottos {

    private final List<Lotto> lottos;

    public PlayerLottos(int lottoAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = createRandomLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    private List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER.get(),
                LottoConstant.MAX_LOTTO_NUMBER.get(),
                LottoConstant.LOTTO_NUMBERS_LENGTH.get()
        );
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}