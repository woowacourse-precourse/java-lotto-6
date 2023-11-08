package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        Lotto lottoAnswer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusAnswer = new LottoBonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lottoAnswer, bonusAnswer);

        Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto fifth = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        Lotto noPrize1 = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        Lotto noPrize2 = new Lotto(List.of(1, 8, 9, 10, 11, 12));
        Lotto noPrize3 = new Lotto(List.of(8, 9, 10, 11, 12, 13));

        Lotto noPrize4 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto noPrize5 = new Lotto(List.of(1, 7, 8, 9, 10, 11));
        Lotto noPrize6 = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        Lotto fifthWithBonus = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto fourthWithBonus = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Lotto> lottos = List.of(
            first, second, third, fourth, fifth
            , noPrize1, noPrize2, noPrize3, noPrize4, noPrize5, noPrize6
            , fifthWithBonus, fourthWithBonus
        );
        PurchasedLottos purchasedLottos = new PurchasedLottos(lottos);

        lottoGame = new LottoGame(purchasedLottos, winningLotto);
    }

    @DisplayName("로또_추첨_결과_생성_테스트")
    @Test
    void createWinningLottoRanks() {
        assertThat(lottoGame.createWinningLottoRanks()).containsExactly(
                LottoRank.SIX,
                LottoRank.FIVE_WITH_BONUS,
                LottoRank.FIVE_WITHOUT_BONUS,
                LottoRank.FOUR,
                LottoRank.THREE
        );
    }
}