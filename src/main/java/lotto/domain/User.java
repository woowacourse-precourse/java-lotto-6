package lotto.domain;

import lotto.utils.Validator;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lottos;
    private Integer purchaseAmount;

    public User(Integer purchaseAmount){
        Validator.checkAmount(purchaseAmount);
        lottos = new ArrayList<>();
        this.purchaseAmount = purchaseAmount;
    }


}
