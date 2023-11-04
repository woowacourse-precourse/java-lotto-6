package lotto.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.UserMoney;
import lotto.dto.input.UserMoneyDTO;
import lotto.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserMoneyDTOTest {
    private UserMoneyDTO userMoneyDTO;
    // 공통 검증까지!!!
    // 사적 검증까지!!!
    @ParameterizedTest
    @ValueSource(strings = {"2000"})
    void userMoneyDTO_userMoney_변환_검증(String input) {
        UserMoneyDTO userMoneyDTO = new UserMoneyDTO(input);
        UserMoney userMoney = userMoneyDTO.toUserMoney();

        Assertions.assertThat(userMoney).isEqualTo(UserMoney.from(Parser.inputToNumber(input)));
    }

    @ParameterizedTest(name = "인자 : {0}")
    @NullAndEmptySource
    void 아무것도_입력하지_않은_경우_예외(String inputMoney) {
        assertThatThrownBy(() -> userMoneyDTO = new UserMoneyDTO(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("아무것도 입력하지");
    }

    @ParameterizedTest(name = "인자 : {0}")
    @ValueSource(strings = {"1001,", "뮤10"})
    void 숫자가_아닌_경우_예외(String inputMoney) {
        assertThatThrownBy(() -> userMoneyDTO = new UserMoneyDTO(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하지");
    }

    @ParameterizedTest(name = "인자 : {0}")
    @ValueSource(strings = {"000", "01","01234"})
    void 첫번쨰_숫자가_0이고_길이가_1보다_크다면_예외(String inputMoney) {
        assertThatThrownBy(() -> userMoneyDTO = new UserMoneyDTO(inputMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0으로 시작하는 수는");
    }
}
