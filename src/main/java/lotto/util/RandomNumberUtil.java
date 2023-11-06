package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberUtil implements RandomNumber {
        private static final RandomNumber instance = new RandomNumberUtil();

        private RandomNumberUtil() {
        }

        public static RandomNumber getInstance() {
                return instance;
        }

        @Override
        public List<Integer> pickUniqueNumberRange(int start, int end, int count) {
                return Randoms.pickUniqueNumbersInRange(start,end,count);
        }
}
