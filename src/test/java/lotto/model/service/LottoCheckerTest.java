package lotto.model.service;

import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoRank;
import lotto.model.dto.BonusNumber;
import lotto.model.dto.LottoResult;
import lotto.model.dto.LottoWallet;
import lotto.model.dto.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckerTest {

    private final LottoChecker lottoChecker = new LottoChecker();

    @Test
    @DisplayName("로또 1등 검증")
    void findWinningLottosFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("로또 2등 검증")
    void findWinningLottosSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(6);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("로또 3등 검증")
    void findWinningLottosThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("로또 4등 검증")
    void findWinningLottosFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 8, 7));
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("로또 5등 검증")
    void findWinningLottosFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 9, 8, 7));
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.FIFTH_PLACE);
    }


    @Test
    @DisplayName("로또 꼴등 검증")
    void findWinningLottosNoLuck() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 11, 9, 8, 7));
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.NO_LUCK);
    }

    @Test
    @DisplayName("로또 복수 검증")
    void findWinningLottosMultiple() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoWallet lottoWallet = new LottoWallet(List.of(lotto, lotto2));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);

        LottoResult lottoResult = lottoChecker.findWinningLottos(lottoWallet, winningNumbers, bonusNumber);

        Assertions.assertThat(lottoResult.getLottoRanks())
                .containsExactly(LottoRank.FIRST_PLACE, LottoRank.NO_LUCK);
    }

}