package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("로또 구입 금액이 숫자가 아닌 문자열로 이루어져있을 때 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1000a", "500abc", "", "안녕"})
    void inputBuyLottoAmountNotNumber(String buyAmount) {
        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 1000원 단위로 나누어 떨어지지 않을 때 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "900", "1500", "1", "999"})
    void inputBuyLottoAmountIndivisible(String buyAmount) {
        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("당첨 번호와 보너스 번호의 중복 예외 처리")
    @Test
    void lottoNumberByDuplicateBonusNumber() {
        String inputUserLottoNumber = "1,2,3,4,5,6";
        String inputUserBonusNumber = "1";

        assertThatThrownBy(() -> lottoService.userBonusNumberValidate(inputUserLottoNumber, inputUserBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외 처리")
    @Test
    void inputBonusNumberNotNumber() {
        String inputUserLottoNumber = "1,2,3,4,5,6";
        String inputUserBonusNumber = "123abc";

        assertThatThrownBy(() -> lottoService.userBonusNumberValidate(inputUserLottoNumber, inputUserBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("보너스 번호의 범위가 1~45가 아닐 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "50", "100", "999"})
    void inputBonusNumberInvalidateRange(String inputUserBonusNumber) {
        String inputUserLottoNumber = "1,2,3,4,5,6";

        assertThatThrownBy(() -> lottoService.userBonusNumberValidate(inputUserLottoNumber, inputUserBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }
}