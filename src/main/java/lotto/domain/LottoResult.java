package lotto.domain;

import lotto.constant.OutputMessage;
import lotto.constant.Ranking;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private static final int DEFAULT = 0;
    private static final int INCREASING_COUNT = 1;
    private final Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);

    public LottoResult() {
        Arrays.stream(Ranking.values()).forEach(value -> result.put(value, DEFAULT));
    }

    public void increaseCount(Ranking ranking) {
        int now = result.get(ranking);
        result.put(ranking, now + INCREASING_COUNT);
    }

    public double getTotalPrize() {
        return result.keySet()
                .stream()
                .mapToInt((ranking -> ranking.getPrize() * result.get(ranking)))
                .sum();
    }

    public String getResultScreen() {
        StringBuilder stringBuilder = new StringBuilder();
        result.keySet().stream()
                .filter(key -> key != Ranking.NONE)
                .forEach(key -> {
                    appendMatchCount(key, stringBuilder);
                    appendBonus(key, stringBuilder);
                    appendPrize(key, stringBuilder);
                    appendWinningNumber(key, stringBuilder);
                });
        return stringBuilder.toString();
    }

    private void appendMatchCount(Ranking ranking, StringBuilder stringBuilder) {
        OutputMessage message = OutputMessage.MATCH_COUNT;
        int matchNumber = ranking.getMatchCount();
        stringBuilder.append(String.format(message.getMessage(), matchNumber));
    }

    private void appendPrize(Ranking ranking, StringBuilder stringBuilder) {
        OutputMessage message = OutputMessage.PRIZE_AMOUNT;
        int prize = ranking.getPrize();
        stringBuilder.append(String.format(message.getMessage(), prize));
    }

    private void appendBonus(Ranking ranking, StringBuilder stringBuilder) {
        if (ranking.isSecond()) {
            stringBuilder.append(OutputMessage.BONUS_MATCH.getMessage());
        }
    }

    private void appendWinningNumber(Ranking ranking, StringBuilder stringBuilder) {
        OutputMessage message = OutputMessage.WINNING_NUMBER;
        int winningNumber = result.get(ranking);
        stringBuilder.append(String.format(message.getMessage(), winningNumber));
    }
}
