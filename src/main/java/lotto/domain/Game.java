package lotto.domain;

import java.util.List;
import java.util.Map;

public class Game {
    private Validator validator;
    private Lottos lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;


    public void issuance(Integer purchaseAmount) {
        validator.validatePurchaseAmount(purchaseAmount);
        lottos.inssuance(purchaseAmount);
    }

    public void statistics() {
        Map<Grade,Integer> result = lottos.grade(winningNumbers,bonusNumber);
    }
}
