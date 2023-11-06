package lotto;

import static lotto.SystemMessage.INPUT_BONUS;
import static lotto.SystemMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.SystemMessage.INPUT_WINNING_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(askPurchaseAmount());
        lottoGenerator.printLottos();

        Win win = new Win();
        win.setWinningLotto(askWinningLotto());
        win.setBonus(askBonus());

        Referee referee = new Referee();
        referee.compare(lottoGenerator.getLottos(), win.getWinningLotto(), win.getBonus());
    }

    private static int askPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    private static String askWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO.getMessage());
        return Console.readLine();
    }

    private static int askBonus() {
        System.out.println(INPUT_BONUS.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
