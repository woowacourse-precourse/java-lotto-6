package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningResultTest {

    @DisplayName("로또 당첨 통계 올바르게 생성")
    @Test
    void generateLottoRankMessage() {
        // Given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 7)));
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.addBonusNumber(7);

        // When
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottos, winningLotto);
        String lottoRankMessage = lottoWinningResult.getLottoRankMessages();

        // Then
        assertThat(lottoRankMessage).contains("3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

    @DisplayName("수익률 올바르게 계산")
    @Test
    void calculateWinningRate() {
        // Given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 8)));
        lottos.add(Lotto.from(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 6));
        winningLotto.addBonusNumber(7);

        // When
        LottoWinningResult lottoWinningResult = LottoWinningResult.of(lottos, winningLotto);

        // Then
        assertThat(lottoWinningResult.calculateWinningRate())
                .isEqualTo(100075000);
    }
}