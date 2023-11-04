package lotto.dto;

import lotto.domain.UserMoney;
import lotto.dto.input.UserMoneyDTO;
import lotto.util.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class userMoneyDTOTest {
    @ParameterizedTest
    @ValueSource(strings = {"2000"})
    void userMoneyDTO_userMoney_변환_검증(String input) {
        UserMoneyDTO userMoneyDTO = new UserMoneyDTO(input);
        UserMoney userMoney = userMoneyDTO.toUserMoney();

        Assertions.assertThat(userMoney).isEqualTo(UserMoney.from(Parser.inputToNumber(input)));
    }

    @ParameterizedTest
    @MethodSource()
    void 예외() {

    }
}
