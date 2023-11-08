package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView = new InputView();

    private List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = inputView.promptWinningNumbers();
        int bonusNumber = inputView.promptBonusNumber(winningLotto);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private Map<LottoRank, Integer> determineResults(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            resultMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            LottoRank rank = winningLotto.match(lotto);
            resultMap.merge(rank, 1, Integer::sum);
        }

        return resultMap;
    }

}
