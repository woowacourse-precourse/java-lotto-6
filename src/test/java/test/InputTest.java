package test;

import lotto.config.ErrorMessage;
import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTest {
    @Test
    void 금액_입력_테스트_영어() {
        assertThatThrownBy(() -> new Money("1x"))
                .hasMessage(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
    }

    @Test
    void 금액_입력_테스트_한글() {
        assertThatThrownBy(() -> new Money("ㄱ1"))
                .hasMessage(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
    }

    @Test
    void 금액_입력_테스트_특수문자() {
        assertThatThrownBy(() -> new Money("1%"))
                .hasMessage(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
    }

    @Test
    void 금액_입력_테스트_최소금액() {
        assertThatThrownBy(() -> new Money("999"))
                .hasMessage(ErrorMessage.MINIMUM_MONEY.getMessage());
    }

    @Test
    void 금액_입력_테스트_나머지() {
        assertThatThrownBy(() -> new Money("1001"))
                .hasMessage(ErrorMessage.EXIST_REMAINDER.getMessage());
    }

    @Test
    void 당첨번호_6개_미만() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5"))
                .hasMessage(ErrorMessage.INVALID_FORMAT.getMessage());
    }

    @Test
    void 당첨번호_6개_초과() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .hasMessage(ErrorMessage.INVALID_FORMAT.getMessage());
    }

    @Test
    void 당첨번호_최소값() {
        assertThatThrownBy(() -> new WinningNumbers("0,2,3,4,5,6"))
                .hasMessage(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_최대값() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .hasMessage(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
    }

    @Test
    void 당첨번호_중복() {
        assertThatThrownBy(() -> new WinningNumbers("1,1,3,3,6,6"))
                .hasMessage(ErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    void 보너스번호_중복() {
        assertThatThrownBy(() -> new BonusNumber(List.of(1,2,3,4,5,6), "1"))
                .hasMessage(ErrorMessage.EXIST_NUMBER.getMessage());
    }
}
