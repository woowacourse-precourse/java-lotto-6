package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Numbers {
    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public String putCommaInNumber(long price) {
        final String numberStr = Long.toString(price);
        StringBuilder result = new StringBuilder();
        int maxIndex = numberStr.length();

        for (int i = 0; i < maxIndex; i++) {
            result.append(numberStr.charAt(i));
            if ((maxIndex - i) % 3 == 1 && i != maxIndex - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    public float rateOfReturn(int inputPrice, long outputPrice) {
        return 0;
    }
}
