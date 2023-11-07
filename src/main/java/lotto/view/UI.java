package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constant.Instructions;

public class UI {

    public static String sendLottoPurchaseRequest() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_LOTTO_AMOUNT);
        String lottoPurchaseRequest = Console.readLine();
        return lottoPurchaseRequest;
    }

    public static void displayMessage(final Instructions instructions) {
        System.out.println(instructions.getPrompts());
    }

    public static void displayFormatMessage(final Instructions instructions, Object... args) {
        System.out.printf(instructions.getPrompts(), args);
    }


    public static void displayLottoTicketsHistory(List<Lotto> lottoTickets) {
        displayFormatMessage(Instructions.MESSAGE_OF_PURCHASE_COUNT, lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static String InputWinningNumbers() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public static String InputBonusNumber() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_BONUS_NUMBERS);
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
