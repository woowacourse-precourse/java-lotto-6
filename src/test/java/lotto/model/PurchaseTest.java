package lotto.model;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("구입 금액 테스트")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PurchaseTest {
    private static final String VALID_MONEY = "1000";
    private static final String INVALID_MONEY_NOT_NUMBER = "abc";
    private static final String INVALID_MONEY_MINIMUM_LIMIT = "999";
    private static final String INVALID_MONEY_UNIT_LIMIT = "1001";

    private List<Lotto> twoLottos;

    @BeforeEach
    void setUp() {
        twoLottos = new ArrayList<>();
        twoLottos.add(new Lotto(LotteryBallMachine.generateNumbers()));
        twoLottos.add(new Lotto(LotteryBallMachine.generateNumbers()));
    }

    @Test
    @Order(1)
    @DisplayName("올바른 구입 금액이 입력된 경우")
    void validatePurchaseMoney() {
        Purchase<Lotto> purchase = new Purchase<>(VALID_MONEY);
        assertThat(purchase.getMoney()).isEqualTo(1000);
    }

    @Test
    @Order(2)
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    void validatePurchaseMoneyNotNumber() {
        assertThatThrownBy(() -> new Purchase<Lotto>(INVALID_MONEY_NOT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(3)
    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    void validatePurchaseMoneyMinimumLimit() {
        assertThatThrownBy(() -> new Purchase<Lotto>(INVALID_MONEY_MINIMUM_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(4)
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    void validatePurchaseMoneyUnitLimit() {
        assertThatThrownBy(() -> new Purchase<Lotto>(INVALID_MONEY_UNIT_LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(5)
    @DisplayName("구입 금액과 구매 개수가 일치하지 않으면 예외가 발생한다.")
    void validatePurchaseItemsSizeNotMatch() {
        Purchase<Lotto> purchase = new Purchase<>(VALID_MONEY);

        assertThatThrownBy(() -> purchase.purchaseItems(twoLottos))
                .isInstanceOf(IllegalStateException.class);
    }
}