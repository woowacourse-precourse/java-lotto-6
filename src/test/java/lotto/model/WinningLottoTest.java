package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.enums.ErrorMessage;
import lotto.model.enums.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private WinningLotto winningLottoTest;

    private void lottoPrizeTest(List<Integer> numbers, Prize expectedPrize) {
        Lotto userLotto = new Lotto(numbers);
        Prize prize = winningLottoTest.calculatePrize(userLotto);
        assertThat(prize).isEqualTo(expectedPrize);
    }

    private void bonusNumberExceptionTest(String userBonusNumber, ErrorMessage errorMessage) {
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            winningLotto.add(i);
        }
        assertThatThrownBy(() -> winningLottoTest.isValidBonusNumber(userBonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage.getErrorMessage());
    }

    @BeforeEach
    void setUp() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String bonusNumber = "7";
        winningLottoTest = new WinningLotto(winningLotto, bonusNumber);
    }

    @DisplayName("로또 1등 확인")
    @Test
    void 로또_1등_확인() {
        lottoPrizeTest(List.of(1, 2, 3, 4, 5, 6), Prize.FIRST);
    }

    @DisplayName("로또 2등 확인")
    @Test
    void 로또_2등_확인() {
        lottoPrizeTest(List.of(1, 2, 3, 4, 5, 7), Prize.SECOND);
    }

    @DisplayName("로또 3등 확인")
    @Test
    void 로또_3등_확인() {
        lottoPrizeTest(List.of(1, 2, 3, 4, 5, 8), Prize.THIRD);
    }

    @DisplayName("로또 4등 확인")
    @Test
    void 로또_4등_확인() {
        lottoPrizeTest(List.of(1, 2, 3, 4, 8, 9), Prize.FOURTH);
    }

    @DisplayName("로또 5등 확인")
    @Test
    void 로또_5등_확인() {
        lottoPrizeTest(List.of(1, 2, 3, 8, 9, 10), Prize.FIFTH);
    }

    @DisplayName("로또 미당첨 확인 - 2개만 일치")
    @Test
    void 로또_미당첨_확인_2개_일치() {
        lottoPrizeTest(List.of(1, 2, 8, 9, 10, 11), Prize.NONE);
    }

    @DisplayName("로또 미당첨 확인 - 1개만 일치")
    @Test
    void 로또_미당첨_확인_1개_일치() {
        lottoPrizeTest(List.of(1, 12, 8, 9, 10, 11), Prize.NONE);
    }

    @DisplayName("로또 미당첨 확인 - 0개 일치")
    @Test
    void 로또_미당첨_확인_0개_일치() {
        lottoPrizeTest(List.of(13, 12, 8, 9, 10, 11), Prize.NONE);
    }

    @Test
    @DisplayName("보너스 번호 입력 확인")
    void 보너스_번호_입력_확인() {
        List<Integer> userLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            userLotto.add(i);
        }
        String userBonusNumber = "7";
        int bonusNumber = winningLottoTest.isValidBonusNumber(userBonusNumber, userLotto);
        assertThat(bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("보너스 번호 중복 입력인 경우 예외 확인")
    void 보너스_번호_중복_입력_예외_확인() {
        bonusNumberExceptionTest("6", ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 음수인 경우 예외 확인")
    void 보너스_번호_음수_입력_예외_확인() {
        bonusNumberExceptionTest("-6", ErrorMessage.BONUS_NUMBER_NEGATIVE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 1~45 사이의 수가 아닌 경우 예외 확인")
    void 보너스_번호_범위밖_입력_예외_확인() {
        bonusNumberExceptionTest("46", ErrorMessage.BONUS_NUMBER_RANGE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("보너스 번호 숫자가 아닌 경우 예외 확인")
    void 보너스_번호_문자_입력_예외_확인() {
        bonusNumberExceptionTest("abc", ErrorMessage.BONUS_NUMBER_TYPE_ERROR_MESSAGE);
    }
}