package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";

    public static PurchaseAmount inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
                String purchaseAmount = Console.readLine();
                System.out.print(NEW_LINE);
                return new PurchaseAmount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static WinningNumber inputLottoWinningNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
                String inputWinningNumber = Console.readLine();
                System.out.print(NEW_LINE);
                return new WinningNumber(inputWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber inputLottoBonusNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                String inputBonusNumber = Console.readLine();
                System.out.print(NEW_LINE);
                return new BonusNumber(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}