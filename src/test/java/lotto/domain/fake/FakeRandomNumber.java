package lotto.domain.fake;

import java.util.List;
import lotto.util.RandomNumber;

public class FakeRandomNumber implements RandomNumber {
        private final List<Integer> numbers;

        public FakeRandomNumber(List<Integer> numbers) {
                this.numbers = numbers;
        }

        @Override
        public List<Integer> pickUniqueNumberRange(int start, int end, int count) {
                return numbers;
        }
}
