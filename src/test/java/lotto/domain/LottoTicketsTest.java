package lotto.domain;

import lotto.enums.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {
    LottoTickets lottoTickets;

    @DisplayName("생성 테스트")
    @BeforeEach
    @Test
    void createLottoTickets() {
        lottoTickets = LottoTickets.createdByNumber(5);
    }

    @DisplayName("")
    @Test
    void getLottoTickets() {
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(5);
    }

    @DisplayName("로또 티켓 문자열로 가져오기")
    @Test
    void NumbersOfLottoTickets() {
        assertRandomUniqueNumbersInRangeTest(() ->
                        assertThat(LottoTickets.createdByNumber(5).getLottoTickets().stream().map(Lotto::toString))
                                .contains("[1, 2, 3, 4, 5, 6]",
                                        "[4, 5, 6, 7, 8, 9]",
                                        "[3, 10, 23, 42, 43, 45]",
                                        "[10, 20, 30, 35, 40, 45]",
                                        "[2, 3, 9, 12, 30, 34]"
                                )
                ,
                List.of(1, 2, 3, 4, 5, 6),
                List.of(4, 5, 6, 7, 8, 9),
                List.of(3, 10, 23, 42, 43, 45),
                List.of(10, 20, 30, 35, 40, 45),
                List.of(2, 3, 9, 12, 30, 34)
        );
    }

    @DisplayName("양수가 아닐 경우 예외가 발생해야함")
    @Test
    void createLottoTicketsByZero() {
        assertThatThrownBy(() -> LottoTickets.createdByNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        assertThatThrownBy(() -> LottoTickets.createdByNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
    }

    @DisplayName("만약 WinninResult가 들어오지 않는다면 예외를 발생시킨다.")
    @Test
    void calculateWinningResultByNull() {
        assertThatThrownBy(() -> lottoTickets.calculateWinningResult(null)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void forLoopToStream() {
        List<Integer> lottoTickets = new ArrayList<>();
        List<Integer> lottoTickets2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTickets.add(i);
        }
        IntStream.range(0, 10).forEach(lottoTickets2::add);

        assertThat(lottoTickets.equals(lottoTickets2)).isTrue();
    }

    @Test
    void forLoopToStreamRangeMapToObj() {
        final List<Lotto> lottoTickets;

        final List<Lotto> lottoTickets1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottoTickets1.add(Lotto.valueOf(List.of(1, 2, 3, 4, 5, 6)));
        }
        lottoTickets = lottoTickets1;
        //
        final List<Lotto> lottoTickets2 = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> lottoTickets2.add(Lotto.valueOf(List.of(1, 2, 3, 4, 5, 6))));
        //
        final List<Lotto> lottoTickets3;

        lottoTickets3 = IntStream.range(0, 10)
                .mapToObj(i -> Lotto.valueOf(List.of(1, 2, 3, 4, 5, 6)))
                .collect(Collectors.toList());

        assertThat(lottoTickets2.equals(lottoTickets3)).isFalse();
    }
}