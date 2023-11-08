package lotto;

import input.BonusNumber;
import input.Purchase;
import input.WinningNumber;
import java.util.List;
import output.LottoPrinter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        int money = purchase.getMoney();

        List<List<Integer>> lottos = Lotto.getLottos(money);
        LottoPrinter.printLottos(lottos);

        WinningNumber wn = new WinningNumber();
        List<Integer> winningNumbers = wn.getWinningNumbers();
        System.out.println("winningNumbers = " + winningNumbers);

        BonusNumber bn = new BonusNumber(winningNumbers);
        int bonnusNumber = bn.getBonnusNumber();
        System.out.println("bonnusNumber = " + bonnusNumber);
    }
}
