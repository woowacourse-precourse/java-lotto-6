package lotto;

import static lotto.message.Message.BONUS_NUMBER_REQUEST;
import static lotto.message.Message.COUNT;
import static lotto.message.Message.DIVIDING_LINE;
import static lotto.message.Message.END_EXPLAINE;
import static lotto.message.Message.LINE_BREAK;
import static lotto.message.Message.PAYMENT_COMPLETE;
import static lotto.message.Message.PAYMENT_REQUEST;
import static lotto.message.Message.PERCENT_SIGN;
import static lotto.message.Message.SPACE;
import static lotto.message.Message.TOTAL_RETURN;
import static lotto.message.Message.WINNING_NUMBER_REQUEST;
import static lotto.message.Message.WINNING_STATISTICS_RESULT;

import java.util.Arrays;
import java.util.HashMap;
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

        WiningLotto win = saveWiningData(runWiningNumberSavingProcess(), receiveBonusNumber());
        printLottoWinResult(lottoTicket, win, money.calculatePurchasedLotto());

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
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int receiveBonusNumber() {
        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(BONUS_NUMBER_REQUEST.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        String input = InputView.read();
        InputValidator.validateNumber(input);

        return Integer.parseInt(input);
    }

    private WiningLotto saveWiningData(Lotto winNumber, int bonus) {
        try {
            return new WiningLotto(winNumber, bonus);
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return new WiningLotto(winNumber, receiveBonusNumber());
        }
    }

    private void printLottoWinResult(LottoTicket lottoTicket, WiningLotto win, int lottoCount) {
        OutputView.print(LINE_BREAK.getMessage());
        OutputView.print(WINNING_STATISTICS_RESULT.getMessage());
        OutputView.print(LINE_BREAK.getMessage());
        for (int i = 0; i < 3; i++) {
            OutputView.print(DIVIDING_LINE.getMessage());
        }
        OutputView.print(LINE_BREAK.getMessage());
        HashMap<Integer, Integer> winResult = new LottoCalculator().calculate(lottoTicket, win);

        for (LottoResult result : LottoResult.values()) {
            OutputView.print(result.getWon() + SPACE.getMessage() + DIVIDING_LINE.getMessage() + SPACE.getMessage()
                    + winResult.get(result.getCount()) + COUNT.getMessage());
            OutputView.print(LINE_BREAK.getMessage());
        }
        OutputView.print(TOTAL_RETURN.getMessage() + new StatisticsCalculator().getRate(winResult, lottoCount)
                + PERCENT_SIGN.getMessage() + END_EXPLAINE.getMessage());
    }


}