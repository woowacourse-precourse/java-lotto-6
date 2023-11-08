package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    static Stream<List<Lotto>> provideValidLottoTickets() {
        return Stream.of(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(10, 12, 15, 24, 34, 40))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidLottoTickets")
    @DisplayName("여러 개의 로또를 가진 로또 일급컬렉션을 생성한다.")
    void createLottos(List<Lotto> lottoTickets) {
        //given
        Lottos lottos = Lottos.from(lottoTickets);
        //when
        //then
        assertThat(lottos).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("provideValidLottoTickets")
    @DisplayName("로또를 2장 구매하였다면 길이는 2이다.")
    void validateLottosLength(List<Lotto> lottoTickets) {
        //given
        Lottos lottos = Lottos.from(lottoTickets);
        //when
        //then
        assertThat(lottos.getSize()).isEqualTo(2);
    }
}