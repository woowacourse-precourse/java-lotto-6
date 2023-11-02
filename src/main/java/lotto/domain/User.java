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
    private List<Lotto> lotto = new ArrayList<>();

    private User(){}

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTotalReward() {
        return totalReward;
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public static User create(long purchaseAmount) {
        User user = new User();
        user.purchaseAmount = user.purchaseAmountValidate(purchaseAmount);
        user.quantity = user.purchaseAmount/1000;
        return user;
    }

    private int purchaseAmountValidate(long inputPurchaseAmount){
        if(purchaseAmount == 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if(purchaseAmount > 2000000000){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_MAXIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if(purchaseAmount % 1000 != 0){
            throw new IllegalArgumentException(ErrorMessage.NOT_MET_PURCHASE_UNIT.getMessage());
        }
        return purchaseAmount;
    }
}
