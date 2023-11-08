package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements RandomNumbers {
        private static final RandomNumbers instance = new RandomNumberGenerator();

        private RandomNumberGenerator() {
        }

        public static RandomNumbers getInstance() {
                return instance;
        }

        @Override
        public List<Integer> pickUniqueNumberRange(int start, int end, int count) {
                return Randoms.pickUniqueNumbersInRange(start, end, count);
        }
}
