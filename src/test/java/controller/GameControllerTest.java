package controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.model.LottoDatas;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameControllerTest {

    private LottoService lottoService;
    private LottoDatas lottoDatas;

    List<Integer> exWinningNumbers;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void init() {
        lottoDatas = new LottoDatas();
        lottoService = new LottoService(lottoDatas);
        exWinningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 수 입력시 오류 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "2100", "3100"})
    void 예외_테스트_1000으로_떨어지지_않는_수_입력(String purchase) {
        assertThatThrownBy(() -> lottoService.convertPurchaseToCount(purchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_UNDIVIDED_NUMBER_OF_THOUSAND.getMessage());
    }

    @DisplayName("숫작가 아닌 수 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1200J", "asdf", "포비", "1234!"})
    void 숫자가_아닌_수_입력(String inputPurchase) {
        assertThatThrownBy(() -> lottoService.convertPurchaseToCount(inputPurchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
    }

    @DisplayName("구입 금액 넣을시 로또 구입개수로 변환 되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"2000", "5000", "10000"})
    void 변환_테스트(String inputPurchase) {
        lottoService.convertPurchaseToCount(inputPurchase);
        int number = Integer.parseInt(inputPurchase);
        assertEquals(lottoDatas.getLottoCount(), number / 1000);

    }

    @DisplayName("당첨번호 예외처리 "
            + "1.공백이 입력됐는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,,3,4,5,6", "1,23,3,,4,5"})
    void 당첨번호_예외테스트1(String winningNumber) {
        assertThatThrownBy(() -> lottoService.convertToIntegerList(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INPUT_BLANK.getMessage());
    }

    @DisplayName("당첨번호 예외처리 "
            + "2.숫자인 수가 입력되었는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2a,3,4,5,6", "1,ss,3,6,4,5", "1,2,한글,45,6,7"})
    void 당첨번호_예외테스트2(String winningNumber) {
        assertThatThrownBy(() -> lottoService.convertToIntegerList(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
    }

    @DisplayName("당첨번호 예외처리 "
            + "3.숫자 6개를 입력하였는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,3,6,4,5", "1,2,45,6,7,8,9"})
    void 당첨번호_예외테스트3(String winningNumber) {
        assertThatThrownBy(() -> lottoService.convertToIntegerList(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_SIX_LENGTH.getMessage());
    }

    @DisplayName("당첨번호 예외처리 "
            + "4.중복된 숫자를 입력했는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,3,6,4,5,6", "1,2,45,6,45,6"})
    void 당첨번호_예외테스트4(String winningNumber) {
        assertThatThrownBy(() -> lottoService.convertToIntegerList(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("당첨번호 예외처리 "
            + "5.1부터 45사이의 숫자를 입력했는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "0,3,6,4,5,7", "0,2,45,6,46,8"})
    void 당첨번호_예외테스트5(String winningNumber) {
        assertThatThrownBy(() -> lottoService.convertToIntegerList(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_OUT_OF_LANGE.getMessage());
    }

    @DisplayName("보너스번호 예외처리 "
            + "1.숫자인 수가 입력됐는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"a", "#", " ", "한글"})
    void 보너스번호_예외처리1(String bonusNumber) {
        assertThatThrownBy(() -> lottoService.checkBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_NOT_INTEGER_NUMBER.getMessage());
    }

    @DisplayName("보너스번호 예외처리 "
            + "2.중복된 숫자가 입력됐는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스번호_예외처리2(String bonusNumber) {
        lottoDatas.inputWinningNumber(exWinningNumbers);
        assertThatThrownBy(() -> lottoService.checkBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("보너스번호 예외처리 "
            + "1부터 45이외의 숫자가 입력됐는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "47"})
    void 보너스번호_예외처리3(String bonusNumber) {
        lottoDatas.inputWinningNumber(exWinningNumbers);
        assertThatThrownBy(() -> lottoService.checkBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_OUT_OF_LANGE.getMessage());
    }

}
