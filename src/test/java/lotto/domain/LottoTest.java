package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void lottoOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행된 로또 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void lottoNumbersSorted() {
        // given
        LottoMachine lottoMachine = new LottoMachine();

        // when
        Lotto lotto = lottoMachine.generateLotto();
        LottoDto lottoDto = lotto.toDTO();
        List<Integer> numbers = lottoDto.numbers();

        // then
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        assertThat(numbers).isEqualTo(sortedNumbers);
    }
}