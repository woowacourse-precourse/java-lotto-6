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
    void nonNumericCharInInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.purchaseAmountInput("11000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11000)));
        assertThat(input.purchaseAmountInput("1123400"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11234000)));

        // 비정상인 경우 테스트
        assertThatThrownBy(() -> input.purchaseAmountInput("!110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("+110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("-110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("110000@"))
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
