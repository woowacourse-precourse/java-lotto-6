package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    @DisplayName("로또 Dto로 변환하는 테스트 : List<Integer>를 필드로 가지는 Lotto Dto로 변환한다.")
    @Test
    void toDto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoDto lottoDto = lotto.toDto();

        assertThat(lottoDto.getNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호 가지고 있는지 테스트 : 보너스 번호를 가지고있지 않다면 false를 반환한다.")
    @Test
    void hasNotBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.hasBonusNumber(new BonusNumber(7));

        assertThat(result).isFalse();
    }

    @DisplayName("보너스 번호 가지고 있는지 테스트 : 보너스 번호를 가지고 있다면 true를 반환한다.")
    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.hasBonusNumber(new BonusNumber(5));

        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호 비교 테스트 : 로또 번호를 비교하여 일치하는 개수를 반환한다.")
    @Test
    void countMatches() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 3, 5, 10, 11, 12));

        int count = winningNumbers.countMatches(lotto);

        assertThat(count).isEqualTo(3);
    }

    @DisplayName("생성 테스트 : 로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("생성 테스트 : 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("생성 테스트 : 6개의 숫자를 가지는 로또를 생성한다.")
    @Test
    void createLotto() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }
}