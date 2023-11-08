package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 3000, 5000})
    @DisplayName("정상 금액이 입력된 경우 PurchaseAmount객체 생성 체크")
    void 정상_금액이_입력된_경우_객체_생성_테스트(int purchaseAmount) throws Exception {
        //given
        //when
        PurchaseAmount purchaseAmountInstance = PurchaseAmount.getInstance(purchaseAmount);
        //then
        assertThat(purchaseAmountInstance.getPurchaseAmount()).isEqualTo(purchaseAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {300, 1400, 10001})
    @DisplayName("1000원 이하 또는 1000원 단위의 금액이 입력되지 않은 경우")
    void 천원_이하_천원_단위가_아닌_경우에_대한_테스트(int purchaseAmount) throws Exception {
        //given
        //when
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> PurchaseAmount.getInstance(purchaseAmount));
    }

}