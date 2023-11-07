package lotto.utils;

import java.util.List;
import lotto.views.SystemMessage;
import lotto.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoUtils {
    SystemMessage systemMessage = new SystemMessage();

    public Integer setPurchaseAmout() {
        Integer number = this.isValidAmount(systemMessage.getPurchasePrice());
        return number / 1000;
    }

    public void setLottoResult(Integer amout) {
        System.out.println("\n" + amout + Constants.PURCHASED_RESULT);
        for (int index = 0; index < amout; index++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lotto);
        }
    }

    private Integer isValidAmount(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(Constants.PURCHASE_ERROR);
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(Constants.SPLIT_ERROR);
        }
        return number;
    }
}
