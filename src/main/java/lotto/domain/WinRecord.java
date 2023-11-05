package lotto.domain;

import static lotto.ApplicationContext.getDataModel;
import static lotto.ApplicationContext.getPrizeAmount;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SIX_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.rule.PrizeAmount;
import lotto.output.MessageType;
import lotto.output.OutputMessage;

public class WinRecord {
    private PrizeAmount prizeAmount = getPrizeAmount();
    private List<Integer> winRecord = new ArrayList<>();
    private final List<Integer> lotto;
    private final int bonus;

    public WinRecord(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void compareWinning(List<List<Integer>> tickets) {
        this.winRecord = tickets.stream()
                .map(ticket -> {
                    int lottoCount = sameLottoCount(ticket);
                    int bonusCount = sameBonusCount(ticket);
                    return matchAllCount(lottoCount, bonusCount);
                })
                .collect(Collectors.toList());
    }

    private int sameBonusCount(List<Integer> ticket) {
        int bonusCount = 0;

        if (ticket.contains(bonus)) {
            bonusCount = 1;
        }

        return bonusCount;
    }

    private int sameLottoCount(List<Integer> ticket) {
        return (int) ticket.stream()
                .filter(this.lotto::contains)
                .count();
    }

    private int matchAllCount(int lottoCount, int bonusCount) {
        int sumCount = lottoCount + bonusCount;

        if (sumCount == MATCH_ALL_SIX_COUNT && lottoCount == 6) {
            sumCount = MATCH_ALL_SEVEN_COUNT;
        }

        return sumCount;
    }

    public void save() {
        getDataModel().saveWinRecord(this.winRecord);
    }

    public static void print(List<Integer> winRecord) {
        IntStream.range(3, 8)
                .forEach(match -> {
                    long count = matchCount(winRecord, match);

                    if (count >= 0) {
                        createMessage(match, count);
                    }
                });
    }

    private static void createMessage(int match, long count) {
        MessageType messageType = MessageType.valueOf("MATCH_" + match + "_COUNT");
        OutputMessage.printf(messageType, count);
    }

    private static long matchCount(List<Integer> winRecord, int match) {
        return winRecord.stream()
                .filter(allMatch -> allMatch == match)
                .count();
    }
}
