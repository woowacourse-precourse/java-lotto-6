package lotto;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 구매 가격 & 로또 구매 개수
        int purchaseAmount;
        int purchaseCount = 0;

        List<Integer> lottoNumbers = null;
        List<Integer> eachLottoNumber = null;
        List<List<Integer>> lottos = new ArrayList<>();

        System.out.println("구입금액을 입력해 주세요.");

        UserInput userInput = new UserInput();
        Process lottoCount = new Process();

        while (UserInput.repeatPurchase) {
            purchaseAmount = userInput.getPurchaseAmount();
            userInput.validatePurchaseAmount(purchaseAmount);
            purchaseCount = lottoCount.countLottos(purchaseAmount);
        }

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

        System.out.println("당첨 번호를 입력해 주세요.");

        UserInput userInputWinningNumber = new UserInput();

        while (UserInput.repeatWinningNumber) {
            winningNumbers = userInputWinningNumber.getWinningNumbers();
            userInputWinningNumber.sortWinningNumbers(winningNumbers);
            userInputWinningNumber.hasDuplicates(winningNumbers);
        }

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
        List<Integer> winRecordBoard = new ArrayList<>();
        Integer firstPlace = Integer.valueOf(0);
        Integer secondPlace = Integer.valueOf(0);
        Integer thirdPlace = Integer.valueOf(0);
        Integer fourthPlace = Integer.valueOf(0);
        Integer fifthPlace = Integer.valueOf(0);

        winRecordBoard.set(1, firstPlace);
        winRecordBoard.set(2, secondPlace);
        winRecordBoard.set(3, thirdPlace);
        winRecordBoard.set(4, fourthPlace);
        winRecordBoard.set(5, fifthPlace);

        ///

        // lottos에서 각 로또 번호와 당첨번호&보너스 번호를 비교하고, winRecordBoard에 기록하기
        for (var lottoNumber : lottos) {
            Process middleProcess = new Process();
            List<Object> result = middleProcess.compareLottos(lottoNumber, winningNumbers, bonusNumber);

            int mainMatchNumber = (int) result.get(0);
            boolean matchedBonusNumber = (boolean) result.get(1);

            if (mainMatchNumber == 3) {
                winRecordBoard.set(5, ++fifthPlace);
            }
            if (mainMatchNumber == 4) {
                winRecordBoard.set(4, ++fourthPlace);
            }
            if (mainMatchNumber == 5 && !matchedBonusNumber) {
                winRecordBoard.set(3, ++thirdPlace);
            }

            if (mainMatchNumber == 5 && matchedBonusNumber) {
                winRecordBoard.set(2, ++secondPlace);
            }

            if (mainMatchNumber == 6) {
                winRecordBoard.set(1, ++firstPlace);
            }

        }

        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");


        //수익률 출력


    }
}
