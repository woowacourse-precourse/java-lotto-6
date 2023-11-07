package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.ErrorCode.*;
import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void init() {
        lottoService = new LottoService();
    }

    @DisplayName("로또 당첨 결과 테스트 - 성공")
    @Test
    void calculateResultTest() {
        //given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(1,2,3,4,5,7)),
                new Lotto(List.of(1,2,3,4,5,8)),
                new Lotto(List.of(1,2,3,4,10,11)),
                new Lotto(List.of(1,2,3,10,11,12)),
                new Lotto(List.of(1,2,10,11,12,13))
        );
        //when then
        assertThat(lottoService.calculateResult(winningLotto, bonusNumber, lottoList, new int[7]))
                .isEqualTo((float) (FIRST.reward +SECOND.reward + THIRD.reward + FORTH.reward + FIFTH.reward + SIXTH.reward) / (6 * 1000));
    }

    @DisplayName("구매 테스트 - 성공")
    @Test
    void purchaseTest() {
        //given
        String input = "2000";
        //when then
        assertThat(lottoService.purchase(input)).isEqualTo(2);
    }

    @DisplayName("구매 테스트 - 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void purchaseTestByInputIsNotMultipleOf1000() {
        //given
        String input = "1001";
        //when then
        assertThatThrownBy(() -> lottoService.purchase(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_ERROR.getMessage());
    }

    @DisplayName("구매 테스트 - 문자열이 주어진 경우 예외가 발생한다")
    @Test
    void purchaseTestByInputHasCharacter() {
        //given
        String input = "1000j";
        //when then
        assertThatThrownBy(() -> lottoService.purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 발급 테스트 - 성공")
    @Test
    void issueLottoTest() {
        //given
        int number = 2;
        //when then
        assertThat(lottoService.issueLotto(number))
                .size()
                .isEqualTo(2);
    }

    @DisplayName("로또 추첨 테스트 - 성공")
    @Test
    void getWinningLottoTest() {
        //given
        String input = "1,2,3,4,5,6";
        //when then
        Lotto lotto = lottoService.getWinningLotto(input);
        assertThat(lotto.getSortedNumberString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("구매 테스트 - 중복된 숫자가 입력된 경우 예외 발생")
    @Test
    void getWinningLottoTestByNumberIsDuplicated() {
        //given
        String input = "1,2,3,4,5,5";
        //when then
        assertThatThrownBy(() -> lottoService.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTERY_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    @DisplayName("구매 테스트 - 1-45 범위의 숫자가 아닌 경우 예외 발생")
    @Test
    void getWinningLottoTestByNumberIsNotAllowed() {
        //given
        String input = "0,2,3,4,5,46";
        //when then
        assertThatThrownBy(() -> lottoService.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTERY_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("구매 테스트 - 개수가 6이 아닌 경우 예외 발생")
    @Test
    void getWinningLottoTestByNumberSizeIsNot6() {
        //given
        String input = "1,2,3,4,5";
        //when then
        assertThatThrownBy(() -> lottoService.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTERY_SIZE_ERROR.getMessage());
    }

    @DisplayName("구매 테스트 - 원소 중 하나가 숫자가 아닌 경우 예외 발생")
    @Test
    void getWinningLottoTestByElementIsNotNumber() {
        //given
        String input = "1,2,3,4, 5,6";
        //when then
        assertThatThrownBy(() -> lottoService.getWinningLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 추첨 테스트 - 성공")
    @Test
    void getBonusNumberTest() {
        //given
        String input = "7";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //when then
        assertThat(lottoService.getBonusNumber(input, lotto))
                .isEqualTo(7);
    }

    @DisplayName("보너스 숫자 추첨 테스트 - 추첨된 로또 번호 숫자에 포함된 숫자가 입력된 경우 예외 발생")
    @Test
    void getBonusNumberTestByNumberIsDuplicated() {
        //given
        String input = "6";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //when then
        assertThatThrownBy(() -> lottoService.getBonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTERY_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    @DisplayName("보너스 숫자 추첨 테스트 - 1-45 범위의 숫자가 아닌 경우 예외 발생")
    @Test
    void getBonusNumberTestByNumberIsNotAllowed() {
        //given
        String input = "46";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //when then
        assertThatThrownBy(() -> lottoService.getBonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTERY_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 숫자 추첨 테스트 - 문자가 주어진 경우 예외 발생")
    @Test
    void getBonusNumberTestByInputIsNotNumber() {
        //given
        String input = "12j";
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //when then
        assertThatThrownBy(() -> lottoService.getBonusNumber(input, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}