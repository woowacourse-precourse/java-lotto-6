package lotto.service;

import lotto.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @DisplayName("입력한 로또 구입 금액이 숫자가 아닌 문자열로 이루어져 있을 때 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1000a", "500abc", "", "안녕"})
    void inputBuyLottoAmountNotNumber(String buyAmount) {
        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 로또 구입 금액이 1000원 단위로 나누어 떨어지지 않을 때 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "500", "900", "1500", "1", "999"})
    void inputBuyLottoAmountIndivisible(String buyAmount) {
        assertThatThrownBy(() -> lottoService.buyLottoAmountValidate(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨 번호에 숫자가 아닌 것 포함된 경우 예외 처리")
    @Test
    void inputUserLottoNumberNotNumber() {
        String inputUserLottoNumber = "1,2,3,4,5,a";
        assertThatThrownBy(() -> lottoService.userLottoNumbersValidate(inputUserLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨 번호의 숫자가 6개가 아닌 경우 예외 처리")
    @Test
    void inputUserLottoNumberInvalidateCount() {
        String inputUserLottoNumber = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoService.userLottoNumbersValidate(inputUserLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨 번호에 숫자가 1~45 범위가 아닌 경우 예외 처리")
    @Test
    void inputUserLottoNumberInvalidateRange() {
        String inputUserLottoNumber = "1,2,3,4,5,46";
        assertThatThrownBy(() -> lottoService.userLottoNumbersValidate(inputUserLottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("입력한 당첨 번호가 서로 중복될 때 예외 처리")
    @Test
    void inputUserLottoNumberDuplicate() {
        String inputUserLottoNumber = "1,1,3,4,5,6";
        assertThatThrownBy(() -> lottoService.userLottoNumbersValidate(inputUserLottoNumber))
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

    @DisplayName("보너스 번호의 범위가 1~45가 아닐 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "50", "100", "999"})
    void inputBonusNumberInvalidateRange(String inputUserBonusNumber) {
        String inputUserLottoNumber = "1,2,3,4,5,6";

        assertThatThrownBy(() -> lottoService.userBonusNumberValidate(inputUserLottoNumber, inputUserBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @DisplayName("사용자가 입력한 당첨 번호, 보너스 번호 저장")
    @Test
    void setUserLottoNumbersAndBonusNumber() {
        String lottoNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        Map<String, String> userLottoNumbersAndBonusNumber =
                lottoService.setUserLottoNumbersAndBonusNumber(lottoNumbers, bonusNumber);

        assertThat(userLottoNumbersAndBonusNumber.containsKey("userLottoNumbers")).isTrue();
        assertThat(userLottoNumbersAndBonusNumber.containsKey("userBonusNumber")).isTrue();
        assertThat(userLottoNumbersAndBonusNumber.get("userLottoNumbers")).isEqualTo(lottoNumbers);
        assertThat(userLottoNumbersAndBonusNumber.get("userBonusNumber")).isEqualTo(bonusNumber);
    }

    @DisplayName("로또 1등~5등 당첨 결과 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void winningResultTest(int rank) {
        String userLottoNumbers = "";
        String userBonusNumber = "7";
        LottoRank lottoRank = null;
        if (rank == 1) {
            lottoRank = LottoRank.FIRST;
            userLottoNumbers = "1,2,3,4,5,6";
        } else if (rank==2) {
            lottoRank = LottoRank.SECOND;
            userLottoNumbers = "1,2,3,4,5,8";
            userBonusNumber = "6";
        } else if (rank==3) {
            lottoRank = LottoRank.THIRD;
            userLottoNumbers = "1,2,3,4,5,8";
        } else if (rank==4) {
            lottoRank = LottoRank.FOURTH;
            userLottoNumbers = "1,2,3,4,8,9";
        } else if (rank==5) {
            lottoRank = LottoRank.FIFTH;
            userLottoNumbers = "1,2,3,8,9,10";
        }
        Map<String, String> userLottoNumberAndBonusNumber = new HashMap<>();
        userLottoNumberAndBonusNumber.put("userLottoNumbers", userLottoNumbers);
        userLottoNumberAndBonusNumber.put("userBonusNumber", userBonusNumber);
        List<List<Integer>> mockLottoTicket = new ArrayList<>(List.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Map<LottoRank, Integer> lottoWinningResult = lottoService.getLottoWinningResult(
                userLottoNumberAndBonusNumber, mockLottoTicket
        );

        assertThat(lottoWinningResult.size()).isEqualTo(6);
        assertThat(lottoWinningResult.get(lottoRank)).isEqualTo(1);
    }
}