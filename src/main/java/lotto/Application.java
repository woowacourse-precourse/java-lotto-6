package lotto;

import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoGameMachine;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameMachine lottoGameMachine = new LottoGameMachine();
        Calculator calculator = new Calculator();

        // 구매 금액 입력 받기
        int insertAmount = lottoGameMachine.insertLottoPayment();
        //System.out.println(insertAmount);

        // 받은 금액으로 로또 발행하기
        List<Lotto> issuedLotto = lottoGameMachine.issueLotto(insertAmount);

        // 받은 로또 출력하기
        lottoGameMachine.arrangeAscendingOrder(issuedLotto);

        // 당첨 번호 입력하기
        List<Integer> winningLottoNumber = lottoGameMachine.insertWinningNumber();

        // 보너스 번호 입력하기
        int bonusNumber = lottoGameMachine.insertBonusNumber();

        // 당첨 번호와 받은 로또 비교하기
        Map<Lotto, Integer> hitNumberLottoMap = lottoGameMachine.compareNumbers(winningLottoNumber, issuedLotto);

        // 결과 출력
        Map<Integer,Integer> winningHistory = lottoGameMachine.printResult(hitNumberLottoMap, bonusNumber);

        // 수익률 출력
        calculator.printProfitRate(winningHistory, insertAmount);

    }
}
