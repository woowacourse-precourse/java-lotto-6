package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //로또 구매 가격 & 로또 구매 개수
        int purchaseAmount;
        int purchaseCount = 0;

        System.out.println("구입금액을 입력해 주세요.");

        UserInput userInput = new UserInput();

        while(UserInput.repeatPurchase) {
            purchaseAmount = userInput.getPurchaseAmount();
            purchaseCount = userInput.validatePurchaseAmount(purchaseAmount);
        }

        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount); //



        //로또 개수만큼 로또 객체의 로또 번호 출력

        System.out.println();




        //당첨 번호 입력
        List<Integer> winningNumbers;

        System.out.println("당첨 번호를 입력해 주세요.");

        UserInput userInputWinningNumber = new UserInput();

        while(UserInput.repeatWinningNumber) {
            winningNumbers = userInputWinningNumber.getWinningNumbers();
            userInputWinningNumber.sortWinningNumbers(winningNumbers);
            userInputWinningNumber.hasDuplicates(winningNumbers);
        }



    }
}
