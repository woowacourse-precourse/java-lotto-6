package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class test {
    Game testgame = new Game();

    @Test
    void 당첨번호_분리_테스트(){

        String testinput = "1,3,5,7,9,11";
        String testnum[] = testinput.split(",");
        String testbonus = "2";
        final int RESULT = 8;
        int sum = 0;


        testgame.initPrizeWinNum();
        testgame.setNum(testnum);
        testgame.setBounusNum(testbonus);

        assertThat(testgame.prizeWinNum).hasSize(testgame.LIMIT_LOTTO_NUMBER + 1);

        for(int i = 0; i < testgame.LIMIT_LOTTO_NUMBER; i++) {
            if(i == 1 || i == 3 || i == 5 || i == 7 || 1 == 9 || i == 11)
                assertThat(testgame.prizeWinNum[i]).isOne();
            else if(i == 2){
                assertThat(testgame.prizeWinNum[i]).isEqualTo(2);
            }
            sum += testgame.prizeWinNum[i];
        }

        assertThat(sum).isEqualTo(RESULT);
    }
}
