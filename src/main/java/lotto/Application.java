package lotto;

import lotto.domain.LottoPlayer;
import lotto.domain.Validator;
import lotto.view.ConsoleView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static LottoPlayer player;

    public static void main(String[] args) {
        ConsoleView.printInputPurchaseAmountMessage();
        player = new LottoPlayer(inputPurchaseAmount());

        ConsoleView.printPurchaseConfirmationMessage(player.getCount());
        ConsoleView.printLottos(player.getLottos());
    }

    private static int inputPurchaseAmount() {
        while(true) {
            try {
                String purchaseAmount = readLine();
                Validator.validPurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
