package lotto.UI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;


import lotto.data.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class UserViewTest {
    private UserView userView;

    @BeforeEach
    void setUp() {
        userView = new UserView();
    }

    @ParameterizedTest
    @MethodSource("parameterProviderMoneyEdit")
    void moneyEdit_상금액수_출력형식_변경_테스트(Rewards reward, String expect) {
        assertThat(userView.moneyEdit(reward)).isEqualTo(expect);
    }

    static Stream<Arguments> parameterProviderMoneyEdit() {
        return Stream.of(
                arguments(Rewards.FIRST, "(2,000,000,000원)"),
                arguments(Rewards.SECOND, "(30,000,000원)"),
                arguments(Rewards.THIRD, "(1,500,000원)"),
                arguments(Rewards.FOURTH, "(50,000원)"),
                arguments(Rewards.FIFTH, "(5,000원)")
        );
    }
}