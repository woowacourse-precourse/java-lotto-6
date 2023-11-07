package lotto.core;

import lotto.Application;
import lotto.utils.Validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class LotteryTest {
    @DisplayName("숫자열에 보너스 숫자 존재 여부")
    @Test
    void 보너스_숫자_포함_테스트() {
        Lottery lottery = new Lottery();

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThat(lottery.hasBonusNumber(lotto, bonusNumber)).isEqualTo(true);
    }
}
