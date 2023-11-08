package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int money = View.getMoney();
        int amount = money / 1000;
        List<Lotto> lottos = Service.buyLottos(amount);
        System.out.println();

        View.printPurchasedLottos(lottos);
        System.out.println();

        String[] winningNumbers = View.getWinningNumbers();
        System.out.println();

        int bonus = View.getBonusNumber();
        System.out.println();

        Service.checkLottos(lottos, winningNumbers, bonus);
        double profitRate = Service.calculateProfitRate(money);
        View.printResult(profitRate);
    }
}