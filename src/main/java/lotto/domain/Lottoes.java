package lotto.domain;

import lotto.Lotto;
import lotto.constant.LottoConstant;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;

import java.util.*;

public class Lottoes {

    private static final int PERCENTAGE = 100;
    private final List<Lotto> elements = new ArrayList<>();
    private final LottoResult result = new LottoResult();

    public Lottoes(NumberGenerator numberGenerator, int ticketCounts) {
        createLottoes(numberGenerator, ticketCounts);
    }

    private void createLottoes(NumberGenerator numberGenerator, int ticketCounts) {
        for (int i = 0; i < ticketCounts; i++) {
            elements.add(new Lotto(numberGenerator.create()));
        }
    }

    public void calculateRanking(WinningLotto winningLotto) {
        elements.forEach(lotto -> {
            Ranking ranking = lotto.isWin(winningLotto);
            result.increaseCount(ranking);
        });
    }

    public double getTotalProfit() {
        double totalPrize = result.getTotalPrize();
        int ticketCount = elements.size();
        return (totalPrize / (LottoConstant.LOTTO_PRICE_UNIT.getValue() * ticketCount)) * PERCENTAGE;
    }

    public String getLottoesNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> stringBuilder.append(element.getNumbers())
                .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }

    public LottoResult getResult() {
        return result;
    }
}