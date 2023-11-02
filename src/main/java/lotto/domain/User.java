package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.global.ErrorMessage;

public class User {
    // 최대 가능 구매 금액 20억 까지 설정.
    private int purchaseAmount;
    private int quantity;
    // 당첨 금액은 20억보다 클 수 있기 때문에 int시 overFlow 가능성 있음
    private long totalReward;
    List<Lotto> lotto = new ArrayList<>();

    private User(){}

    public static User create(String purchaseAmount) {
        User user = new User();
        user.purchaseAmount = user.purchaseAmountValidate(purchaseAmount);
        user.quantity = user.purchaseAmount/1000;
        return user;
    }

    private int purchaseAmountValidate(String inputPurchaseAmount){
        long purchaseAmount = Long.parseLong(inputPurchaseAmount);
        if(purchaseAmount == 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MEET_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if(purchaseAmount > 2000000000){
            throw new IllegalArgumentException(ErrorMessage.NOT_MEET_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MEET_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        return (int) purchaseAmount;
    }
}
