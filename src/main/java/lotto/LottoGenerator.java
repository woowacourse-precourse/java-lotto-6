package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
public class LottoGenerator {
        private final List<Integer> numbers;

        public LottoGenerator(List<Integer> numbers) {
                this.numbers = numbers;
        }

        public List<Integer> startRandom(){
                List<Integer> randomNumbers= Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER
                        , Constants.LOTTO_MAX_NUMBER
                        , Constants.LOTTO_MAX_SIZE);
                return numbers;
        }
}
