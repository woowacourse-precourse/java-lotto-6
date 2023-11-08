package lotto;

import lotto.controller.Lotto;
import lotto.utils.LottoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoUtilTest {
    LottoUtil lottoUtil = new LottoUtil();
    @DisplayName("문자열이 숫자 및 콤마만 존재하는지 확인하고 예외 처리한다.")
    @Test
    void checkNumberAndComma() {
        String numberAndComma = "1,2,3,4-,5,6";

        assertThat(lottoUtil.validateNumberCheck(numberAndComma))
                .isFalse();
    }

    @DisplayName("숫자 두개가 같은 숫자인지 비교한 후 반환 한다.")
    @Test
    void checkSameNumber() {
        assertThat(lottoUtil.isSameBonusNumber(1, 2))
                .isFalse();
    }

    @DisplayName("숫자와 리스트를 비교하여같은 숫자가 존재하는지 비교한 후 반환 한다.")
    @Test
    void checkListToSameNumber() {
        assertThat(lottoUtil.isSameNumber(List.of(1,2,3,4,5,6), 2))
                .isTrue();
    }

}