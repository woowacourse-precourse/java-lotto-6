package lotto.view;

import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.view.constant.OutputConstant;
import lotto.view.message.OutputMessage;

public class OutputView {
    public void askToInsertUserMoney() {
        printMessage(OutputMessage.ASK_TO_INSERT_USER_MONEY.getMessage());
        printLine();
    }

    public void askUserToInsertLottoWinningNumbers() {
        printMessage(OutputMessage.ASK_TO_INSERT_LOTTO_WINNING_NUMBERS.getMessage());
        printLine();
    }

    public void askUserToInsertBonusNumber() {
        printMessage(OutputMessage.ASK_TO_INSERT_LOTTO_BONUS_NUMBER.getMessage());
        printLine();
    }

    public void printNumberOfLottos(long numberOfLottos) {
        printMessage(numberOfLottos + OutputMessage.PRINT_NUMBER_OF_LOTTOS.getMessage());
        printLine();
    }

    public void printLottoContent(LottoNumbers lottoNumbers) {
        List<Integer> lottoContent = lottoNumbers
                .getLottoNumbers()
                .stream()
                .sorted()
                .toList();
        printMessage(lottoContent);
        printLine();
    }

    public void printLine() {
        System.out.print(OutputConstant.NEW_LINE);
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    private <T> void printMessage(T message) {
        System.out.print(message);
    }
}