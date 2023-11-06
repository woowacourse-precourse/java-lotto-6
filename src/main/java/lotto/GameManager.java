package lotto;

import static lotto.message.ErrorMessage.DIVISIBLE_BY_1000;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.view.Input;

public class GameManager {
    Input input = new Input();

    private int getPurchaseQuantity(int purchaseAmount) {
        validationPurchaseAmountInThousands(purchaseAmount);
        return purchaseAmount / 1000;
    }

    private void validationPurchaseAmountInThousands(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(DIVISIBLE_BY_1000.errorMessage());
        }
    }

    public List<Lotto> createLotto() {
        int purchaseQuantity = input.getPurchaseAmount();
        List<Lotto> totalLotto = new ArrayList<>();

        IntStream.range(0, purchaseQuantity)
                .forEach(i -> {
                    List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
                    Lotto lotto = new Lotto(lottoNumbers);
                    totalLotto.add(lotto);
                });

        return totalLotto;
    }


}
