package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoSystem;
import lotto.type.WinningResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("첫 초기화시 winningResult가 잘 생성되는지 확인")
    @Test
    void init() {
        //when
        LottoGame lottoGame = new LottoGame();
        //given
        lottoGame.init();
        Map<WinningResultType, Integer> winningResult = lottoGame.getWinningResult();
        //then
        assertThat(winningResult.size()).isEqualTo(6);
        assertThat(winningResult.get(WinningResultType.WINNING_RESULT_3_MATCH)).isEqualTo(0);
    }

    @DisplayName("갯수만큼 로또가 생성되고 저장되는지 확인")
    @Test
    void saveLotto1() {
        //when
        LottoGame lottoGame = new LottoGame();
        int lottoCount = 5;
        //given
        lottoGame.init();
        List<Lotto> lottos = lottoGame.getLottos();
        lottoGame.saveGeneratedLottosAndPrint(lottoCount);
        //then
        assertThat(lottos.size()).isEqualTo(5);
        assertThat(lottos.get(0).getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또의 당첨결과를 각 상황별로 잘 저장하는지")
    @Test
    void saveWinningResultAndPrint() {
        //given
        LottoGame lottoGame = new LottoGame();
        lottoGame.init();
        lottoGame.setLottoSystem(new LottoSystem(List.of(1, 2, 3, 4, 5, 6), 7));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 6, 10));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        lottoGame.getLottos().add(lotto1);
        lottoGame.getLottos().add(lotto2);
        lottoGame.getLottos().add(lotto3);
        lottoGame.getLottos().add(lotto4);
        lottoGame.getLottos().add(lotto5);
        lottoGame.getLottos().add(lotto6);
        //when
        lottoGame.saveWinningResultAndPrint();
        //then
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_NOTHING)).isEqualTo(0);
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_3_MATCH)).isEqualTo(1);
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_4_MATCH)).isEqualTo(1);
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_5_MATCH)).isEqualTo(2);
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_6_MATCH)).isEqualTo(1);
        assertThat(lottoGame.getWinningResult().get(WinningResultType.WINNING_RESULT_5_MATCH_AND_BONUS_MATCH)).isEqualTo(1);

    }

}