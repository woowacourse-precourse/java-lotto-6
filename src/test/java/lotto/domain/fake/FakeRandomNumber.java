package lotto.domain.fake;

import java.util.List;
import lotto.util.RandomNumbers;

public class FakeRandomNumber implements RandomNumbers {
        private final List<Integer> numbers;

        public FakeRandomNumber(List<Integer> numbers) {
                this.numbers = numbers;
        }

        @Override
        public List<Integer> pickUniqueNumberRange(int start, int end, int count) {
                return numbers;
        }
}
