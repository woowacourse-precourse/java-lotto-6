package lotto.error;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.error.Error.ErrorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorTest {
    @DisplayName("enum에 맞게 에러 메시지가 나오는지 테스트")
    @Test
    void invalidMoneyTypeErrorMessageTest(){
        String result = ErrorType.INVALID_MONEY_TYPE.getMessage();
        assertThat(result).isEqualTo("[ERROR] 유효하지 않은 값입니다.");
    }

    @Test
    void invalidLottoRangeErrorMessageTest(){
        String result = ErrorType.INVALID_LOTTO_SIZE.getMessage();
        assertThat(result).isEqualTo("[ERROR] 로또 숫자는 6개를 입력해야 합니다.");
    }

    @Test
    void duplicationErrorMessageTest(){
        String result = ErrorType.DUPLICATION.getMessage();
        assertThat(result).isEqualTo("[ERROR] 중복된 숫자가 있으면 안됩니다.");
    }

    @Test
    void invalidLottoInputErrorMessageTest(){
        String result = ErrorType.INVALID_LOTTO_INPUT.getMessage();
        assertThat(result).isEqualTo("[ERROR] 유효하지 않은 값입니다.");
    }

}