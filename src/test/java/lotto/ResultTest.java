package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    
    @Test
    @DisplayName("보너스 숫자를 포함해 5개 숫자를 맞춘경우: SECOND")
    void makeScoresTest() {
        Result result = new Result();
        List<Integer> winningNumber = List.of(1,5,7,13,24,34);
        Integer bonusNumber = 3;
        List<Integer> number = List.of(1, 5, 7, 13, 3, 44); 
        Lotto lotto = new Lotto(number);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        
        result.makeScores(winningNumber, bonusNumber, lottoList);
        
        assertThat(result.getScores().get(0)).isEqualTo(Score.SECOND);
    }

    @Test
    @DisplayName("6개 숫자를 맞춘경우: FIRST")
    void makeScoresTest1() {
        Result result = new Result();
        List<Integer> winningNumber = List.of(1,5,7,13,24,34);
        Integer bonusNumber = 3;
        List<Integer> number = List.of(1, 5, 7, 13, 24, 34);
        Lotto lotto = new Lotto(number);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        
        result.makeScores(winningNumber, bonusNumber, lottoList);

        assertThat(result.getScores().get(0)).isEqualTo(Score.FIRST);
    }

    @Test
    @DisplayName("보너스 숫자 없이 5개 숫자를 맞춘경우: THIRD")
    void makeScoresTest2() {
        Result result = new Result();
        List<Integer> winningNumber = List.of(1,5,7,13,24,34);
        Integer bonusNumber = 3;
        List<Integer> number = List.of(1, 5, 7, 13, 24, 45);
        Lotto lotto = new Lotto(number);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        
        result.makeScores(winningNumber, bonusNumber, lottoList);

        assertThat(result.getScores().get(0)).isEqualTo(Score.THIRD);
    }

    @Test
    @DisplayName("4개 숫자를 맞춘경우: FOURTH")
    void makeScoresTest3() {
        Result result = new Result();
        List<Integer> winningNumber = List.of(1,5,7,13,24,34);
        Integer bonusNumber = 3;
        List<Integer> number = List.of(1, 5, 7, 13, 14, 45);
        Lotto lotto = new Lotto(number);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        
        result.makeScores(winningNumber, bonusNumber, lottoList);

        assertThat(result.getScores().get(0)).isEqualTo(Score.FOURTH);
    }
    @Test
    @DisplayName("3개 숫자를 맞춘경우: FIFTH")
    void makeScoresTest4() {
        Result result = new Result();
        List<Integer> winningNumber = List.of(1,5,7,13,24,34);
        Integer bonusNumber = 3;
        List<Integer> number = List.of(1, 5, 7, 11, 14, 45);
        Lotto lotto = new Lotto(number);
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto);
        
        result.makeScores(winningNumber, bonusNumber, lottoList);

        assertThat(result.getScores().get(0)).isEqualTo(Score.FIFTH);
    }

    @Test
    @DisplayName("findProfitRate: 10개 뽑아서 2등과 4등에 하나씩 당첨되었을 때: 300500% 수익")
    void findProfitRateTest() {
        Result result = new Result();
        List<Score> scores = new ArrayList<>();

        scores.add(Score.SECOND); //30000000
        scores.add(Score.FOURTH); //50000

        result.setScores(scores);
        int moneyInput = 10000;
        result.findProfitRate(result, moneyInput);

        assertThat(result.getProfitRate()).isEqualTo(300500);

    }
}
