package lotto.util.RandomGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class DefaultgenerateRandomNumber implements RandomNumberGenerator {

    @Override
    public List<Integer> generateRandomNumber (int minNumber, int maxNumber, int countNumber) {
        return Randoms.pickUniqueNumbersInRange(minNumber,maxNumber,countNumber);
    }
}
