package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCheckerTest {

    @DisplayName("당첨 번호 구분자가 ,가 아닌 경우 테스트")
    @Test
    void setWinNumbers_validateSeparator() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        assertThatThrownBy(() -> lottoResultChecker.setWinNumbers("1|2|3|4|5|6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값을 정수로 변환할 수 없는 경우 테스트")
    @Test
    void setWinNumbers_notParsableNumber() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        assertThatThrownBy(() -> lottoResultChecker.setWinNumbers("1,2,a,4,b,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 값에 문제가 없는 경우 테스트")
    @Test
    void setWinNumbers_success() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        lottoResultChecker.setWinNumbers("1,2,3,4,5,6");
        assertThat(lottoResultChecker.winNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }


    @DisplayName("보너스 번호 입력 값을 정수로 변환할 수 없는 경우 테스트")
    @Test
    void setBonusNumber_notParsableNumber() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        lottoResultChecker.setWinNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResultChecker.setBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호 입력 값이 1~45의 수가 아닌 경우 테스트")
    @Test
    void setBonusNumber_validateBonusNumber_numberNotInRange() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        lottoResultChecker.setWinNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResultChecker.setBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 값이 당첨 번호와 중복되는 경우 테스트")
    @Test
    void setBonusNumber_validateBonusNumber_duplicateNumber() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        lottoResultChecker.setWinNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoResultChecker.setBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 값에 문제가 없는 경우 테스트")
    @Test
    void setBonusNumber_success() {
        LottoResultChecker lottoResultChecker = new LottoResultChecker(null);
        lottoResultChecker.setWinNumbers("1,2,3,4,5,6");
        lottoResultChecker.setBonusNumber("7");
        assertThat(lottoResultChecker.winNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoResultChecker.bonusNumber).isEqualTo(7);
    }

}