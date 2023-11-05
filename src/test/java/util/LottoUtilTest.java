package util;

import java.util.Arrays;
import java.util.List;

import VO.UserLottoVO;
import domain.Lotto;
import domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.LottoUtil.*;

public class LottoUtilTest {
    @DisplayName("매입 금액에 따른 로또수 반환")
    @Test
    void countByPayment() {
        final int pay = 5000;
        assertThat(countLotto(pay)).isEqualTo(5);
    }
}
