package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserWalletTest {
    static final int MONEY = 5000;
    UserWallet userWallet;
    @BeforeEach
    void init(){
        userWallet = UserWallet.createWallet(MONEY);
    }

    @Test
    @DisplayName("정해진_금액만큼_구매.")
    void buyLotto() {
        assertEquals(userWallet.buyLotto(), MONEY);
    }

    @Test
    @DisplayName("createWallet_정적_팩토리_메서드_생성_테스트")
    void createWallet() {
        assertEquals(userWallet.getMoney(), UserWallet.createWallet(MONEY).getMoney());
    }

    @Test
    @DisplayName("당첨금_수령_테스트")
    void receiveWinningsMoney() {
        userWallet.receiveWinningsMoney(50000);
        assertEquals(userWallet.getMoney(), 55000);
    }
}