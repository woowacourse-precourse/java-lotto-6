package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static final int PERCENTAGE = 100;

    private Player player;
    private List<Integer> lotto;
    private List<Lotto> lottos;
    private WinningResult winningResult;


    public void run() {
        int lottoCount = inputPlayerCount();
        OutputView.printLottoCount(lottoCount);

        lottos = makeLottos(lottoCount);
        winningResult = validateBonus();

        lottoResult(lottos, winningResult, lottoCount);
    }

    public WinningResult validateBonus() {
        Lotto lotto = new Lotto(InputView.inputLottoWinNumber());
        List<Integer> winningNumbers = lotto.getLottoNumbers();

        int bonusNumber = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumbers, bonusNumber);
        winningResult = new WinningResult(new Lotto(winningNumbers), bonusNumber);

        return winningResult;
    }

    private int inputPlayerCount() {
        player = new Player(InputView.inputPlayerLottoPrice());
        return player.getCount();
    }

    private Lotto makeLotto() {
        LottoNumber lottoNumber = new LottoNumber();
        lotto = lottoNumber.setLottoNumber();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private List<Lotto> makeLottos(int lottoCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private void lottoResult(List<Lotto> lottos, WinningResult winningLotto, int count) {
        Map<Ranking, Integer> result = setResult();
        Ranking ranking;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottos.size(); i++) {
            ranking = winningLotto.match(lottos.get(i));
            result.put(ranking, result.get(ranking) + 1);
        }
        printResult(result);
        printEarningRate(result, count);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoCount) {
        double EarningRate = 0.0;
        for (Ranking rank : result.keySet()) {
            EarningRate = EarningRate + ((double) (rank.getWinningAmount()) / (lottoCount * Player.LOTTO_PRICE) * (result.get(rank)) * PERCENTAGE);
        }
        OutputView.printRevenueRate(EarningRate);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
