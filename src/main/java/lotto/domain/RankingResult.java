package lotto.domain;

import static lotto.enums.ConsoleMessage.LOTTO_NUMBER_MATCH;
import static lotto.enums.ConsoleMessage.LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.enums.WinningGrade;

public class RankingResult {
    
    private final Map<WinningGrade, Long> rankingResult;
    
    private RankingResult(final Map<WinningGrade, Long> rankingResult) {
        this.rankingResult = rankingResult;
    }
    
    public static RankingResult from(final Map<WinningGrade, Long> rankingResult) {
        return new RankingResult(rankingResult);
    }
    
    public BigDecimal receiveProfitability(final Payment payment) {
        final long result = rankingResult.keySet()
                .stream()
                .mapToLong(this::receiveMultipleGrade)
                .sum();
        
        return payment.calculateProfitability(result);
    }
    
    private Long receiveMultipleGrade(WinningGrade grade) {
        final Long targetValue = rankingResult.get(grade);
        return grade.receiveMultipleValue(targetValue);
    }
    
    public List<String> receiveRankingResultInfo() {
        return rankingResult.keySet()
                .stream()
                .map(this::receiveRankingMessage)
                .sorted()
                .toList();
    }
    
    private String receiveRankingMessage(final WinningGrade winningGrade) {
        String message = selectRankingMessage(winningGrade);
        return receiveFormattedRankingMessage(message, winningGrade);
    }
    
    private String selectRankingMessage(final WinningGrade winningGrade) {
        if (winningGrade.incorrectFiveNumbersWithBonusNumber()) {
            return LOTTO_NUMBER_MATCH.getMessage();
        }
        return LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER.getMessage();
    }
    
    private String receiveFormattedRankingMessage(
            final String message, final WinningGrade winningGrade) {
        
        Long count = rankingResult.get(winningGrade);
        return winningGrade.receiveRankingMessageFormat(message, count);
    }
}
