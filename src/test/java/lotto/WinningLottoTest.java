package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.lottoGame.LottoInputGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {
    LottoInputGenerator lottoInputGenerator;

    @BeforeEach
    void setUp() {
        lottoInputGenerator = new LottoInputGenerator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1", "1,2,3,4,5,6:2", "1,2,3,4,5,6:3", "1,2,3,4,5,6:4"}, delimiter = ':')
    @DisplayName("입력 로또 번호에 중복값이 입력시 에러가 발생한다.")
    void 당첨번호입력_로또와_보너스가_중복(String numbers, String bonus) {
        Lotto lotto = lottoInputGenerator.inputNumbersToLotto(numbers);
        int bonusNumber = lottoInputGenerator.inputBonusToValidatedValue(bonus);

        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 형식의 값 입력시 정상 생성")
    void 당첨번호입력() {
        String numbers = "1,2,3,4,5,6";
        String bonusNumber = "7";

        Lotto lotto = lottoInputGenerator.inputNumbersToLotto(numbers);
        int bonusNumberValue = lottoInputGenerator.inputBonusToValidatedValue(bonusNumber);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumberValue);

        assertThat(winningLotto.getLotto()).isEqualTo(lotto);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumberValue);
    }
}