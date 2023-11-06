package lotto.domain;

import static lotto.config.AppConfig.getDataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;
import lotto.domain.rule.PrizeAmount;

public class WinRecord {
    private List<Integer> winRecord = new ArrayList<>();
    private final Lotto lotto;
    private final Bonus bonus;

    public WinRecord(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public void inputWinRecord(Tickets tickets) {
        this.winRecord = tickets.matchNumber(lotto, bonus);
    }

    public void print() {
        IntStream.range(3, 8)
                .forEach(match -> {
                    long count = matchCount(winRecord, match);

                    if (count >= 0) {
                        createMessage(match, count);
                    }
                });
    }

    private long matchCount(List<Integer> winRecord, int match) {
        return winRecord.stream()
                .filter(allMatch -> allMatch == match)
                .count();
    }

    private void createMessage(int match, long count) {
        MessageType messageType = MessageType.valueOf("MATCH_" + match + "_COUNT");
        OutputMessage.printf(messageType, count);
    }

    public void save() {
        getDataModel().saveWinRecord(this);
    }

    public double sumPrizeAmount(Map<Integer, PrizeAmount> prizeAmounts) {
        double prizeAmount = this.winRecord.stream()
                .filter(prizeAmounts::containsKey)
                .map(prizeAmounts::get)
                .mapToDouble(PrizeAmount::getAmount)
                .sum();

        return prizeAmount;
    }
}
