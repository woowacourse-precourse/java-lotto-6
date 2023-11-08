package lotto;

import camp.nextstep.edu.missionutils.Console;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 구매 가격 & 로또 구매 개수
        int purchaseAmount = 0;
        int purchaseCount = 0;
        int bonusNumber = 0;

        List<List<Integer>> lottos = new ArrayList<>();
        List<Integer> winningNumbers = null;


        //구입 금액 입력
        UserInput userInput = new UserInput();
        Process lottoCount = new Process();

        purchaseAmount = userInput.getPurchaseAmount();
        purchaseCount = lottoCount.countLottos(purchaseAmount);

        System.out.println();


        //로또 개수만큼 로또 객체의 로또 번호 출력
        Print lottoCountPrint = new Print();
        lottoCountPrint.printLottoCount(purchaseCount);


        Process startProcess = new Process();
        Print lottosPrint = new Print();

        lottos = startProcess.saveLottos(purchaseCount);
        lottosPrint.printLottos(lottos);

        System.out.println();


        //당첨 번호 입력
        UserInput userInputWinningNumber = new UserInput();

        winningNumbers = userInputWinningNumber.getWinningNumbers();
        userInputWinningNumber.sortWinningNumbers(winningNumbers);

        System.out.println();


        //보너스 번호 입력
        UserInput userInputBonusNumber = new UserInput();

        bonusNumber = userInputBonusNumber.getBonusNumber(winningNumbers);

        System.out.println();


        // lottos에서 각 로또 번호와 당첨번호&보너스 번호를 비교하고, WinningRankPrize에 업데이트
        Process middleProcess = new Process();
        middleProcess.recordWins(lottos, winningNumbers, bonusNumber);


        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        Print winStatisticPrint = new Print();
        winStatisticPrint.printWinStatistic();


        //수익률 계산 & 출력
        Print resultPrint = new Print();

        resultPrint.printRateOfReturn(purchaseAmount);
    }

}
