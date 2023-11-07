package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.dto.UserMoneyDTO;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserMoneyTest {
    private UserMoneyDTO userMoneyDTO;

    @ParameterizedTest
    @ValueSource(strings = {"1", "11", "1111"})
    void 정해진_단위로_떨어지지_않는다면_예외(String inputMoney) {
        assertThatThrownBy(
                () -> {
                    userMoneyDTO = new UserMoneyDTO(inputMoney);
                    userMoneyDTO.toUserMoney();
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위의");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "200000"})
    void 정해진_단위로_떨어진다면_성공(String inputMoney) {
        assertThatNoException().isThrownBy(
                () -> {
                    userMoneyDTO = new UserMoneyDTO(inputMoney);
                    userMoneyDTO.toUserMoney();
                });
    }


}
