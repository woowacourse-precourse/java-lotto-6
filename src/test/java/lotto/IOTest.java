package lotto;

import lotto.enums.Messages;
import lotto.model.Lotto;
import lotto.utils.Order;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @DisplayName("오름차순 출력 확인")
    @Test
    void orderPrint(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(22);
        numbers.add(6);
        numbers.add(17);
        numbers.add(1);
        numbers.add(15);
        Lotto lotto = new Lotto(numbers);
        assertThat(Order.orderNumbers(lotto.getNumbers()).toString()).isEqualTo("[1, 6, 15, 17, 22, 40]");
    }
}
