package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SelectedLottoTest {
    private Money money;
    private SelectedLotto lotto;

    @ParameterizedTest
    @CsvSource(value = {"'';1;[ERROR] 6자리 수를 입력하시오.", "' ';1;[ERROR] 6자리 수를 입력하시오.",
            "1,2,3,4,5,;6;[ERROR] 정수를 입력하시오.",
            "1,2,삼,4,5,6;7;[ERROR] 정수를 입력하시오.", "1,2,3,4,555,6;5;[ERROR] 1에서 45까지의 숫자를 입력하시오.",
            "1,2,2,3,4,5;6;[ERROR] 서로 중복되는 숫자는 불가합니다.",
            "1,2,3,4,5,6;6;[ERROR] 서로 중복되는 숫자는 불가합니다."}, delimiter = ';', ignoreLeadingAndTrailingWhitespace = false)
    void 금액입력_검증(String nums, String bonus, String expected) {

        assertThatThrownBy(() -> new SelectedLotto(nums, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);

    }


}