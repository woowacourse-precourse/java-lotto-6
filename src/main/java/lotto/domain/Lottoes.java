package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.LottoConstant;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;

import java.util.*;

public class Lottoes {

    private final List<Lotto> elements = new ArrayList<>();
    private final LottoResult result = new LottoResult();

    public Lottoes(int ticketCounts) {
        createLottoes(ticketCounts);
    }

    private void createLottoes(int ticketCounts) {
        for (int i = 0; i < ticketCounts; i++) {
            int start = LottoConstant.START_NUMBER.getValue();
            int end = LottoConstant.END_NUMBER.getValue();
            int count = LottoConstant.COUNT.getValue();
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, count);
            elements.add(new Lotto(numbers));
        }
    }

    public void calculateRanking(WinningLotto winningLotto) {
        elements.forEach(lotto -> {
            Ranking ranking = lotto.isWin(winningLotto);
            result.increaseCount(ranking);
        });
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

    public double getProfit(int ticketCount) {
        return result.getProfit(ticketCount);
    }
}