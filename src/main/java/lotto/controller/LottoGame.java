package lotto.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.config.LottoResultInform;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WiningLotto;
import lotto.util.LottoCalculator;
import lotto.util.LottoTicketMaker;
import lotto.util.StatisticsCalculator;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        Money money = runMoneySavingProcess();
        printCountOfLotto(money.toString());

        LottoTicket lottoTicket = new LottoTicket(new LottoTicketMaker().make(money.calculatePurchasedLotto()));
        printLottoTicket(lottoTicket.makeLottoToString());

        WiningLotto win = saveWiningData(runWiningNumberSavingProcess());
        printLottoWinResult(lottoTicket, win, money.calculatePurchasedLotto());
    }

    private Money runMoneySavingProcess() {
        try {
            return new Money(receiveMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.println(exception.getMessage());
            return runMoneySavingProcess();
        }
    }

    private int receiveMoney() {
        OutputView.printPayRequest();
        String money = InputView.read();
        InputValidator.validateNumber(money);
        return Integer.parseInt(money);
    }

    private void printCountOfLotto(String count) {
        OutputView.printLottoCount(count);
    }

    private void printLottoTicket(List<String> lottoInventory) {
        for (String lottoNumber : lottoInventory) {
            OutputView.println(lottoNumber);
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
        OutputView.printWinNumberRequest();
        String input = InputView.read();
        InputValidator.validateWinNumberRequirement(input);
        return convertNumber(input);
    }

    private List<Integer> convertNumber(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int receiveBonusNumber() {
        try {
            OutputView.printBonusRequest();
            String input = InputView.read();
            InputValidator.validateNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return receiveBonusNumber();
        }
    }

    private WiningLotto saveWiningData(Lotto winNumber) {
        try {
            return new WiningLotto(winNumber, receiveBonusNumber());
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
            return saveWiningData(winNumber);
        }
    }

    private void printLottoWinResult(LottoTicket lottoTicket, WiningLotto win, int lottoCount) {
        StatisticsCalculator rateCalculator = new StatisticsCalculator();
        OutputView.printNoticeWiningResult();
        OutputView.printStatisticResult(rateCalculator.getRate(makeWiningResult(lottoTicket, win), lottoCount));
    }

    private HashMap<Integer, Integer> makeWiningResult(LottoTicket lottoTicket, WiningLotto win) {
        HashMap<Integer, Integer> winResult = new LottoCalculator().calculate(lottoTicket, win);
        for (LottoResultInform resultExplaine : LottoResultInform.values()) {
            OutputView.printWiningResult(winResult.get(resultExplaine.getCount()), resultExplaine.getWon());
        }
        return winResult;
    }
}