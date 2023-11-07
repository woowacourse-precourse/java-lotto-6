package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static lotto.constants.Constants.Integers.LOTTO_PRICE;
import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_MORE_THAN_LOTTO_PRICE;
import static lotto.constants.ErrorMessage.HAVE_TO_INPUT_MULTIPLE_OF_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * todo : 이해하기 쉬운 단순한 테스트로 수정하기
 * 로또의 가격이 변경되어도 동작하는 테스트를 만들려고 했으나, 변경의 여지가 작고,
 * 공유중인 상수 값의 변경이 아닌 다른 방식으로 변경되어야 할 것 같다.
 */
public class PurchaseBudgetTest {

    static IntStream lottoBudgets() {
        return IntStream.of(LOTTO_PRICE.getValue(), LOTTO_PRICE.getValue() * 2, LOTTO_PRICE.getValue() * 3);
    }

    @DisplayName("구매 금액 생성 : 정상 생성")
    @ParameterizedTest
    @MethodSource("lottoBudgets")
    public void createBudget(int budget) throws Exception {
        //when
        PurchaseBudget purchaseBudget = new PurchaseBudget(budget);

        //then
        assertThat(purchaseBudget.getBudget()).isEqualTo(budget);
    }

    static IntStream shortLottoBudgets() {
        return IntStream.of(-1, 0, LOTTO_PRICE.getValue() - 1, LOTTO_PRICE.getValue() - 2);
    }

    @DisplayName("구매 금액 생성 예외 : 구매 금액이 로또 한 장의 가격보다 싸거나 음수인 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @MethodSource("shortLottoBudgets")
    public void createBudget_exception_lessThan_oneLottoPrice(int shortBudget) throws Exception {
        //when, then
        assertThatThrownBy(() -> new PurchaseBudget(shortBudget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAVE_TO_INPUT_MORE_THAN_LOTTO_PRICE.getMessage());
    }

    /**
     * 주의! 대략 로또 장당 가격이 변경되어 가격 * 4이 integer의 최대범위를 초과하면 테스트가 실패한다.
     */
    static IntStream notMultiple_LottoBudget() {
        int notMultipleValue = LOTTO_PRICE.getValue() + 1;

        return IntStream.of(
                LOTTO_PRICE.getValue() + notMultipleValue,
                (LOTTO_PRICE.getValue() * 2) + notMultipleValue,
                (LOTTO_PRICE.getValue() * 3) + notMultipleValue
        );
    }


    @DisplayName("구매 금액 생성 예외 : 구매 금액이 로또 한장의 가격의 배수가 아닌 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @MethodSource("notMultiple_LottoBudget")
    public void createBudget_exception_notMultipleOf_oneLottoPrice(int notMultipleBudget) throws Exception {
        //when, then
        assertThatThrownBy(() -> new PurchaseBudget(notMultipleBudget))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HAVE_TO_INPUT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
    }

    static IntStream multipleOfLottoPrice() {
        return IntStream.of(
                LOTTO_PRICE.getValue() * 1,
                LOTTO_PRICE.getValue() * 2,
                LOTTO_PRICE.getValue() * 3
        );
    }

    @DisplayName("구매한 로또 수량 반환")
    @ParameterizedTest
    @MethodSource("multipleOfLottoPrice")
    public void budget_getPurchaseQuantity(int budget) throws Exception {
        PurchaseBudget purchaseBudget = new PurchaseBudget(budget);
        int purchaseQuantityValue = budget / LOTTO_PRICE.getValue();

        //when
        PurchaseQuantity purchaseQuantity = purchaseBudget.createQuantity();

        //then
        assertThat(purchaseQuantity.getPurchaseQuantity()).isEqualTo(purchaseQuantityValue);
    }
}
