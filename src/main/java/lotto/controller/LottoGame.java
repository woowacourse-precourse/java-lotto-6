package lotto.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoSeller;
import lotto.model.Rank;
import lotto.model.RevenueCalculator;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void run() {
        int purchase = getPurchase();
        List<Lotto> lottos = buyLotto(purchase);
        lottos.forEach(System.out::println);

        List<Integer> winningNumber_value = getWinningNumber();
        int bonus = getBonus();

        WinningNumber winningNumber = new WinningNumber(bonus, new Lotto(winningNumber_value));
        Map<Rank, Integer> result = winningNumber.getStatistics(lottos);
        double revenue = RevenueCalculator.calculateRevenue(purchase, result);

        OutputView.printWinningResult(result, revenue);
    }

    private List<Lotto> buyLotto(int purchase) {
        LottoSeller seller = new LottoSeller(purchase);
        return seller.sellLotto();
    }

    private int getPurchase() {
        int purchase = -1;

        while (purchase == -1) {
            try {
                InputView.printByeGuideMessage();
                purchase = RequestParser.requestPurchase();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return purchase;
    }

    private int getBonus() {
        int bonus = -1;

        while (bonus == -1) {
            try {
                InputView.printBonusGuideMessage();
                bonus = RequestParser.requestBonus();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력해주세요.");
            }
        }

        return bonus;
    }

    private List<Integer> getWinningNumber() {
        List<Integer> winningNumber = new ArrayList<>();

        while (winningNumber.size() < 6) {
            try {
                InputView.printNumberGuideMessage();
                winningNumber = RequestParser.requestWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력하신 값 중 숫자가 아닌 값이 있습니다. 다시 입력해주세요");
            }
        }
        return winningNumber;
    }
}
