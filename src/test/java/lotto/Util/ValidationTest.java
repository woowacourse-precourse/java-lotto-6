package lotto.Util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidationTest {

    @DisplayName("로또 구입 금액 입력 시 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"abcd:[ERROR] 숫자를 입력해주세요.", "10500:[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요."},
            delimiter = ':')
    void checkAvailableMoneyException(String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateAvailableMoney(input);
        });

        assertThat(exception.getMessage()).contains(exceptionMessage);
    }

    @DisplayName("당첨 번호 입력 시 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,a:[ERROR] 숫자를 입력해주세요.",
            "1,2,3,a,b,c:[ERROR] 숫자를 입력해주세요.",
            "1 2 3 4 5 6:[ERROR] 숫자를 입력해주세요.",
            "123456:[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.",
            "0,1,2,44,45,46:[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.",
            "1,2,3,4:[ERROR] 총 6개의 당첨 번호를 입력해주세요.",
            "1,2,3,4,5,5:[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.",
            "1,1,2,2,3,3:[ERROR] 당첨 번호 중 중복되는 번호가 있습니다."},
            delimiter = ':')
    void checkLottoNumbersException(String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateLottoNumbers(input);
        });

        assertThat(exception.getMessage()).contains(exceptionMessage);
    }

    @DisplayName("보너스 번호 입력 시 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"'1:2:3:4:5:6':0:[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.",
            "'1:2:3:4:5:6':46:[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.",
            "'1:2:3:4:5:6':a:[ERROR] 숫자를 입력해주세요.",
            "'1:2:3:4:5:6':6:[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다."},
            delimiter = ':')
    void checkBonusNumberException(List<Integer> lottoNumbers, String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateBonusNumber(lottoNumbers, input);
        });
        assertThat(exception.getMessage()).contains(exceptionMessage);
    }
}
