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

        List<Integer> lottoNumbers = null;
        List<Integer> eachLottoNumber = null;
        List<List<Integer>> lottos = new ArrayList<>();


        //구입 금액 입력
        UserInput userInput = new UserInput();
        Process lottoCount = new Process();

        purchaseAmount = userInput.getPurchaseAmount();
        purchaseCount = lottoCount.countLottos(purchaseAmount);
        System.out.println();


        System.out.printf("%d개를 구매했습니다.%n", purchaseCount); //

        //로또 개수만큼 로또 객체의 로또 번호 출력
        Process startProcess = new Process();
        //로또 개수만큼 반복 => 나중에 개별 함수화 리팩토링!
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers = startProcess.generateLottoNumbers();
            startProcess.sortLottoNumbers(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            eachLottoNumber = lotto.getLottoNumbers();
            lottos.add(eachLottoNumber);
            System.out.println(eachLottoNumber);
        }

        System.out.println();


        //당첨 번호 입력
        List<Integer> winningNumbers = null;

        UserInput userInputWinningNumber = new UserInput();

        winningNumbers = userInputWinningNumber.getWinningNumbers();
        userInputWinningNumber.sortWinningNumbers(winningNumbers);

        System.out.println();


        //보너스 번호 입력
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");

        UserInput userInputBonusNumber = new UserInput();

        while (UserInput.repeatBonusNumber) {
            bonusNumber = userInputBonusNumber.getBonusNumber();
            userInputBonusNumber.overlapWithNumber(winningNumbers, bonusNumber);
        }

        System.out.println();


        ///
        Map<Integer, Integer> winRecordBoard = new LinkedHashMap<>();
        Integer firstPlaceCount = Integer.valueOf(0);
        Integer secondPlaceCount = Integer.valueOf(0);
        Integer thirdPlaceCount = Integer.valueOf(0);
        Integer fourthPlaceCount = Integer.valueOf(0);
        Integer fifthPlaceCount = Integer.valueOf(0);

        winRecordBoard.put(1, firstPlaceCount);
        winRecordBoard.put(2, secondPlaceCount);
        winRecordBoard.put(3, thirdPlaceCount);
        winRecordBoard.put(4, fourthPlaceCount);
        winRecordBoard.put(5, fifthPlaceCount);

        ///

        // lottos에서 각 로또 번호와 당첨번호&보너스 번호를 비교하고, winRecordBoard에 기록하기
        for (var lottoNumber : lottos) {
            Process middleProcess = new Process();
            List<Object> result = middleProcess.compareLottos(lottoNumber, winningNumbers, bonusNumber);

            int mainMatchNumber = (int) result.get(0);
            boolean matchedBonusNumber = (boolean) result.get(1);

            if (mainMatchNumber == 3) {
                winRecordBoard.put(5, ++fifthPlaceCount);
            }
            if (mainMatchNumber == 4) {
                winRecordBoard.put(4, ++fourthPlaceCount);
            }
            if (mainMatchNumber == 5 && !matchedBonusNumber) {
                winRecordBoard.put(3, ++thirdPlaceCount);
            }

            if (mainMatchNumber == 5 && matchedBonusNumber) {
                winRecordBoard.put(2, ++secondPlaceCount);
            }

            if (mainMatchNumber == 6) {
                winRecordBoard.put(1, ++firstPlaceCount);
            }

        }


        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");

        //루프 리팩토링 가능?
        System.out.printf(WinningRankPrize.FIFTH.getMatchCount() + " (%s원) - %d개%n", WinningRankPrize.FIFTH.getPrizeAmount(), winRecordBoard.get(5));
        System.out.printf(WinningRankPrize.FOURTH.getMatchCount() + " (%s원) - %d개%n", WinningRankPrize.FOURTH.getPrizeAmount(), winRecordBoard.get(4));
        System.out.printf(WinningRankPrize.THIRD.getMatchCount() + " (%s원) - %d개%n", WinningRankPrize.THIRD.getPrizeAmount(), winRecordBoard.get(3));
        System.out.printf(WinningRankPrize.SECOND.getMatchCount() + " (%s원) - %d개%n", WinningRankPrize.SECOND.getPrizeAmount(), winRecordBoard.get(2));
        System.out.printf(WinningRankPrize.FIRST.getMatchCount() + " (%s원) - %d개%n", WinningRankPrize.FIRST.getPrizeAmount(), winRecordBoard.get(1));


        //수익률 계산 & 출력
        Process endProcess = new Process();
        float rateOfReturn = endProcess.calculateRateOfReturn(purchaseAmount, winRecordBoard);
        System.out.printf("총 수익률은 %.2f%%입니다.", rateOfReturn);


    }
}
