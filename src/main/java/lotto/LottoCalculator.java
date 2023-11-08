package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoCalculator {

    public HashMap<String, Integer> calculate(LottoTicket lottoTicket, WiningLotto winingLotto) {
        return calculateWin(lottoTicket, winingLotto.getWinNumber(), winingLotto.getBonus());
    }

    private HashMap<String, Integer> calculateWin(LottoTicket lottoTicket, List<Integer> winNumbers, int bonus) {
        HashMap<String, Integer> result = makeResultStore();

        for (List<Integer> lottoNumbers : lottoTicket.showLottoNumbers()) {
            int key = makeKey(lottoNumbers, winNumbers, bonus);
            if (key > 3) {
                int value = result.get(String.valueOf(key)) + 1;
                result.replace(String.valueOf(key), value);
            }
        }
        return result;
    }

    private HashMap<String, Integer> makeResultStore() {
        HashMap<String, Integer> result = new HashMap<>();
        for (int correct = 3; correct <= 7; correct++) {
            result.put(String.valueOf(correct), 0);
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
