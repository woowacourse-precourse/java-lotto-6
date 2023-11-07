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
 * todo :
 * 주의! 로또 장당 가격 상수의 값을 너무 크게 혹은 작게 바꾸면 테스트에 문제가 생길 수 있다.
 *
 * case 1) 만약 현재 로또 장당 가격이 변경되어 (가격 * 3)이 integer의 최대범위를 초과하면 테스트가 실패한다.
 * case 2) 로또 장당 가격이 1로 변경되면 배수 관련 예외가 발생하지 않는다.
 * case 3) 로또 가격이 0원이 되고, budget도 0원이면 다른 예외가 발생한다.
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
}
