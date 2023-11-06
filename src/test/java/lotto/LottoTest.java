package lotto;

import java.util.ArrayList;
import java.util.stream.Collectors;
import lotto.Domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 1~45 범위에 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByCorrectRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 67)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 문자를 입력하면 예외가 발생한다.")
    @Test
    void createLottoByCorrentNumber() {
        assertThatThrownBy(() -> new Lotto(
                List.of(1, 2, 3, 4, "e").stream()
                        .map(o -> {
                            if (o instanceof String) {
                                return Integer.parseInt((String) o);
                            }
                            return (Integer) o;
                        })
                        .collect(Collectors.toList())
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 공백을 입력하면 예외가 발생한다.")
    @Test
    void createLottoCorrentBlank() {
        assertThatThrownBy(() -> new Lotto(
                List.of(1, 2, 3, 4, 5, " ")
                        .stream()
                        .map(o -> {
                            if (o instanceof String) {
                                return Integer.parseInt((String) o);
                            }
                            return (Integer) o;
                        })
                        .collect(Collectors.toList())
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨자가 로또 번호를 입력한다.")
    @Test
    void LottoNumbersCorrentTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> getNumbers = lotto.getLottoNumbers();

        assertThat(lotto.getLottoNumbers()).isEqualTo(getNumbers);
    }

    @DisplayName("보너스 번호에 이미 로또 번호에 입력한 숫자가 있으면 중복 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;

        assertThatThrownBy(() -> lotto.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위에 벗어나면 예외가 발생한다.")
    @Test
    void createBonusByCorrectRange() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 67;

        assertThatThrownBy(() -> lotto.setBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 공백을 입력하면 예외가 발생한다.")
    @Test
    void createBonusByCorrentBlank() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(lottoNumbers);
            lotto.setBonusNumber(Integer.parseInt(" "));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨자가 보너스 번호를 입력한다.")
    @Test
    void BonusNumberCorrentTest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 7;

        lotto.setBonusNumber(bonusNumber);

        assertThat(lotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}