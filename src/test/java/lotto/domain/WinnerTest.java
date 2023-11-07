package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class WinnerTest {

    Winner winner;

    @BeforeEach
    public void beforeEach() {
        winner = new Winner("1,6,8,25,33,45");
        winner.lottoWinningBonusNumber("5");
    }

    @DisplayName("5개의 로또 당첨번호와 보너스 번호가 같을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "11", "16", "17"})
    public void 로또당첨번호_5개와_보너스번호_같을경우(String bonus) throws Exception {
        //given
        winner.lottoWinningBonusNumber(bonus);
        Lotto userLottoNumbers = new Lotto("1,2,3,11,16,17");

        //when
        Method method = winner.getClass().getDeclaredMethod("sameFiveNumbersAndBonus", Lotto.class, int.class);
        method.setAccessible(true);
        boolean check = (Boolean) method.invoke(winner, userLottoNumbers, 5);

        //then 결과값 비교
        Assertions.assertThat(check).isTrue();
    }
}