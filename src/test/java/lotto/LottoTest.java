package lotto;

import lotto.models.Lotto;
import lotto.models.LottoGrade;
import lotto.models.WinNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotSixSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNotInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 등수 테스트 1등")
    @Test
    void lottoGrade1() {
        // 6개 일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.FIRST, lotto.calcRank(winNumber));
    }

    @DisplayName("로또 등수 테스트 2등")
    @Test
    void lottoGrade2() {
        // 5개 일치 + 보너스 번호 일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.SECOND, lotto.calcRank(winNumber));
    }

    @DisplayName("로또 등수 테스트 3등")
    @Test
    void lottoGrade3() {
        // 5개 일치 + 보너스 번호 불일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.THIRD, lotto.calcRank(winNumber));
    }

    @DisplayName("로또 등수 테스트 4등")
    @Test
    void lottoGrade4() {
        // 4개 일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.FOURTH, lotto.calcRank(winNumber));
    }

    @DisplayName("로또 등수 테스트 5등")
    @Test
    void lottoGrade5() {
        // 3개 일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 9, 10, 11));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.FIFTH, lotto.calcRank(winNumber));
    }

    @DisplayName("로또 등수 테스트 꽝")
    @Test
    void lottoGradeNone() {
        // 2개 이하 일치
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 9, 10, 11, 12));
        Lotto winLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinNumber winNumber = new WinNumber(winLotto, bonusNumber);

        // when & then
        assertEquals(LottoGrade.NONE, lotto.calcRank(winNumber));
    }

}