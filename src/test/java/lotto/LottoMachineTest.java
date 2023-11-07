package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constans.WinningGrade;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("로또 구입을 원하는 금액을 입력하면 구입 가능 갯수를 반환한다.")
    void wantBuyAmountToQuantityTest (){
        // given
        LottoMachine lottoMachine = new LottoMachine();
        int wantBuyAmount = 5000;

        // when
        int wantBuyAmountToQuantity = lottoMachine.wantBuyAmountToQuantity(5000);

        // then
        Assertions.assertEquals(wantBuyAmountToQuantity,wantBuyAmount/1000);
    }

    @Test
    @DisplayName("로또 구입 갯수를 입력하면 갯수만큼 로또를 발행한다.")
    void makeLottosTest (){
        // given
        LottoMachine lottoMachine = new LottoMachine();
        int wantBuyQuantity = 5;

        // when
        List<Lotto> lottos = lottoMachine.makeLottos(wantBuyQuantity);

        // then
        Assertions.assertEquals(5,lottos.size());
    }

    @Test
    @DisplayName("결과 Map 에는 1~5등 에 대한 당첨 갯수가 담겨있다.")
    void makeResultMapTest (){
        // given
        LottoMachine lottoMachine = new LottoMachine();
        User user = new User();
        List<Integer> winningNumber = user.inputWinningNumber("1,2,3,4,5,6");
        int bonusNumber = user.inputBonusNumber("7", winningNumber);
        List<Lotto> lottos = lottoMachine.makeLottos(5);

        // when
        Map<WinningGrade, Integer> map = lottoMachine.makeResultMap(lottos, winningNumber, bonusNumber);

        // then
        Assertions.assertEquals(5,map.size());
    }
    
    @Test
    @DisplayName("당첨 결과 테스트")
    void makeResultTest (){
        // given
        LottoMachine lottoMachine = new LottoMachine();
        Map<WinningGrade, Integer> resultMap = new HashMap<>();
        resultMap.put(WinningGrade.FIRST_PRIZE,0);
        resultMap.put(WinningGrade.SECOND_PRIZE,0);
        resultMap.put(WinningGrade.THIRD_PRIZE,0);
        resultMap.put(WinningGrade.FOURTH_PRIZE,0);
        resultMap.put(WinningGrade.FIFTH_PRIZE,1);
        int wantBuyAmount = 8000;
        String expected = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """;


        // when
        String result = lottoMachine.makeResult(resultMap, wantBuyAmount);

        // then
        Assertions.assertEquals(expected,result);
    }
}
