package lotto.game;

import static lotto.message.GameMessage.*;

import java.util.function.Function;
import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.generator.LottoGenerator;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.generator.StatisticsGenerator;
import lotto.message.ErrorMessage;
import lotto.printer.GamePrinter;
import lotto.scanner.GameScanner;
import lotto.validator.Validator;

public class LottoGame implements Game {

    private final GamePrinter printer;
    private final GameScanner<Money> moneyGameScanner;
    private final GameScanner<WinningNumbers> winningNumbersGameScanner;
    private final GameScanner<BonusNumber> bonusNumberGameScanner;

    private Money money;
    private LottoBundle lottoBundle;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private Statistics statistics;

    public LottoGame(GamePrinter printer, GameScanner<Money> moneyGameScanner,
                     GameScanner<WinningNumbers> winningNumbersGameScanner,
                     GameScanner<BonusNumber> bonusNumberGameScanner) {
        this.printer = printer;
        this.moneyGameScanner = moneyGameScanner;
        this.winningNumbersGameScanner = winningNumbersGameScanner;
        this.bonusNumberGameScanner = bonusNumberGameScanner;
    }

    @Override
    public void play() {
        buyLotto();
        setWinningNumbers();
        setBonusNumber();
        computeStatistics();
        showStatistics();
    }

    private void buyLotto() {
        Runnable runnable = () -> printer.print(MONEY_MESSAGE);
        Function<Object, Money> function = obj -> (Money) obj;
        money = handleExceptionWhileScanning(runnable, moneyGameScanner, function);

        lottoBundle = LottoGenerator.generateLottoBundle(money);
        printer.newLine();
        printer.print(BUY_MESSAGE, money.getNumberOfLotto());
        printer.print(lottoBundle);
    }

    private void setWinningNumbers() {
        Runnable runnable = () -> {
            printer.newLine();
            printer.print(WINNING_NUMBER_MESSAGE);
        };
        Function<Object, WinningNumbers> function = obj -> (WinningNumbers) obj;

        winningNumbers = handleExceptionWhileScanning(runnable, winningNumbersGameScanner, function);
    }

    private void setBonusNumber() {
        Runnable runnable = () -> {
            printer.newLine();
            printer.print(BONUS_NUMBER_MESSAGE);
        };
        Function<Object, BonusNumber> function = obj -> {
            Validator.validateDuplicateNumber(winningNumbers, (BonusNumber) obj);
            return (BonusNumber) obj;
        };

        bonusNumber = handleExceptionWhileScanning(runnable, bonusNumberGameScanner, function);
    }

    private void computeStatistics() {
        statistics = StatisticsGenerator.generateStatistics(money, lottoBundle, winningNumbers, bonusNumber);
    }

    private void showStatistics() {
        printer.newLine();
        printer.print(WINNING_STATISTICS_HEADER_MESSAGE);

        showWinnings();
        showProfitRate();
    }

    private void showWinnings() {
        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 2; i >= 0; i--) {
            Rank rank = ranks[i];
            int stat = statistics.getStat(rank);

            if (rank.getMatchBonus() > 0) {
                printer.print(BONUS_NUMBER_MATCH_MESSAGE, rank.getMatchWinning(), rank.getFormattedPrize(), stat);
                continue;
            }

            printer.print(WINNING_NUMBER_MATCH_MESSAGE, rank.getMatchWinning(), rank.getFormattedPrize(), stat);
        }
    }

    private void showProfitRate() {
        printer.print(PROFIT_RATE_MESSAGE, statistics.getProfitRate());
    }

    private <T> T handleExceptionWhileScanning(Runnable runnable, GameScanner<?> scanner,
                                               Function<Object, T> function) {
        T target = null;
        while (target == null) {
            try {
                runnable.run();
                Object tempScannedObject = scanner.scan();
                target = function.apply(tempScannedObject);
            } catch (NumberFormatException e) {
                printer.print(ErrorMessage.NUMBER_FORMAT_EXCEPTION);
            } catch (IllegalArgumentException e) {
                printer.print(e.getMessage());
            }
        }

        return target;
    }
}
