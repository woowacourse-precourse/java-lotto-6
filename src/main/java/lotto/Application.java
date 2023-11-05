package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "\n보너스 번호를 입력해 주세요.";

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
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    private static String askWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        return Console.readLine();
    }

    private static int askBonus() {
        System.out.println(INPUT_BONUS);
        return Integer.parseInt(Console.readLine());
    }
}
