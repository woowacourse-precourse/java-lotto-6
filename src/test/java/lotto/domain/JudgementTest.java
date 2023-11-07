package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgementTest {
    @DisplayName("로또 번호 확인 테스트, 로또 번호가 (1,2,3,4,5,6), (3,4,5,6,7,8) 당첨번호가 1,2,3,4,5,6 보너스가 7일 경우")
    @Test
    void checkWinningLottoNumbers() {
        Lottos lottos = new Lottos(0);
        lottos.addLottos(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.addLottos(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.addLottos(new Lotto(List.of(3,4,5,6,7,8)));
        Judgement judgement = new Judgement();
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        winningLotto.addBonusNumber("7");
        judgement.checkLottoNumber(lottos,winningLotto);
        Assertions.assertEquals(lottos.getWinningCounts(), List.of(7,6,5));
    }

    @DisplayName("로또 랭킹 테스트, 로또 번호가 (1,2,3,4,5,6), (3,4,5,6,7,8) 당첨번호가 1,2,3,4,5,6 보너스가 7일 경우 등수 확인")
    @Test
    void checkWinningLottoRank() {
        Lottos lottos = new Lottos(0);
        lottos.addLottos(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.addLottos(new Lotto(List.of(1,2,3,4,5,7)));
        lottos.addLottos(new Lotto(List.of(3,4,5,6,7,8)));
        Judgement judgement = new Judgement();
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        winningLotto.addBonusNumber("7");
        judgement.checkLottoNumber(lottos,winningLotto);
        List<Integer> rank = judgement.judgeAllLottoRank(lottos);
        Assertions.assertEquals(rank, List.of(0,0,1,1,1));
    }

    @DisplayName("수익률 계산")
    @Test
    void checkcalculateEarningRate(){
        List<Integer> rank = List.of(0,2,0,0,0);
        Judgement judgement = new Judgement();
        Money money = new Money("5000");
        float earningRate = judgement.calculateEarningRate(rank, money);
        Assertions.assertEquals(earningRate, 2000.0);
    }
}
