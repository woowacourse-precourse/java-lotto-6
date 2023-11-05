package lotto.domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    void sortedLottoNumbers() {
        List<java.lang.Integer> sortedLottoNumber = new Lotto(List.of(6, 5, 4, 3, 2, 1)).sortLottoNumber();
        Assertions.assertEquals(sortedLottoNumber, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨번호와 내 로또번호를 비교하여 일치하는 숫자의 갯수 카운트")
    void testLottoNumberMatching() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winLotto = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        Assertions.assertEquals(6, winLotto.getMatchCount(myLotto));
    }

    @Test
    @DisplayName("로또번호에 보너스번호가 있을경우 테스트는 성공한다.")
    void test() {
        Lotto myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumber winLotto = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        Assertions.assertTrue(winLotto.containsBonusNumber(myLotto));

    }


}