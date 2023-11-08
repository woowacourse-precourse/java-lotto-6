package lotto.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.constant.message.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.util.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class PurchaseServiceTest {

    private PurchaseService purchaseService;
    private ValidationUtil validationUtil;

    @BeforeEach
    void setUp() {
        purchaseService = new PurchaseService();
        validationUtil = new ValidationUtil();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "5000"})
    @DisplayName("구매양만큼 로또를 발행한다.")
    void shouldGenerateLottoBasedOnPurchaseAmount(String purchase) {
        LottoPurchase lottoPurchase = purchaseService.getInputPurchase(purchase);
        List<Lotto> purchaseLotto = lottoPurchase.getPurchaseLotto();
        int expectedCount = Integer.parseInt(purchase) / 1000;
        assertThat(purchaseLotto).hasSize(expectedCount);
    }

    @Test
    @DisplayName("올바르지 않은 구매금액 입력시 예외 발생")
    void shouldThrowArithmeticExceptionForInvalidPurchaseInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateNumberType", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "10abc";

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    @Test
    @DisplayName("올바르지 않은 구매금액인 0을 입력시 예외 발생")
    void shouldThrowArithmeticExceptionForZeroPurchaseInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateAmount", int.class);
        method.setAccessible(true);

        //when
        int purchaseAmount = 0;

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessageContaining(ExceptionMessage.IS_NOT_ZERO.getMessage());
        }
    }

    @Test
    @DisplayName("구매금액을 1000원으로 떨어지지 않는 입력 시 예외 발생")
    void shouldThrowIllegalArgumentExceptionForInvalidPurchaseInput() throws Exception {
        //given
        Method method = validationUtil.getClass().getDeclaredMethod("validateDivision", String.class);
        method.setAccessible(true);

        //when
        String purchaseAmount = "3500";

        // then
        try {
            method.invoke(validationUtil, purchaseAmount);
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException())
                    .isInstanceOf(ArithmeticException.class)
                    .hasMessageContaining(ExceptionMessage.PURCHASE_ERROR.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"2000", "4000", "1000"})
    @DisplayName("올바른 금액 입력 시 올바른 범위 내의 번호 생성")
    void shouldGenerateLottoWithValidNumbers(String number) {
        LottoPurchase lottoPurchase = purchaseService.getInputPurchase(number);
        List<Lotto> purchaseLotto = lottoPurchase.getPurchaseLotto();

        for (Lotto lotto : purchaseLotto) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            assertThat(lottoNumbers).allMatch(num -> num >= 1 && num <= 45);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"3000"})
    @DisplayName("입력받은 값을 1000으로 나누어 떨어진 값이 저장된다.")
    void shouldReturnLottoPurchaseAmount(String purchase) {
        LottoPurchase lottoPurchase = purchaseService.getInputPurchase(purchase);
        int amount = lottoPurchase.getAmount();
        assertThat(amount).isEqualTo(3);
    }
}
