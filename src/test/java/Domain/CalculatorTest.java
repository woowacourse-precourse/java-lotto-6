package Domain;

import Domain.Calculator;
import Domain.WinningNumber.WinningNumber;
import camp.nextstep.edu.missionutils.Randoms;
import Domain.lotto.Lotto;
import Domain.lotto.LottoOutcome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    //결과에 맞는 로또를 만드는 함수
    public Lotto getLottoFromOutcome(WinningNumber winningNumber, List<Integer> remains, Integer bonus, LottoOutcome outcome){
        List<Integer> test = new LinkedList<>();
        List<Integer> numbers = winningNumber.getNumbers();

        for (Integer index : Randoms.pickUniqueNumbersInRange(0, numbers.size()-1, outcome.getMatchOfNum())) {
            test.add(numbers.get(index));
        }
        if(outcome == LottoOutcome.rank2)
            test.add(bonus);
        int selectAtRemain = 6 - outcome.getMatchOfNum() - outcome.getBonus();
        for(Integer index: Randoms.pickUniqueNumbersInRange(0, remains.size()-1, selectAtRemain)){
            test.add(remains.get(index));
        }
        return new Lotto(test);
    }
    //1~45까지의 수와 당첨 번호 수의 차집합 리스트
    public List<Integer> getRemainNumbersAtLottoNumber(List<Integer> numbersAndBonus){
        List<Integer> remainNumber = new LinkedList<>();
        for (int i = 1; i <= 45; i++) {
            remainNumber.add(i);
        }
        remainNumber.removeAll(numbersAndBonus);
        return remainNumber;
    }

    @DisplayName("당첨 번호와 Lotto를 비교하여 결과를 산출합니다.")
    @Test
    void calculateLotto() {
        List<Integer> numbersAndBonus = Randoms.pickUniqueNumbersInRange(1, 45, 7);
        List<Integer> numbers = numbersAndBonus.subList(0, 6);
        Integer bonus = numbersAndBonus.get(6);
        WinningNumber winningNumber = new WinningNumber(numbers, bonus);
        List<Integer> remains = getRemainNumbersAtLottoNumber(numbersAndBonus);

        for(LottoOutcome outcome: LottoOutcome.values()){
            Lotto testLotto = getLottoFromOutcome(winningNumber, remains, bonus, outcome);
            assertThat(Calculator.calLottoOutcome(winningNumber, testLotto)).isEqualTo(outcome);
        }
    }
}
