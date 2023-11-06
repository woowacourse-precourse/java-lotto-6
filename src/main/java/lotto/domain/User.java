package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Validator;
import java.util.List;

public class User {

    private List<Lotto> lottos;
    private Integer purchaseAmount;

    public User(Integer purchaseAmount){
        Validator.checkAmount(purchaseAmount);
        purchaseLotto(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void purchaseLotto(Integer purchaseAmount) throws IllegalArgumentException{
        Integer usedAmount = 0;
        while(usedAmount != purchaseAmount){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
            usedAmount += 1000;
        }
    }
}
