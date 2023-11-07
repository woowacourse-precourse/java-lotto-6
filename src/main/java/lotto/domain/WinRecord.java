package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.config.output.MessageType;
import lotto.config.output.OutputMessage;

public class WinRecord {
    private List<Integer> winRecord = new ArrayList<>();
    private final LottoSet lottoSet;

    public WinRecord(LottoSet lottoSet) {
        this.lottoSet = lottoSet;
    }

    public void inputWinRecord(Tickets tickets) {
        this.winRecord = tickets.matchNumber(this.lottoSet);
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

    public List<Integer> get(){
        return this.winRecord;
    }
}
