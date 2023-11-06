package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 구매 가격 & 로또 구매 개수
        int purchaseAmount;
        int purchaseCount = 0;

        List<Integer> lottoNumbers;
        List<Integer> eachLottoNumber;

        System.out.println("구입금액을 입력해 주세요.");

        UserInput userInput = new UserInput();
        Process lottoCount = new Process();

        while(UserInput.repeatPurchase) {
            purchaseAmount = userInput.getPurchaseAmount();
            userInput.validatePurchaseAmount(purchaseAmount);
            purchaseCount = lottoCount.countLottos(purchaseAmount);
        }

        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount); //



        //로또 개수만큼 로또 객체의 로또 번호 출력
        Process process = new Process();
        //로또 개수만큼 반복 => 나중에 개별 함수화 리팩토링!
        for(int i = 0; i < purchaseCount; i++){
            lottoNumbers = process.generateLottoNumbers();
            process.sortLottoNumbers(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            eachLottoNumber = lotto.getLottoNumbers();
            System.out.println(eachLottoNumber);
        }

        System.out.println();





        //당첨 번호 입력
        List<Integer> winningNumbers = null;

        System.out.println("당첨 번호를 입력해 주세요.");

        UserInput userInputWinningNumber = new UserInput();

        while(UserInput.repeatWinningNumber) {
            winningNumbers = userInputWinningNumber.getWinningNumbers();
            userInputWinningNumber.sortWinningNumbers(winningNumbers);
            userInputWinningNumber.hasDuplicates(winningNumbers);
        }

        System.out.println();


        //보너스 번호 입력
        int bonusNumber = 0;
        System.out.println("보너스 번호를 입력해 주세요.");

        UserInput userInputBonusNumber = new UserInput();

        while(UserInput.repeatBonusNumber){
            bonusNumber = userInputBonusNumber.getBonusNumber();
            userInputBonusNumber.overlapWithNumber(winningNumbers, bonusNumber);
        }

        System.out.println();



        //당첨 통계 출력
        System.out.println("당첨 통계");
        System.out.println("---");



        //수익률 출력



    }
}
