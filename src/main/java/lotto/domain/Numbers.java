package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public List<Integer> createRandomNumbers() {
        List<Integer> result = Randoms.pickUniqueNumbersInRange(1,45,6);
        return result;
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

    public double rateOfReturn(long outputPrice, long inputPrice) {
        double result = (double) outputPrice / inputPrice * 100;
        return Math.round(result*10)/10.0;
    }
}
