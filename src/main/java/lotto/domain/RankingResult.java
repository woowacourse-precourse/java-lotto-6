package lotto.domain;

import static java.lang.String.format;
import static lotto.view.ConsoleMessage.LOTTO_NUMBER_MATCH;
import static lotto.view.ConsoleMessage.LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER;
import static lotto.view.SeparatorConstant.DECIMAL_FORMAT;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.constants.WinningGrade;

public class RankingResult {

    private final Map<WinningGrade, Long> rankingResult;

    private RankingResult(Map<WinningGrade, Long> rankingResult) {
        this.rankingResult = rankingResult;
    }

    public static RankingResult from(Map<WinningGrade, Long> rankingResult) {
        return new RankingResult(rankingResult);
    }

    public List<String> receiveRankingResultInfo() {
        return rankingResult.keySet().stream()
                .map(this::receiveRankingMessage)
                .sorted()
                .toList();
    }

    private String receiveRankingMessage(WinningGrade winningGrade) {
        if (winningGrade.incorrectFiveNumbersWithBonusNumber()) {
            return receiveRankingMessageFormat(LOTTO_NUMBER_MATCH.getMessage(), winningGrade);
        }
        return receiveRankingMessageFormat(LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER.getMessage(), winningGrade);
    }

    private String receiveRankingMessageFormat(String message, WinningGrade winningGrade) {
        return format(message,
                winningGrade.getMatchingCount(),
                receiveFormattedPrice(winningGrade),
                rankingResult.get(winningGrade));
    }

    private String receiveFormattedPrice(WinningGrade winningGrade) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
        return decimalFormat.format(winningGrade.getPrice());
    }

    public BigDecimal receiveProfitability(Payment payment) {
        long result = rankingResult.keySet()
                .stream()
                .mapToLong(grade -> grade.getPrice() * rankingResult.get(grade))
                .sum();

        return payment.calculateProfitability(result);
    }
}
