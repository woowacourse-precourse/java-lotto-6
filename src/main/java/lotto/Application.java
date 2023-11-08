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
        Map<Integer, Integer> winRecordBoard;


        //구입 금액 입력
        UserInput userInput = new UserInput();
        Process lottoCount = new Process();

        purchaseAmount = userInput.getPurchaseAmount();
        purchaseCount = lottoCount.countLottos(purchaseAmount);

        System.out.println();


        System.out.printf("%d개를 구매했습니다.%n", purchaseCount); //

        //로또 개수만큼 로또 객체의 로또 번호 출력
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


        ///
//        winRecordBoard = createWinRecordBoard();
//        Map<Integer, Integer> winRecordBoard = new LinkedHashMap<>();
//        Integer firstPlaceCount = Integer.valueOf(0);
//        Integer secondPlaceCount = Integer.valueOf(0);
//        Integer thirdPlaceCount = Integer.valueOf(0);
//        Integer fourthPlaceCount = Integer.valueOf(0);
//        Integer fifthPlaceCount = Integer.valueOf(0);
//
//        winRecordBoard.put(1, firstPlaceCount);
//        winRecordBoard.put(2, secondPlaceCount);
//        winRecordBoard.put(3, thirdPlaceCount);
//        winRecordBoard.put(4, fourthPlaceCount);
//        winRecordBoard.put(5, fifthPlaceCount);

        ///

        // lottos에서 각 로또 번호와 당첨번호&보너스 번호를 비교하고, winRecordBoard에 기록하기
//        for (var lottoNumber : lottos) {
            Process middleProcess = new Process();
//            List<Object> result = middleProcess.compareLottos(lottoNumber, winningNumbers, bonusNumber);
//
//            int mainMatchNumber = (int) result.get(0);
//            boolean matchedBonusNumber = (boolean) result.get(1);
//
//            if (mainMatchNumber == 3) {
//                winRecordBoard.put(5, ++fifthPlaceCount);
//            }
//            if (mainMatchNumber == 4) {
//                winRecordBoard.put(4, ++fourthPlaceCount);
//            }
//            if (mainMatchNumber == 5 && !matchedBonusNumber) {
//                winRecordBoard.put(3, ++thirdPlaceCount);
//            }
//
//            if (mainMatchNumber == 5 && matchedBonusNumber) {
//                winRecordBoard.put(2, ++secondPlaceCount);
//            }
//
//            if (mainMatchNumber == 6) {
//                winRecordBoard.put(1, ++firstPlaceCount);
//            }
//
//        }
        middleProcess.recordWins(lottos, winningNumbers, bonusNumber);


        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        Print winStatisticPrint = new Print();
        winStatisticPrint.printWinStatistic();


        //수익률 계산 & 출력
        Process endProcess = new Process();

        float rateOfReturn = endProcess.calculateRateOfReturn(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }

    //개별 객체(Class)화?
//    private static Map<Integer, Integer> createWinRecordBoard(){
//        Map<Integer, Integer> winRecordBoard = new LinkedHashMap<>();
//
//        Integer firstPlaceCount = Integer.valueOf(0);
//        Integer secondPlaceCount = Integer.valueOf(0);
//        Integer thirdPlaceCount = Integer.valueOf(0);
//        Integer fourthPlaceCount = Integer.valueOf(0);
//        Integer fifthPlaceCount = Integer.valueOf(0);
//
//        winRecordBoard.put(1, firstPlaceCount);
//        winRecordBoard.put(2, secondPlaceCount);
//        winRecordBoard.put(3, thirdPlaceCount);
//        winRecordBoard.put(4, fourthPlaceCount);
//        winRecordBoard.put(5, fifthPlaceCount);
//
//        return winRecordBoard;
//    }


}
