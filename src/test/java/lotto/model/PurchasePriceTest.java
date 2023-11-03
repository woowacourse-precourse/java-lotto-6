package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchasePriceTest {
    @ParameterizedTest
    @ValueSource(strings = {"8000", "56000"})
    @DisplayName("로또 구입 금액 저장 값 검증")
    public void 로또_구입금액_확인(String input){
        String price = input;
        PurchasePrice purchasePrice = new PurchasePrice(price);

        int myResult = purchasePrice.getCountPieceOfLotto();
        int expectedResult = Integer.parseInt(price) / 1000;
        assertEquals(myResult,expectedResult);
    }
    @ParameterizedTest
    @ValueSource(strings = {"900", "500"})
    @DisplayName("[예외처리]로또 구입 금액이 1000원 이하일 때")
    public void 구입금액이_1000원_이하일때(String input){
        String price = input;
        Assertions.assertThatThrownBy(()-> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원입니다.");
    }
    @ParameterizedTest
    @ValueSource(strings = {"1100", "3567"})
    @DisplayName("[예외처리]로또 구입 금액이 1000으로 나누어 떨어지지 않을 때")
    public void 구입금액이_1000원으로_안떨어질때(String input){
        String price = input;
        Assertions.assertThatThrownBy(()-> new PurchasePrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("나누어 떨어져야 합니다.");
    }


}
