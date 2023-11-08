package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);

        resultView.printLottos(lottos);

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);

        LottoResult lottoResult = getLottoResult(lottos, winningLotto);

        resultView.printResult(lottoResult, purchaseAmount);
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount / 1000; // 로또 1장의 가격은 1000원

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = LottoMachine.generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    private LottoResult getLottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatch(winningLotto.getWinningNumbers());
            boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            Rank rank = getRank(matchCount, matchBonus);
            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }

        return new LottoResult(result);
    }


    private Rank getRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return Rank.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Rank.SECOND;
        }
        if (matchCount == 5) {
            return Rank.THIRD;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return null; // 등수 외의 결과는 null을 반환합니다.
    }


}
