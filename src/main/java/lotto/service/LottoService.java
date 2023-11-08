package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_SIZE;
import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static lotto.constant.NumericConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumericConstant.MIN_LOTTO_NUMBER;

public class LottoService {

    private List<Lotto> userLottos = new ArrayList<>();
    
    public List<Lotto> buyLotto(int money) {
        int count = money / LOTTO_PRICE;

        userLottos = createLottos(count);
        return userLottos;
    }

    public LottoGameResult getResultOfLottos(Lotto winningLotto, int bonusNumber) {
        LottoGameResult lottoGameResult = new LottoGameResult();

        for (Lotto userLotto : userLottos) {
            LottoRank rank = userLotto.matching(winningLotto, bonusNumber);
            lottoGameResult.add(rank);
        }

        return lottoGameResult;
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> createdLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers
                    = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);

            createdLottos.add(new Lotto(numbers));
        }

        return createdLottos;
    }
}
