package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningResult 클래스")
class WinningResultTest {
    private static WinningResult getWinningResult() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 2, 8, 9, 10, 11)),
                new Lotto(List.of(1, 8, 9, 10, 11, 12))
        );
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
        return new WinningResult(lottos, winningLotto);
    }

    @DisplayName("WinningResult 객체 생성 테스트")
    @Test
    void testCreateWinningResult() {
        // given
        WinningResult winningResult = getWinningResult();
        Map<LottoRank, Integer> resultByLottoRank = winningResult.getResultByLottoRank();

        // when & then
        assertThat(resultByLottoRank)
                .containsEntry(LottoRank.FIRST, 1)
                .containsEntry(LottoRank.SECOND, 1)
                .containsEntry(LottoRank.THIRD, 0)
                .containsEntry(LottoRank.FOURTH, 2)
                .containsEntry(LottoRank.FIFTH, 1)
                .containsEntry(LottoRank.NONE, 3);
    }

    @DisplayName("getPurchasedLottoCount() 테스트")
    @Test
    void testGetPurchasedLottoCount() {
        // given
        WinningResult winningResult = getWinningResult();

        // when
        int purchasedLottoCount = winningResult.getPurchasedLottoCount();

        // then
        assertThat(purchasedLottoCount).isEqualTo(8);
    }

}