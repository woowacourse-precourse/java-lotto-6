package lotto;

import static lotto.message.Message.BONUS_NUMBER_REQUEST;
import static lotto.message.Message.DIVIDING_LINE;
import static lotto.message.Message.LINE_BREAK;
import static lotto.message.Message.PAYMENT_COMPLETE;
import static lotto.message.Message.PAYMENT_REQUEST;
import static lotto.message.Message.WINNING_NUMBER_REQUEST;
import static lotto.message.Message.WINNING_STATISTICS_RESULT;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {

        Money money = runMoneySavingProcess();

        printCountOfLotto(money.toString());

        LottoTicket lottoTicket = new LottoTicket(new LottoTicketMaker().make(money.calculatePurchasedLotto()));
        printLottoTicket(lottoTicket.makeLottoToString());

        Lotto winingLotto = runWiningNumberSavingProcess();

        /////////

//        OutputView.print(LINE_BREAK.getMessage());
//        OutputView.print(BONUS_NUMBER_REQUEST.getMessage());
//        OutputView.print(LINE_BREAK.getMessage());
//        String input = InputView.read();
//        InputValidator.validateNumber(input);
//        validateRangeOne(Integer.parseInt(input));
//        validateBonusDuplication(Integer.parseInt(input), winingLotto.getNumbers());
//        int bonus = Integer.parseInt(input);

        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(WINNING_STATISTICS_RESULT.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        for (int i = 0; i < 3; i++) {
            OutputView.print(DIVIDING_LINE.getMessage());
        }
        OutputView.print(LINE_BREAK.getMessage());


    }

    private Money runMoneySavingProcess() {
        try {
            return new Money(receiveMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return runMoneySavingProcess();
        }
    }

    private int receiveMoney() {
        OutputView.print(PAYMENT_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String money = InputView.read();
        InputValidator.validateNumber(money);

        return Integer.parseInt(money);
    }

    private void printCountOfLotto(String count) {
        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(count);
        OutputView.print(PAYMENT_COMPLETE.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
    }

    private void printLottoTicket(List<String> lottoInventory) {
        for (String lottoNumber : lottoInventory) {
            OutputView.print(lottoNumber);
            OutputView.print(LINE_BREAK.getMessage());
        }
    }

    private Lotto runWiningNumberSavingProcess() {
        try {
            return new Lotto(receiveWinningNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return runWiningNumberSavingProcess();
        }
    }

    private List<Integer> receiveWinningNumber() {
        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(WINNING_NUMBER_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String input = InputView.read();
        InputValidator.validateInputRequirement(input);

        return convertNumber(input);
    }

    private List<Integer> convertNumber(String input) {
        List<Integer> winingNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winingNumbers;
    }

    private BonusNumber runBonusNumberSavingProcess() {
        try {
            return new BonusNumber(receiveBonusNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return runBonusNumberSavingProcess();
        }

        validateRangeOne(Integer.parseInt(input));
        validateBonusDuplication(Integer.parseInt(input), winingLotto.getNumbers());
        int bonus = Integer.parseInt(input);
    }

    private int receiveBonusNumber() {
        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(BONUS_NUMBER_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String input = InputView.read();
        InputValidator.validateNumber(input);

        return Integer.parseInt(input);
    }


}


class Message {

}
