package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Util;
import lotto.model.Rank;
import lotto.view.OutputView;

public class GameController {

    Util util = new Util();

    public void run() {
        InputController inputController = new InputController();
        OutputView outputView = new OutputView();

        int money = inputController.purchaseAmount();
        List<Lotto> lottos = buyLotto(money);
        outputView.lottoBuyHistory(lottos);

        List<Integer> winNumber = inputController.winNumbers();
        int bonusNumber = inputController.bonusNumber(winNumber);

        Map<Rank, Integer> result = getResult(lottos, winNumber, bonusNumber);
        int totalPrize = calculatePrize(result);
        double profitRate = calculateProfitRate(money, totalPrize);

        outputView.statistics(result, profitRate);
    }

    public List<Lotto> buyLotto(int money) {
        int count = money / 1000;

        List<Lotto> lottos = new ArrayList<>();
        Generator generator = new Generator();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = generator.lottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public int matchingWinNumber(List<Integer> lotto, List<Integer> winNumber, int bonus) {
        int matchCnt = 0;

        for (int num : lotto) {
            if (winNumber.contains(num)) {
                matchCnt++;
            }
        }

        if (lotto.contains(bonus)) {
            matchCnt++;
        }

        return matchCnt;
    }

    public Map<Rank, Integer> getResult(List<Lotto> lottos, List<Integer> winNumber, int bonus) {
        Map<Rank, Integer> result = Rank.initResultRepo();

        for (Lotto lotto : lottos) {
            Rank rank;
            int matchCnt = matchingWinNumber(lotto.getNumbers(), winNumber, bonus);
            rank = Rank.result(matchCnt, lotto.getNumbers().contains(bonus));

            result.replace(rank, result.get(rank) + 1);
        }

        return result;
    }

    public int calculatePrize(Map<Rank, Integer> result) {
        return Rank.calculatePrize(result);
    }

    public double calculateProfitRate(int cost, int totalPrize) {
        return (double) totalPrize / (double) cost * 100;
    }
}
