package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerBuyPriceTest {

    @DisplayName("validateCharacterFromAmount() : 구입 금액에 문자가 들어가는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,000", "1,000,000", "1000e", "dollar", "e1000"})
    void validateCharacterFromAmount_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 구입 금액에 문자가 들어갈 수 없습니다. 구입 금액은 숫자만 입력해주세요.";

        //when //then
        assertThatThrownBy(() -> new PlayerBuyPrice(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}