package lotto;

import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.view.Input;

public class GameManager {
    private void validationPurchaseAmountInThousands(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(DIVISIBLE_BY_1000.errorMessage());
        }
    }


}
