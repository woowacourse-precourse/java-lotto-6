package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.constant.LotteryRankConstant;
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

    public void printNumberOfLottos(final long numberOfLottos) {
        printMessage(numberOfLottos + OutputMessage.PRINT_NUMBER_OF_LOTTOS.getMessage());
        printLine();
    }

    public void printLottoContent(final LottoNumbers lottoNumbers) {
        List<Integer> lottoContent = lottoNumbers
                .getLottoNumbers()
                .stream()
                .sorted()
                .toList();
        printMessage(lottoContent);
        printLine();
    }

    public void printWinningStatistics(final Map<LotteryRankConstant, Integer> userLottoRanks,
                                       final double rateOfReturn) {
        printUserLottoResult(userLottoRanks);
        printRateOfReturn(rateOfReturn);
    }

    private void printUserLottoResult(final Map<LotteryRankConstant, Integer> userLottoRanks) {
        DecimalFormat prizeFormatter = new DecimalFormat(OutputConstant.PRIZE_FORMAT_STYLE);
        printLottoResultAnnouncement();
        printPrizeResult(OutputMessage.PRINT_FIFTH_RANK_PRIZE_RESULT_FORMAT, LotteryRankConstant.FIFTH_RANK,
                userLottoRanks, prizeFormatter);
        printPrizeResult(OutputMessage.PRINT_FOURTH_RANK_PRIZE_RESULT_FORMAT, LotteryRankConstant.FOURTH_RANK,
                userLottoRanks, prizeFormatter);
        printPrizeResult(OutputMessage.PRINT_THIRD_RANK_PRIZE_RESULT_FORMAT, LotteryRankConstant.THIRD_RANK,
                userLottoRanks, prizeFormatter);
        printPrizeResult(OutputMessage.PRINT_SECOND_RANK_PRIZE_RESULT_FORMAT, LotteryRankConstant.SECOND_RANK,
                userLottoRanks, prizeFormatter);
        printPrizeResult(OutputMessage.PRINT_FIRST_RANK_PRIZE_RESULT_FORMAT, LotteryRankConstant.FIRST_RANK,
                userLottoRanks, prizeFormatter);
    }

    private void printLottoResultAnnouncement() {
        StringBuilder sb = new StringBuilder();
        sb.append(OutputMessage.PRINT_WINNING_STATISTICS_WORD.getMessage())
                .append(OutputConstant.NEW_LINE)
                .append(OutputConstant.BREAK_LINE)
                .append(OutputConstant.NEW_LINE);
        printMessage(sb);
    }

    private void printPrizeResult(final OutputMessage outputMessageFormat,
                                  final LotteryRankConstant lotteryRankConstant,
                                  final Map<LotteryRankConstant, Integer> userLottoRanks,
                                  final DecimalFormat prizeFormatter) {
        String prizeResult = String.format(outputMessageFormat.getMessage(),
                prizeFormatter.format((lotteryRankConstant.getPrizeMoney())),
                userLottoRanks.get(lotteryRankConstant));
        printMessage(prizeResult);
        printLine();
    }

    private void printRateOfReturn(final double rateOfReturn) {
        String rateOfReturnResult = String.format(OutputMessage.PRINT_RATE_OF_RETURN_RESULT_FORMAT.getMessage(),
                rateOfReturn);
        printMessage(rateOfReturnResult);
    }

    public void printLine() {
        System.out.print(OutputConstant.NEW_LINE);
    }

    public void printErrorMessage(final String message) {
        printMessage(message);
    }

    private <T> void printMessage(final T message) {
        System.out.print(message);
    }
}