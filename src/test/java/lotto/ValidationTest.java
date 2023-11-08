package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void price() {
        //given
        int userPurchaseAmount = 1001;

        //when//then
        assertThatThrownBy(() -> validation.price(userPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 1장의 가격은 1,000원 입니다. 1,000원 단위로 다시 입력해 주세요.");

    }

    @DisplayName("보너스 번호가 당첨 번호와 일치하면 예외가 발생한다.")
    @Test
    void bonusNumberCheck() {
        //given
        int bonusNumber = 45;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        //when//then
        assertThatThrownBy(() -> validation.bonusNumberCheck(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.");

    }

    @DisplayName("로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void numberRangeLessThan() {
        //given
        int number = 0;

        //when//then
        assertThatThrownBy(() -> validation.numberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위는 1~45 입니다.");

    }

    @DisplayName("로또 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void numberRangeMoreThan() {
        //given
        int number = 46;

        //when//then
        assertThatThrownBy(() -> validation.numberRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위는 1~45 입니다.");

    }
}