package lotto.domain;

import static lotto.constant.LottoInfo.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {

    static class LottoMachine {
        public static Lotto generateLotto() {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
            sortLottoNumberAsc(numbers);

            return new Lotto(numbers);
        }

        private static void sortLottoNumberAsc(List<Integer> numbers) {
            Collections.sort(numbers);
        }
    }
}
