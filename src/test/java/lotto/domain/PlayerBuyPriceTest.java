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

    @DisplayName("validateRangeFromAmount() : 구입 금액이 1,000원 이하, 10,000,000원 이상인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"0","0100", "999", "1000000000"})
    void validateRangeFromAmount_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 구입 금액 범위를 벗어났습니다. 1,000원 ~ 10,000,000원 내 금액을 입력해주세요.";

        //when //then
        assertThatThrownBy(() -> new PlayerBuyPrice(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }

    @DisplayName("validateUnitFromAmount() : 구입 금액이 1,000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"4321","1110","100100"})
    void validateUnitFromAmount_Fail(String amount) throws Exception {
        //given
        String exceptionMessage = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";

        //when //then
        assertThatThrownBy(() -> new PlayerBuyPrice(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}