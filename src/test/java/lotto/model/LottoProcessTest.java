package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.enums.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.enums.MagicVariable.LOTTO_PRICE;

class LottoProcessTest {
    private static final String PURCHASE_MONEY = "3000";
    LottoProcess lottoProcess = new LottoProcess();

    private void lottoPurchaseMoneyExceptionTest(String money, ErrorMessage errorMessage) {
        assertThatThrownBy(() -> lottoProcess.purchaseLotto(money))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(errorMessage.getErrorMessage());

    }

    @DisplayName("랜덤 번호 생성 확인")
    @Test
    void 랜덤_번호_생성_확인() {
        Assertions.assertNotNull(lottoProcess.purchaseLotto(PURCHASE_MONEY));
    }

    @DisplayName("로또 구매매금액에 맞는 갯수인지 확인")
    @Test
    void 로또_구매금액에_맞는_갯수인지_확인() {
        assertThat(lottoProcess.purchaseLotto(PURCHASE_MONEY).size()).isEqualTo(Integer.parseInt(PURCHASE_MONEY) / LOTTO_PRICE.getNumber());
    }

    @DisplayName("구매 단위가 1000원 단위가 아닌 경우 예외 확인")
    @Test
    void 구매_단위_1000원_단위_아닌_경우_예외_확인() {
        lottoPurchaseMoneyExceptionTest("3500", ErrorMessage.PRICE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구매금액이 음수일 경우 예외 확인")
    void 구매금액_음수일_경우_예외_확인() {
        lottoPurchaseMoneyExceptionTest("-3000", ErrorMessage.PRICE_NEGATIVE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("구매금액이 문자일 경우 예외 확인")
    void 구매금액_문자일_경우_예외_확인() {
        lottoPurchaseMoneyExceptionTest("a3000", ErrorMessage.PRICE_TYPE_ERROR_MESSAGE);
    }
}