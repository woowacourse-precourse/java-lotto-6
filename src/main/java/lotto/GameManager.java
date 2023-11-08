package lotto;

import lotto.domain.*;
import lotto.exception.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameManager {

    private static final String COMMA_DELIMITER = ",";
    private static final List<Integer> END_METHOD_BY_NULL_LIST = null;
    private static final int END_METHOD_BY_ZERO = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoResultCalculator resultCalculator;
    private LottoTickets lottoTickets;
    private LottoWinningNumbers lottoWinningNumbers;
    private LottoBonusNumber bonusNumber;
    private LottoReturnRate lottoReturnRate;

    public GameManager(InputView inputView, OutputView outputView, LottoResultCalculator resultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.resultCalculator = resultCalculator;
    }

    public void gameStart() {
        publishLottoTickets();
        generateLottoWinningNumbers();
        announceLottoResult();
        announceLottoReturnRate();
    }

    private void publishLottoTickets() {
        try {
            int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());
            lottoTickets = new LottoTickets(purchaseAmount);
            lottoReturnRate = new LottoReturnRate(purchaseAmount);
            outputView.printPurchasedLottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            publishLottoTickets();
        }
    }

    private void generateLottoWinningNumbers() {
        try {
            String inputString = inputView.readWinningNumbers();
            List<String> splitInputString = Arrays.asList(inputString.split(COMMA_DELIMITER));
            List<Integer> winningNumbers = parseToIntegerList(splitInputString);

            lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
            generateLottoBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            generateLottoWinningNumbers();
        }
    }

    private List<Integer> parseToIntegerList(List<String> strings) {
        try {
            return strings.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            ExceptionMessage.WINNING_NUMBER_IS_NOT_DIGIT.throwIllegalArgumentException();
            return END_METHOD_BY_NULL_LIST;
        }
    }

    private void generateLottoBonusNumber(List<Integer> winningNumbers) {
        try {
            String inputString = inputView.readBonusNumber();
            bonusNumber = new LottoBonusNumber(parseToInt(inputString), winningNumbers);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            generateLottoBonusNumber(winningNumbers);
        }
    }

    private int parseToInt(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            ExceptionMessage.BONUS_NUMBER_IS_NOT_DIGIT.throwIllegalArgumentException();
            return END_METHOD_BY_ZERO;
        }
    }

    private void announceLottoResult() {
        Map<LottoRankInfo, Integer> winningResult =
                resultCalculator.generateLottoResult(lottoTickets, lottoWinningNumbers, bonusNumber);
        List<LottoRankInfo> rankInfos = LottoRankInfo.getRankInfoByList();
        outputView.printWinningResult(winningResult, rankInfos);

    }

    private void announceLottoReturnRate() {
        long totalPrizeMoney = resultCalculator.calculateTotalPrizeMoney();
        lottoReturnRate.calculateReturnRate(totalPrizeMoney);
        outputView.printReturnRate(lottoReturnRate);
    }
}
