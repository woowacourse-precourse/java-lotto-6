package lotto;

import lotto.model.Game;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("로또 번호에 1~45범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주어진번호와_당첨번호가_몇개_일치하는지() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> lottoNumber = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        lottoNumber.add(3);
        lottoNumber.add(4);
        lottoNumber.add(5);
        lottoNumber.add(6);
        lottoNumber.add(7);

        Game game =new Game();

        int result = game.countMatchResult(numbers, lottoNumber);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 보너스번호가_당첨번호중에_있을때() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Game game = new Game();
        game.setBonusNumber(3);

        boolean result = game.checkBonusNumber(numbers);

        assertThat(result).isTrue();
    }

    @Test
    void 보너스번호가_당첨번호중에_없을때() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Game game = new Game();
        game.setBonusNumber(6);

        boolean result = game.checkBonusNumber(numbers);

        assertThat(result).isFalse();
    }

    @Test
    void 보너스일치를_고려한_최종결과_반환() {
        List<Integer> matchResult = new ArrayList<>();
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Game game = new Game();
        game.setBonusNumber(3);
        game.checkMatchResult(matchResult, 5,numbers);

        assertThat(matchResult).contains(0,0,0,0,0,0,1);
    }

    @Test
    void 보너스불일치를_고려한_최종결과_반환() {
        List<Integer> matchResult = new ArrayList<>();
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);
        matchResult.add(0);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Game game = new Game();
        game.setBonusNumber(11);
        game.checkMatchResult(matchResult, 5,numbers);

        assertThat(matchResult).contains(0,0,0,0,0,0,0);
    }
}