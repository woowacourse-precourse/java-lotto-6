package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.dto.CreateUserDto;
import lotto.global.ErrorMessage;

public class User {
    // 최대 가능 구매 금액 20억 까지 설정.
    private int purchaseAmount;
    private int quantity;
    // 당첨 금액은 20억보다 클 수 있기 때문에 int시 overFlow 가능성 있음
    private long totalReward;
    private List<Lotto> lotto;

    private User() {
    }
    public static User create(CreateUserDto createUserDto){
        User user = new User();
        user.purchaseAmount = createUserDto.getPurchaseAmount();
        user.quantity = createUserDto.getQuantity();
        user.lotto = createUserDto.getPublishedLotto();
        return user;
    }

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
}
