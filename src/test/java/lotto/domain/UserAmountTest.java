package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three", "yoon", "su"})
    void 로또_굳입_금액이_숫자가_아니면_IllegalArgumentException_발생_검증(String userAmount) {
        assertThatThrownBy(() ->UserAmount.from(userAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
    }

    @Test
    void 로또_구입_금액이_공백을_포함하면_IllegalArgumentException_예외처리() {
        //given
        String emptyValue = "  6 ";

        //when & then
        Assertions.assertThatThrownBy(() -> UserAmount.from(emptyValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 공백이 포함될 수 없습니다.");
    }

    @Test
    void 로또_구입_금액이_1000으로_나누어떨이지지_않으면_IllegalArgumentException_예외처리() {
        //given
        String notDivideByStandardUserAmount = "666666";

        //when & then
        Assertions.assertThatThrownBy(() -> UserAmount.from(notDivideByStandardUserAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1000으로 나누어떨어져야 합니다.");
    }

    @Test
    void 발행_가능한_로또_수량을_계산하는_기능_검증() {
        //given
        String userAmountInput = "6000";
        UserAmount userAmount = UserAmount.from(userAmountInput);
        int testUserAmount = Integer.parseInt(userAmountInput) / 1000;

        //when
        int issueAbleCount = userAmount.calculateIssueAbleCount();

        //then
        Assertions.assertThat(issueAbleCount).isEqualTo(testUserAmount);
    }
}
