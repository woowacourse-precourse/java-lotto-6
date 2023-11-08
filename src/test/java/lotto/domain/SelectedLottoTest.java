package lotto.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SelectedLottoTest {
    private Money money;
    private SelectedLotto lotto;

    @DisplayName("당첨 로또 번호, 보너스 에러 확인")
    @ParameterizedTest
    @CsvSource(value = {"'';1;[ERROR] 6자리 수를 입력하시오.", "' ';1;[ERROR] 6자리 수를 입력하시오.",
            "1,2,3,4,5,;6;[ERROR] 정수를 입력하시오.",
            "1,2,삼,4,5,6;7;[ERROR] 정수를 입력하시오.", "1,2,3,4,555,6;5;[ERROR] 1에서 45까지의 숫자를 입력하시오.",
            "1,2,2,3,4,5;6;[ERROR] 서로 중복되는 숫자는 불가합니다.",
            "1,2,3,4,5,6;6;[ERROR] 서로 중복되는 숫자는 불가합니다."}, delimiter = ';', ignoreLeadingAndTrailingWhitespace = false)
    void checkSelectedLotto(String nums, String bonus, String expected) {
        assertThatThrownBy(
                () -> new SelectedLotto(new SelectedNumbers(nums), new SelectedBonus(bonus, new SelectedNumbers(nums))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);

    }


}