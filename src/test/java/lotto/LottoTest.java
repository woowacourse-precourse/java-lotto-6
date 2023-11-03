package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("중복 없는 6자리 수의 로또 번호를 생성한다.")
    @Test
    void distinctLottoNumber() {
        // when
        List<Integer> numbers = Lotto.pickUniqueNumbersInRange();
        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        // then
        assertThat(numbers.size())
                .isEqualTo(distinctNumbers.size())
                .isEqualTo(6);
    }

    @DisplayName("생성된 로또 번호는 오름차순으로 정렬된다.")
    @Test
    void orderByAsc() {
        // when
        List<Integer> randomNumbers = Lotto.pickUniqueNumbersInRange();
        Lotto lotto = Lotto.createLotto(randomNumbers);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThat(numbers.get(0)).isLessThan(numbers.get(1));
        assertThat(numbers.get(1)).isLessThan(numbers.get(2));
        assertThat(numbers.get(2)).isLessThan(numbers.get(3));
        assertThat(numbers.get(3)).isLessThan(numbers.get(4));
        assertThat(numbers.get(4)).isLessThan(numbers.get(5));
    }

    @DisplayName("생성된 로또 번호는 1이상 45이하의 숫자로 구성된다.")
    @Test
    void lottoNumberRange() {
        // when
        List<Integer> numbers = Lotto.pickUniqueNumbersInRange();

        // then 1
        assertThat(numbers.get(0)).isGreaterThan(0);
        assertThat(numbers.get(1)).isGreaterThan(0);
        assertThat(numbers.get(2)).isGreaterThan(0);
        assertThat(numbers.get(3)).isGreaterThan(0);
        assertThat(numbers.get(4)).isGreaterThan(0);
        assertThat(numbers.get(5)).isGreaterThan(0);

        // then 2
        assertThat(numbers.get(0)).isLessThan(46);
        assertThat(numbers.get(1)).isLessThan(46);
        assertThat(numbers.get(2)).isLessThan(46);
        assertThat(numbers.get(3)).isLessThan(46);
        assertThat(numbers.get(4)).isLessThan(46);
        assertThat(numbers.get(5)).isLessThan(46);
    }

    @DisplayName("당첨 번호와 일치하는 숫자의 갯수를 반환한다.")
    @Test
    void calculateCorrectAmount() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = Lotto.createLotto(numbers);
        WinningLotto winningLotto = WinningLotto.of(winningNumbers);
        winningLotto.createBonusNumber(6);

        // when
        int correctAmount = lotto.calculateCorrectAmount(winningLotto);

        // then
        assertThat(correctAmount).isEqualTo(5);
    }

    @DisplayName("보너스 번호 일치 여부를 반환한다.")
    @Test
    void calculateBonusCorrect() {
        // given 1
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.createLotto(numbers);

        // given 2
        List<Integer> winningNumbers1 = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers2 = List.of(1, 2, 3, 4, 5, 7);
        WinningLotto winningLotto1 = WinningLotto.of(winningNumbers1);
        WinningLotto winningLotto2 = WinningLotto.of(winningNumbers2);
        winningLotto1.createBonusNumber(6);
        winningLotto2.createBonusNumber(45);

        // when
        boolean bonusCorrect1 = lotto.calculateBonusCorrect(winningLotto1);
        boolean bonusCorrect2 = lotto.calculateBonusCorrect(winningLotto2);

        // then
        assertThat(bonusCorrect1).isTrue();
        assertThat(bonusCorrect2).isFalse();
    }
}