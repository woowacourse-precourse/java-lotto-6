package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        try {
            int purchaseAmount = inputView.promptPurchaseAmount();
            List<Lotto> lottos = generateLottos(purchaseAmount / 1000);
            outputView.displayLottos(lottos.size(), lottos);

            WinningLotto winningLotto = getWinningLotto();

            Map<LottoRank, Integer> results = determineResults(lottos, winningLotto);
            outputView.displayResults(results);
            outputView.displayProfitRate(results, purchaseAmount);
        } catch (IllegalArgumentException e) {
            outputView.displayError(e.getMessage());
        }
    }

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
