package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @DisplayName("로또 리스트들이 정상적으로 생성되고, 변경이 불가능한지 확인한다.")
    @Test
    void getLottos() {
        List<Integer> numbers = List.of(4, 5, 6, 15, 16, 17);
        List<Integer> numbers1 = List.of(12, 13, 14, 15, 16, 17);
        List<Integer> numbers2 = List.of(15, 16, 17, 18, 19, 20);

        List<List<Integer>> generateNumbers = new ArrayList<>();
        generateNumbers.add(numbers);
        generateNumbers.add(numbers1);
        generateNumbers.add(numbers2);

        LottoTickets lottoTickets = LottoTickets.generateLottos(generateNumbers);

        assertThat(lottoTickets.getLottos().size()).isEqualTo(3);

        assertThatThrownBy(() -> lottoTickets.getLottos().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void getLottos_invalid() {
        List<Integer> numbers = List.of(4, 5, 6, 15, 16, 17, 18);

        assertThatThrownBy(() -> LottoTickets.generateLottos(List.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void getLottos_duplicate() {
        List<Integer> numbers = List.of(4, 4, 6, 15, 16, 17);

        assertThatThrownBy(() -> LottoTickets.generateLottos(List.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위가 넘어선 숫자가 있으면 예외가 발생한다.")
    @Test
    void getLottosOverRange() {
        List<Integer> numbers = List.of(4, 5, 6, 15, 16, 100);

        assertThatThrownBy(() -> LottoTickets.generateLottos(List.of(numbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}