package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("로또번호 6자리가 정상적으로 생성되는지 확인한다.")
    void generateSixLengthLottoNumbers(){
        // given
        List<Integer> numbers;
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        numbers = numberGenerator.createLottoNumbers();

        // then
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("구매금액에 맞춰 로또 발행 갯수를 출력한다.")
    @ValueSource(strings = {"8000", "17000"})
    void printLottoCountByAmount(final String money) {
        // given
        Player player = new Player(money);

        // when & then
        Assertions.assertThat(player.getTicketCount()).isEqualTo(Integer.parseInt(money) / 1000);
    }

    @Test
    @DisplayName("로또 번호 범위 테스트")
    void lottoNumberRangeTest() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when
        List<Integer> lottoNumbers = numberGenerator.createLottoNumbers();

        // then
        assertThat(lottoNumbers.stream().allMatch(v -> v  >= 1 && v <= 45)).isTrue();
    }
}