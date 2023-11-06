package lotto;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PurchaseNumTest{
    @DisplayName("구매 가격이 1000이하이면 예외가 발생한다.")
    @Test
    void 구매_가격_1000_이하_테스트(){
        assertThatThrownBy(() -> new PurchaseAmount("800"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 가격이 정수가 아니면 예외가 발생한다.")
    @Test
    void 구매_가격_정수_테스트(){
        assertThatThrownBy(() -> new PurchaseAmount("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 가격이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void 구매_가격_1000_단위_테스트(){
        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 가격이 정상일 경우 올바른 값을 저장한다.")
    @Test
    void 구매_가격_정상작동_테스트(){
        int expectedResult = 1000;
        PurchaseAmount purchaseAmount = new PurchaseAmount("1000");
        assertEquals(expectedResult, purchaseAmount.getAmout());
    }

    // 아래에 추가 테스트 작성 가능
}