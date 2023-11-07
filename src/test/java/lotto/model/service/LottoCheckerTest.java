package lotto.model.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.LottoResult;
import lotto.model.dto.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoCheckerTest {

    @Test
    @DisplayName("로또 1등 검증")
    void findWinningLottosFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또 2등 검증")
    void findWinningLottosSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 7), 6);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("로또 3등 검증")
    void findWinningLottosThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 7), 10);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("로또 4등 검증")
    void findWinningLottosFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 8, 7), 10);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("로또 5등 검증")
    void findWinningLottosFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 9, 8, 7), 10);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.FIFTH_PLACE);
    }


    @Test
    @DisplayName("로또 꼴등 검증")
    void findWinningLottosNoLuck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 11, 9, 8, 7), 10);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.NO_LUCK);
    }

    @Test
    @DisplayName("로또 복수 검증")
    void findWinningLottosMultiple() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 10);

        LottoChecker lottoChecker = new LottoChecker();
        LottoResult winningLottos = lottoChecker.findWinningLottos(List.of(lotto, lotto2), winningNumber);

        Assertions.assertThat(winningLottos.getLottoRanks())
                .containsExactly(LottoRank.FIRST_PLACE, LottoRank.NO_LUCK);
    }


}