package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.IllegalArgumentExceptionType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseCostTest {
    private static final int ONE = 1;
    private static final int INVALID_PURCHASE_AMOUNT_ZERO = 0;
    private static final int INVALID_PURCHASE_AMOUNT_NEGATIVE_THOUSAND = -1000;
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 2_000_000_000;

    @DisplayName("최소금액_실패_테스트")
    @Test
    void createPurchaseCostLessThanMinimumRange() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> new LottoPurchaseCost(INVALID_PURCHASE_AMOUNT_ZERO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getMessage());
        softAssertions.assertThatThrownBy(() -> new LottoPurchaseCost(INVALID_PURCHASE_AMOUNT_NEGATIVE_THOUSAND))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.INSUFFICIENT_MONEY.getMessage());

        softAssertions.assertAll();
    }

    @DisplayName("최대금액_실패_테스트")
    @Test
    void createPurchaseCostLessThanMaximumRange() {
        int exceededAmount = MAX_PURCHASE_AMOUNT + LOTTO_PRICE;

        assertThatThrownBy(() -> new LottoPurchaseCost(exceededAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.MAX_MONEY_EXCEEDED.getMessage());
    }

    @DisplayName("금액_나머지_실패_테스트")
    @Test
    void createPurchaseCostWithRemainingAmountOfMoney() {
        int remainFailAmount = LOTTO_PRICE + ONE;

        assertThatThrownBy(() -> new LottoPurchaseCost(remainFailAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgumentExceptionType.MONEY_REMAINS_EXIST.getMessage());
    }
    @DisplayName("로또_구매_금액_입력_성공_테스트")
    @Test
    void createPurchaseCostByValidAmountOfMoney() {
        int exampleAmount = LOTTO_PRICE * LOTTO_PRICE;

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThatCode(() -> new LottoPurchaseCost(LOTTO_PRICE)).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> new LottoPurchaseCost(MAX_PURCHASE_AMOUNT)).doesNotThrowAnyException();
        softAssertions.assertThatCode(() -> new LottoPurchaseCost(exampleAmount)).doesNotThrowAnyException();
        softAssertions.assertAll();
    }

    @DisplayName("로또_구매_비용_조회_테스트")
    @Test
    void getPurchaseCostByGetter() {
        LottoPurchaseCost lottoPurchaseCost1 = new LottoPurchaseCost(LOTTO_PRICE);
        LottoPurchaseCost lottoPurchaseCost2 = new LottoPurchaseCost(MAX_PURCHASE_AMOUNT);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(lottoPurchaseCost1.getCost()).isEqualTo(LOTTO_PRICE);
        softAssertions.assertThat(lottoPurchaseCost2.getCost()).isEqualTo(MAX_PURCHASE_AMOUNT);
        softAssertions.assertAll();
    }

    @DisplayName("로또_구매_개수_테스트")
    @Test
    void getPurchasedLottoAmount() {
        LottoPurchaseCost lottoPurchaseCost1 = new LottoPurchaseCost(LOTTO_PRICE);
        LottoPurchaseCost lottoPurchaseCost2 = new LottoPurchaseCost(MAX_PURCHASE_AMOUNT);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(lottoPurchaseCost1.getLottoAmount()).isEqualTo(ONE);
        softAssertions.assertThat(lottoPurchaseCost2.getLottoAmount())
                .isEqualTo(MAX_PURCHASE_AMOUNT / LOTTO_PRICE);
        softAssertions.assertAll();
    }
}