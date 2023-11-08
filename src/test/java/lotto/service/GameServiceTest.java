package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService = new GameService();

    @DisplayName("구입금액을 받아 당첨 로또를 생성한다.")
    @Test
    public void initGame_구입금액_받아_당첨번호_생성(){
        //given
        int lottoMoney = 5000;

        //when
        gameService.initGame(lottoMoney);

        //then
        assertThat(gameService.getWinningLottos().size()).isEqualTo(lottoMoney / Lotto.LOTTO_PRICE);
    }

    @DisplayName("사용자 입력 로또 번호와 당첨 로또 번호를 비교한다.")
    @Test
    void comparePlayerLottoWithWinningLottos_사용자_입력_로또_번호_당첨_로또_번호_비교() {
        //given
        List<Integer> playerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        gameService.setPlayerLotto(new Lotto(playerLottoNumbers));
        gameService.setBonusNumber(bonusNumber);

        //when
        assertRandomUniqueNumbersInRangeTest(() -> gameService.initGame(1000), List.of(1,2,3,4,5,6));
        gameService.comparePlayerLottoWithWinningLottos();

        //then
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        assertThat(rankCountMap.get(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("사용자 입력 로또 번호와 당첨 로또 번호를 비교한다.")
    @Test
    void comparePlayerLottoWithWinningLottos_사용자_입력_로또_번호_당첨_로또_번호_비교_여러개_당첨() {
        //given
        List<Integer> playerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        gameService.setPlayerLotto(new Lotto(playerLottoNumbers));
        gameService.setBonusNumber(bonusNumber);

        //when
        assertRandomUniqueNumbersInRangeTest(() -> gameService.initGame(3000), List.of(1,2,3,4,5,6), List.of(2,3,4,5,6,7), List.of(2,3,4,5,6,8));
        gameService.comparePlayerLottoWithWinningLottos();

        //then
        Map<Rank, Integer> rankCountMap = gameService.getRankCountMap();
        System.out.println(rankCountMap);
        assertThat(rankCountMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCountMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCountMap.get(Rank.THIRD)).isEqualTo(1);
    }

    @DisplayName("당첨 통계에서 수익률을 계산하여 반환한다.")
    @Test
    void calculateProfitRate_당첨_통계에서_수익률_계산하여_반환_단일_당첨() {
        //given
        List<Integer> playerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int inputLottoMoney = 3000;
        gameService.setPlayerLotto(new Lotto(playerLottoNumbers));
        gameService.setBonusNumber(bonusNumber);
        assertRandomUniqueNumbersInRangeTest(() -> gameService.initGame(inputLottoMoney), List.of(1,2,3,4,5,6), List.of(10,11,12,13,14,15), List.of(16,17,18,19,20,21));
        gameService.comparePlayerLottoWithWinningLottos();

        //when
        double profitRate = gameService.calculateProfitRate();

        //then
        int totalWinningMoney = Rank.FIRST.getWinningMoney();
        assertThat(profitRate).isEqualTo((double) totalWinningMoney / inputLottoMoney * 100);
    }

    @DisplayName("당첨 통계에서 수익률을 계산하여 반환한다.")
    @Test
    void calculateProfitRate_당첨_통계에서_수익률_계산하여_반환_여러개_당첨() {
        //given
        List<Integer> playerLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int inputLottoMoney = 3000;
        gameService.setPlayerLotto(new Lotto(playerLottoNumbers));
        gameService.setBonusNumber(bonusNumber);
        assertRandomUniqueNumbersInRangeTest(() -> gameService.initGame(inputLottoMoney), List.of(1,2,3,4,5,6), List.of(2,3,4,5,6,7), List.of(2,3,4,5,6,8));
        gameService.comparePlayerLottoWithWinningLottos();

        //when
        double profitRate = gameService.calculateProfitRate();

        //then
        int totalWinningMoney = Rank.FIRST.getWinningMoney() + Rank.SECOND.getWinningMoney() + Rank.THIRD.getWinningMoney();
        assertThat(profitRate).isEqualTo((double) totalWinningMoney / inputLottoMoney * 100);
    }
}