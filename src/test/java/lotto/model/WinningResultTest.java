package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @DisplayName("로또 숫자 일치 확인 테스트 - 6개 일치")
    @Test
    void getWinningResult() {
        Lotto lotto = Lotto.create("1,2,3,4,5,6");
        List<Number> numbers = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(5),
                Number.of(6)
        );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        int matchingCount = lotto.countMatchingNumbers(lottoTicket);

        assertThat(matchingCount).isEqualTo(6);
    }

    @DisplayName("로또 숫자 일치 확인 테스트 - 5개 일치")
    @Test
    void getCountingResult_5() {
        Lotto lotto = Lotto.create("1,2,3,4,5,6");
        List<Number> numbers = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(5),
                Number.of(7)
        );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        int matchingCount = lotto.countMatchingNumbers(lottoTicket);

        assertThat(matchingCount).isEqualTo(5);
    }

    @DisplayName("로또 숫자 일치 확인 테스트 - 4개 일치")
    @Test
    void getCountingResult_4() {
        Lotto lotto = Lotto.create("1,2,3,4,5,6");
        List<Number> numbers = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(4),
                Number.of(15),
                Number.of(7)
        );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        int matchingCount = lotto.countMatchingNumbers(lottoTicket);

        assertThat(matchingCount).isEqualTo(4);
    }

    @DisplayName("로또 숫자 일치 확인 테스트 - 4개 일치")
    @Test
    void getCountingResult_3() {
        Lotto lotto = Lotto.create("1,2,3,4,5,6");
        List<Number> numbers = Arrays.asList(
                Number.of(1),
                Number.of(2),
                Number.of(3),
                Number.of(14),
                Number.of(15),
                Number.of(7)
        );
        LottoTicket lottoTicket = new LottoTicket(numbers);

        int matchingCount = lotto.countMatchingNumbers(lottoTicket);

        assertThat(matchingCount).isEqualTo(3);
    }


}