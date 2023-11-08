package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class test {
    Game testGame = new Game();
    Lotto testLotto;

    @Test
    void 당첨번호_분리_입력_테스트() {

        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        final int RESULT = 8; // 1이 6개, 2가 1개, 나머지가 0인 배열이므로 총 합이 8이 나와야 한다.
        int sum = 0;

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        for (int i = 1; i <= testGame.LIMIT_LOTTO_NUMBER; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || 1 == 9 || i == 11) // 당첨번호가 인덱스인 위치의 값이 1인지 확인
                assertThat(testGame.prizeWinNum[i]).isOne();
            else if (i == 2) {
                assertThat(testGame.prizeWinNum[i]).isEqualTo(2); // 보너스번호가 인덱스인 위치의 값이 2인지 확인
            }
            sum += testGame.prizeWinNum[i]; // 모든 배열안의 값을 더함
        }

        assertThat(sum).isEqualTo(RESULT);
    }

    @Test
    void 번호비교_테스트() {
        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        List<Integer> testLottoNum = new ArrayList<Integer>();

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        testLottoNum.add(1);
        testLottoNum.add(2);
        testLottoNum.add(3);
        testLottoNum.add(4);
        testLottoNum.add(5);
        testLottoNum.add(6);

        testLotto = new Lotto(testLottoNum);
        testLotto.checkLotto(testGame.prizeWinNum);
        assertThat(testLotto.ranking).isEqualTo(5);
    }

    @Test
    void 번호비교_테스트2() {
        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        List<Integer> testLottoNum = new ArrayList<Integer>();

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        testLottoNum.add(1);
        testLottoNum.add(3);
        testLottoNum.add(5);
        testLottoNum.add(7);
        testLottoNum.add(9);
        testLottoNum.add(11);

        testLotto = new Lotto(testLottoNum);
        testLotto.checkLotto(testGame.prizeWinNum);
        assertThat(testLotto.ranking).isEqualTo(1);
    }

    @Test
    void 번호비교_테스트3() {
        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        List<Integer> testLottoNum = new ArrayList<Integer>();

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        testLottoNum.add(1);
        testLottoNum.add(2);
        testLottoNum.add(3);
        testLottoNum.add(5);
        testLottoNum.add(7);
        testLottoNum.add(9);

        testLotto = new Lotto(testLottoNum);
        testLotto.checkLotto(testGame.prizeWinNum);
        assertThat(testLotto.ranking).isEqualTo(2);
    }


    @Test
    void 통계_저장_테스트1(){
        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        List<Integer> testLottoNum = new ArrayList<Integer>();

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        testLottoNum.add(1);
        testLottoNum.add(2);
        testLottoNum.add(3);
        testLottoNum.add(5);
        testLottoNum.add(7);
        testLottoNum.add(9);

        testLotto = new Lotto(testLottoNum);
        testGame.statistics(testLotto);

        assertThat(testGame.winStat[2]).isEqualTo(1);
    }

    @Test
    void 통계_저장_테스트2() {
        String testInput = "1,3,5,7,9,11";
        String testNum[] = testInput.split(",");
        String testBonus = "2";
        List<Integer> testLottoNum = new ArrayList<Integer>();

        testGame.initPrizeWinNum();
        testGame.setNum(testNum);
        testGame.setBounusNum(testBonus);

        testLottoNum.add(1);
        testLottoNum.add(3);
        testLottoNum.add(5);
        testLottoNum.add(7);
        testLottoNum.add(9);
        testLottoNum.add(11);

        testLotto = new Lotto(testLottoNum);
        testGame.statistics(testLotto);

        assertThat(testGame.winStat[1]).isEqualTo(1);
    }
}
