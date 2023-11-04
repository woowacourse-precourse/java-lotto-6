package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Numbers {
    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public String putCommaInNumber(long price) {
        final String NUMBER_TO_STR = Long.toString(price);
        final int MAX_INDEX = NUMBER_TO_STR.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < MAX_INDEX; i++) {
            result.append(NUMBER_TO_STR.charAt(i));
            if ((MAX_INDEX - i) % 3 == 1 && i != MAX_INDEX - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    public float rateOfReturn(int inputPrice, long outputPrice) {
        return 0;
    }
}
