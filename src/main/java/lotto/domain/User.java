package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private List<Lotto> lottos;
    private Integer purchaseAmount;

    public User(Integer purchaseAmount){
        Validator.checkAmount(purchaseAmount);
        this.lottos = purchaseLotto(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private List<Lotto> purchaseLotto(Integer purchaseAmount) throws IllegalArgumentException{
        List<Lotto> lottos = new ArrayList<>();
        Integer usedAmount = 0;
        while(!usedAmount.equals(purchaseAmount)){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
            usedAmount += 1000;
        }
        return lottos;
    }

    public Integer getLottoQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
