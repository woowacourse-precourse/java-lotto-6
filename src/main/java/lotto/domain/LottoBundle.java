package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Config;
import lotto.Validation;
import lotto.domain.Lotto;

public class LottoBundle {

    private static final int MIN = Config.MIN;
    private static final int MAX = Config.MAX;
    private static final int LOTTO_LENGTH = Config.LOTTO_LENGTH;
    private static final int LOTTO_PRICE = Config.LOTTO_PRICE;

    private final List<Lotto> bundle = new ArrayList<>();

    public List<Lotto> getBundle() {
        return bundle;
    }

    public int getSize() {
        return bundle.size();
    }

    public void makeLotto(int price) {
        int quantity = price / LOTTO_PRICE;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_LENGTH);
            bundle.add(new Lotto(numbers));
        }
    }

    public void makeLotto(String input) {
        Validation.price(input);
        int quantity = Integer.parseInt(input) / LOTTO_PRICE;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_LENGTH);
            bundle.add(new Lotto(numbers));
        }
    }

    public Map<String, Integer> result(Lotto winning, int bonus) {
        Map<String, Integer> result = new HashMap<>();
        List<Integer> winningNumbers = winning.getNumbers();
        for (Lotto lotto : this.bundle) {
            int count = 0;
            List<Integer> lottoNumbers = lotto.getNumbers();

            for (int index = 0; index < lottoNumbers.size(); index++) {
                if (winningNumbers.contains(lottoNumbers.get(index))) {
                    count++;
                }
            }

            if (count == 3) {
                result.put("3", result.getOrDefault("3", 0) + 1);
            }
            if (count == 4) {
                result.put("4", result.getOrDefault("4", 0) + 1);
            }
            if (count == 5) {
                if (lottoNumbers.contains(bonus)) {
                    result.put("5+", result.getOrDefault("5+", 0) + 1);
                }
                result.put("5", result.getOrDefault("5", 0) + 1);
            }
            if (count == 6) {
                result.put("6", result.getOrDefault("6", 0) + 1);
            }
        }

        return result;
    }
}