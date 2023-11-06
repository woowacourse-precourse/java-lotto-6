package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    @DisplayName("보너스 숫자가 로또에 포함될 경우, 에러가 발생한다.")
    public void testBonusNumberInLotto() throws Exception {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        //when&then
        assertThatThrownBy(() -> new Result(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("다른 로또와 겹치는 숫자의 개수를 반환한다.")
    public void testMatchWinningLotto() throws Exception {
        //given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        //when
        Result result = new Result(lotto1, bonusNumber);
        int matched = result.matchWinningLotto(lotto2);

        //then
        assertEquals(matched, 6);
    }

    @Test
    @DisplayName("로또에 보너스 숫자가 포함되지 않을 경우, false를 반환한다.")
    public void testMatchBonusBall() throws Exception {
        //given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        //when
        Result result = new Result(lotto1, bonusNumber);
        boolean bonusResult = result.matchBonusBall(lotto2);

        //then
        assertFalse(bonusResult);
    }
}