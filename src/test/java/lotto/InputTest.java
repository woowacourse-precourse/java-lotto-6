package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @DisplayName("구매 금액 입력시 비정상적인 문자열을 받는 경우")
    @Test
    void illigalPurchaseAmountInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.purchaseAmountInput("11000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11000)));
        assertThat(input.purchaseAmountInput("11234000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11234000)));

        // 비정상적인 경우 테스트
        // 문자열에 숫자를 제외한 다른 문자가 있을 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("!110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("+110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("-110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("110000@"))
                .isInstanceOf(IllegalArgumentException.class);
        // 문자열이 비어있는 경우
        assertThatThrownBy(() -> input.purchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        // 구매 금액이 1000으로 나누어 떨어지지 않는 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 비정상적인 문자열을 받는 경우")
    @Test
    void illigalBonusNumberInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.bonusNumberInput("11"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11)));
        assertThat(input.purchaseAmountInput("45"))
                .isEqualTo(new ArrayList<>(Arrays.asList(45)));

        // 비정상적인 경우 테스트
        // 문자열에 숫자를 제외한 다른 문자가 있을 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("!1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("1#"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("-23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("+5"))
                .isInstanceOf(IllegalArgumentException.class);
        // 문자열이 비어있는 경우
        assertThatThrownBy(() -> input.purchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        // 보너스 번호가 1 ~ 45 사이가 아닐 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
}
