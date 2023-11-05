package lotto.game.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.Statistics;
import lotto.domain.Wallet;
import lotto.domain.WinnerNumbers;
import lotto.game.Game;
import lotto.message.ErrorMessage;
import lotto.message.LottoMessage;
import lotto.service.JudgeService;
import lotto.service.LottoProduceService;
import lotto.service.ValidateService;
import lotto.vo.Money;
import lotto.vo.Result;

public class LottoGame implements Game {

    private final IoAdapter ioAdapter;
    private final LottoProduceService lottoProduceService;
    private final ValidateService validateService;
    private final JudgeService judgeService;

    public LottoGame(IoAdapter ioAdapter, LottoProduceService lottoProduceService, ValidateService validateService,
                     JudgeService judgeService) {
        this.ioAdapter = ioAdapter;
        this.lottoProduceService = lottoProduceService;
        this.validateService = validateService;
        this.judgeService = judgeService;
    }

    @Override
    public void playLotto() {
        Money money = makeMoney();
        Wallet wallet = lottoProduceService.produceLotto(money);
        ioAdapter.printNewLine();
        WinnerNumbers winnerLotto = makeWinnerLotto();
        Statistics statistics = printResult(wallet, winnerLotto);
        printRateOfReturn(money, statistics);
    }

    private void printRateOfReturn(Money money, Statistics statistics) {
        BigDecimal calcRateOfReturn = statistics.calcRateOfReturn(money.getMoney());
        LottoMessage rateOfReturnHead = LottoMessage.RATE_OF_RETURN_HEAD;
        LottoMessage rateOfReturnTail = LottoMessage.RATE_OF_RETURN_TAIL;
        String rateOfReturn = rateOfReturnHead.getMessage() +
                calcRateOfReturn.setScale(1, RoundingMode.HALF_UP) + rateOfReturnTail.getMessage();
        ioAdapter.printMessage(rateOfReturn);
    }

    private Money makeMoney() {
        LottoMessage purchaseAmountMessage = LottoMessage.ENTER_PURCHASE_AMOUNT;
        ioAdapter.printMessage(purchaseAmountMessage.getMessage());
        int moneyInput = moneyInput();
        return new Money(moneyInput);
    }

    private Statistics printResult(Wallet wallet, WinnerNumbers winnerLotto) {
        printSystemMessage();
        List<Result> results = judgeService.compareLottoBundleAndWinnerNumbers(wallet, winnerLotto);
        Statistics statistics = new Statistics(results);
        List<String> rankStatistics = statistics.rankStatistics();
        rankStatistics.forEach(ioAdapter::printMessage);
        return statistics;
    }

    private void printSystemMessage() {
        LottoMessage winningStatistics = LottoMessage.WINNING_STATISTICS;
        LottoMessage horizontalRule = LottoMessage.HORIZONTAL_RULE;
        ioAdapter.printMessage(winningStatistics.getMessage());
        ioAdapter.printMessage(horizontalRule.getMessage());
    }

    private WinnerNumbers makeWinnerLotto() {
        while (true) {
            try {
                List<Integer> winnerNumbers = makeWinnerNumber();
                Integer bonusNumber = makeBonusNumber();
                return new WinnerNumbers(winnerNumbers, bonusNumber);
            } catch (IllegalArgumentException exception) {
                ErrorMessage wrongLottoError = ErrorMessage.WRONG_LOTTO_ERROR;
                ioAdapter.printMessage(wrongLottoError.getMessage());
            }
        }
    }

    private Integer makeBonusNumber() {
        while (true) {
            try {
                LottoMessage bonusNumberMessage = LottoMessage.INSERT_BONUS_NUMBER;
                ioAdapter.printMessage(bonusNumberMessage.getMessage());
                String bonusNumberInput = ioAdapter.inputStream();
                Integer bonusNumber = validateService.checkIncludeChar(bonusNumberInput);
                ioAdapter.printNewLine();
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                ErrorMessage BonusNumberError = ErrorMessage.ENTER_BONUS_NUMBER_ERROR;
                ioAdapter.printMessage(BonusNumberError.getMessage());
            }
        }
    }

    private List<Integer> makeWinnerNumber() {
        while (true) {
            try {
                LottoMessage insertWinningNumbersMessage = LottoMessage.INSERT_WINNING_NUMBERS;
                ioAdapter.printMessage(insertWinningNumbersMessage.getMessage());
                String winnerNumbersInput = ioAdapter.inputStream();
                List<Integer> winnerNumbers = validateService.checkCorrectWinnerNumbers(winnerNumbersInput);
                ioAdapter.printNewLine();
                return winnerNumbers;
            } catch (IllegalArgumentException exception) {
                ErrorMessage WinnerNumberError = ErrorMessage.ENTER_WINNER_NUMBER_ERROR;
                ioAdapter.printMessage(WinnerNumberError.getMessage());
            }
        }
    }

    private int moneyInput() {
        String moneyInputStream;
        while (true) {
            try {
                moneyInputStream = ioAdapter.inputStream();
                validateService.checkCorrectMoney(moneyInputStream);
                ioAdapter.printNewLine();
                return Integer.parseInt(moneyInputStream);
            } catch (IllegalArgumentException exception) {
                ErrorMessage notUnitsOfThousandError = ErrorMessage.NOT_UNITS_OF_THOUSAND_ERROR;
                ioAdapter.printMessage(notUnitsOfThousandError.getMessage());
            }
        }
    }
}
