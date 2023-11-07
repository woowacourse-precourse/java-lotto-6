package lotto;

import java.util.Arrays;
import lotto.Constants.NumberOfLottoCorrect;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 로또번호_정렬되서_전달하는_기능() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        // when
        String value = lotto.showNumbers();
        // then
        assertThat(value).contains("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 당첨번호_3개_일치() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,7,8,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("10");
        // when
        NumberOfLottoCorrect numberOfLottoCorrect = lotto.compareWinningNumber(winningNumber,
            bonusNumber);
        // then
        assertThat(numberOfLottoCorrect).isEqualTo(NumberOfLottoCorrect.THREE_MATCHES);
    }
    @Test
    void 당첨번호_4개_일치() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,8,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("10");
        // when
        NumberOfLottoCorrect numberOfLottoCorrect = lotto.compareWinningNumber(winningNumber,
            bonusNumber);
        // then
        assertThat(numberOfLottoCorrect).isEqualTo(NumberOfLottoCorrect.FOUR_MATCHES);
    }
    @Test
    void 당첨번호_5개_일치() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("10");
        // when
        NumberOfLottoCorrect numberOfLottoCorrect = lotto.compareWinningNumber(winningNumber,
            bonusNumber);
        // then
        assertThat(numberOfLottoCorrect).isEqualTo(NumberOfLottoCorrect.FIVE_MATCHES);
    }
    @Test
    void 당첨번호_5개_보너스_일치() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,9");
        LottoNumber bonusNumber = LottoNumber.newInstance("6");
        // when
        NumberOfLottoCorrect numberOfLottoCorrect = lotto.compareWinningNumber(winningNumber,
            bonusNumber);
        // then
        assertThat(numberOfLottoCorrect).isEqualTo(NumberOfLottoCorrect.FIVE_BONUS_MATCHES);
    }
    @Test
    void 당첨번호_6개_일치() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(6,5,4,3,2,1));
        WinningNumber winningNumber = WinningNumber.newInstance("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.newInstance("10");
        // when
        NumberOfLottoCorrect numberOfLottoCorrect = lotto.compareWinningNumber(winningNumber,
            bonusNumber);
        // then
        assertThat(numberOfLottoCorrect).isEqualTo(NumberOfLottoCorrect.SIX_MATCHES);
    }
}