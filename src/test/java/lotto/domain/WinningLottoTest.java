package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @Test
    @DisplayName("매칭되는 숫자를 카운팅 하는 테스트")
    void matchCountTest() {
        //given
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(answerLotto, bonusNumber);

        List<Integer> myLottoNumbers = List.of(1, 2, 3, 8, 9, 10);

        //when
        int matchCount = winningLotto.calculateMathCount(myLottoNumbers);

        //then
        Assertions.assertThat(matchCount).isEqualTo(3);
    }
}
