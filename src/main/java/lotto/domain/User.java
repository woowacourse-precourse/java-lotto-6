package lotto.domain;

import java.util.List;
import lotto.controller.dto.CreateUserDto;

public class User {
    // 최대 가능 구매 금액 10만원 까지 설정.
    private int purchaseAmount;
    private int quantity;
    private List<Lotto> lotto;

    private User() {
    }

    public static User create(CreateUserDto createUserDto) {
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

    public List<Lotto> getLotto() {
        return lotto;
    }
}
