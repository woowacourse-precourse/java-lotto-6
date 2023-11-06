package lotto;

import lotto.enums.Messages;
import lotto.model.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IOTest {
    @DisplayName("올바른 금액 입력 태스트")
    @Test
    void inputAmountCorrect(){
        String amount = "8000";
        assertThat(InputView.intputAmount(amount)).isEqualTo(8);
    }

    @DisplayName("1000원 단위의 금액을 입력하지 않았을 경우 태스트")
    @Test
    void inputAmountDevideException(){
        String amount = "8500";
        assertThatThrownBy(() ->InputView.intputAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.PRICE_DEVIDE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("정수 외의 입력이 있을 경우 태스트")
    @Test
    void nonePureInputException(){
        String amount = "8000j";
        assertThatThrownBy(() ->InputView.intputAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Messages.PURE_INTEGER_ERROR_MESSAGE.getMessage());
    }
}
