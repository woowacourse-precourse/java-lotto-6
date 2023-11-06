package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Numbers {
    public List<Integer> createRandomNumbers() {
        List<Integer> result = Randoms.pickUniqueNumbersInRange(1,45,6);
        return result;
    }

    public String putCommaInNumber(String price) {
        StringBuilder result = new StringBuilder();
        int checkDot = price.indexOf(".");
        String sliceInputUp = price;
        String sliceInputdown = "";
        int maxIndex;

        if (checkDot > -1) {
            sliceInputUp = price.substring(0, checkDot);
            sliceInputdown = price.substring(checkDot, price.length());
        }

        maxIndex = sliceInputUp.length();

        for (int i = 0; i < maxIndex; i++) {
            result.append(price.charAt(i));
            if ((maxIndex - i) % 3 == 1 && i != maxIndex - 1) {
                result.append(",");
            }
        }

        return result + sliceInputdown;
    }

    public double rateOfReturn(long outputPrice, long inputPrice) {
        double result = (double) outputPrice / inputPrice * 100;
        return Math.round(result*10)/10.0;
    }
}
