package lotto.util;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.WiningLotto;

public class LottoCalculator {
    private final static int MIN_WIN = 3;
    private final static int MAX_WIN = 7;

    public HashMap<Integer, Integer> calculate(LottoTicket lottoTicket, WiningLotto winingLotto) {
        return calculateWin(lottoTicket, winingLotto.getWinNumber(), winingLotto.getBonus());
    }

    private HashMap<Integer, Integer> calculateWin(LottoTicket lottoTicket, List<Integer> winNumbers, int bonus) {
        HashMap<Integer, Integer> result = makeResultStore();

        for (List<Integer> lottoNumbers : lottoTicket.showLottoNumbers()) {
            int key = makeKey(lottoNumbers, winNumbers, bonus);
            if (key >= MIN_WIN) {
                int value = result.get(key) + 1;
                result.replace(key, value);
            }
        }
        return result;
    }

    private HashMap<Integer, Integer> makeResultStore() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int correct = MIN_WIN; correct <= MAX_WIN; correct++) {
            result.put(correct, 0);
        }
        return result;
    }

    private int makeKey(List<Integer> lottoNumbers, List<Integer> winNumbers, int bonus) {
        if (compareNumber(lottoNumbers, winNumbers) == 5) {
            if (compareBonus(lottoNumbers, bonus)) {
                return 7;
            }
        }
        return (compareNumber(lottoNumbers, winNumbers));
    }

    private int compareNumber(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    private boolean compareBonus(List<Integer> lottoNumbers, int bonus) {
        return lottoNumbers.contains(bonus);
    }


}
