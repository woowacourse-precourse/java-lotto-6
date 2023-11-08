package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.domain.Money;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    Money money;

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("입력 받은 구입 금액이 잘 저장되는지 테스트")
    @Test
    void createMoneyTest() {
        Money answer = Money.from("8000");

        System.setIn(new ByteArrayInputStream("8000".getBytes()));
        money = Money.from(InputView.inputAmount());

        assertThat(answer).usingRecursiveComparison().isEqualTo(money);
    }

    @DisplayName("금액이 숫자가 아닐 때 예외 처리 테스트")
    @Test
    void validateTypeTest() {
        assertThatThrownBy(() -> Money.from("hi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 가격보다 작은 수를 입력했을 때 예외 처리 테스트")
    @Test
    void validateRangeTest() {
        assertThatThrownBy(() -> Money.from("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 가격으로 나누어 떨어지지 않을 때 예외 처리 테스트")
    @Test
    void validateDivideTest() {
        assertThatThrownBy(() -> Money.from("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
