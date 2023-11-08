package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private static final Integer LOTTO_MIN_NUM = 1;
    private static final Integer LOTTO_MAX_NUM = 45;
    private static final Integer LOTTO_NUMBER_SIZE = 6;

    private List<Lotto> lottos;
    private Integer purchaseAmount;

    public User(Integer purchaseAmount){
        Validator.checkAmount(purchaseAmount);
        this.lottos = purchaseLotto(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private List<Lotto> purchaseLotto(Integer purchaseAmount) throws IllegalArgumentException{
        List<Lotto> lottos = new ArrayList<>();
        publishLottos(purchaseAmount, lottos);
        return lottos;
    }

    private void publishLottos(Integer purchaseAmount, List<Lotto> lottos) {
        Integer usedAmount = 0;
        while(!usedAmount.equals(purchaseAmount)){
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUMBER_SIZE));
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
            usedAmount += 1000;
        }
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
