package lotto.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottosTest {
    private Lottos userLottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 3, 5, 21, 23, 25));
        Lotto lotto3 = new Lotto(List.of(1, 41, 42, 43, 44, 45));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        userLottos = new Lottos(lottos);
    }

    @DisplayName("로또 List<LottoDto>로 변환하는 테스트 : Lottos 객체를 List<LottoDto>로 변환한다.")
    @Test
    void toDtos() {
        List<LottoDto> lottosDtos = userLottos.toDtos();

        assertThat(lottosDtos).usingRecursiveFieldByFieldElementComparator()
                .containsExactly(
                        new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoDto(List.of(1, 3, 5, 21, 23, 25)),
                        new LottoDto(List.of(1, 41, 42, 43, 44, 45))
                );
    }

    @DisplayName("로또 당첨 결과 구하는 테스트(5개 + 보너스 x) : 당첨 결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResultFiveMatch() {
        Lotto winningNumber = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        BonusNumber bonusNumber = new BonusNumber(30);

        List<LottoResult> results =
                userLottos.getLottoWinningResult(winningNumber, bonusNumber);

        assertAll(
            () -> assertThat(results.size()).isEqualTo(1),
            () -> assertThat(results).containsExactly(LottoResult.FIVE_MATCH)
        );
    }

    @DisplayName("로또 당첨 결과 구하는 테스트(5개 + 보너스 o) : 당첨 결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResultFiveMatchWithBonus() {
        Lotto winningNumber = new Lotto(List.of(1, 3, 5, 21, 23, 45));
        BonusNumber bonusNumber = new BonusNumber(25);

        List<LottoResult> results =
                userLottos.getLottoWinningResult(winningNumber, bonusNumber);

        assertAll(
            () -> assertThat(results.size()).isEqualTo(2),
            () -> assertThat(results).containsExactly(
                    LottoResult.THREE_MATCH,
                    LottoResult.FIVE_MATCH_WITH_BONUS
            )
        );
    }

    @DisplayName("로또 당첨 결과 구하는 테스트 : 당첨결과를 담은 로또 결과를 반환한다.")
    @Test
    void getLottoWinningResult() {
        Lotto winningNumber = new Lotto(List.of(1, 3, 5, 41, 42, 43));
        BonusNumber bonusNumber = new BonusNumber(10);

        List<LottoResult> results =
                userLottos.getLottoWinningResult(winningNumber, bonusNumber);

        assertAll(
            () -> assertThat(results.size()).isEqualTo(3),
            () -> assertThat(results).containsExactly(
                    LottoResult.THREE_MATCH,
                    LottoResult.THREE_MATCH,
                    LottoResult.FOUR_MATCH)
        );
    }

    @DisplayName("생성 테스트 : List<Lotto>를 갖는 Lottos 객체를 생성한다.")
    @Test
    void create() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        assertThatCode(() -> new Lottos(lottos))
                .doesNotThrowAnyException();
    }
}