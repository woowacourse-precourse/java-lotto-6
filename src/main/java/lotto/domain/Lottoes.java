package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constant.LottoConstant;
import lotto.constant.OutputMessage;

import java.util.*;

public class Lottoes {

    private final List<Lotto> elements = new ArrayList<>();

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
        for (Lotto lotto: elements) {
            int matchCount = calculateMatchCount(lotto, winningLotto);
            boolean isMatchBonusNumber = hasBonusNumber(lotto, winningLotto.getBonusNumber());
        }
    }

    private int calculateMatchCount(Lotto lotto, WinningLotto winningLotto) {
        int count = 0;
        for (int i = 0; i < LottoConstant.COUNT.getValue(); i++) {
            int number = lotto.getNumberByIndex(i);
            if (winningLotto.isContain(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.isContain(bonusNumber.getValue());
    }

    public String getLottoesNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        elements.forEach(element -> stringBuilder.append(element.getNumbers())
                .append(OutputMessage.NEW_LINE.getMessage()));
        return stringBuilder.toString();
    }
}