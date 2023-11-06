package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        int insertedMoney = userInput.insertMoney("구입금액을 입력해 주세요.");
        System.out.println();
        System.out.println(insertedMoney+"개를 구매했습니다.");

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateRandomNumbers(insertedMoney);
        randomNumberGenerator.printMyLottoNumber();
        List<List<Integer>> userLotto=randomNumberGenerator.getRandomNumbers();

        List<Integer> inputList = userInput.inputWinnerNumbers("당첨 번호를 입력해 주세요.");
        System.out.println(inputList);

        int bonusNumber = userInput.inputBonusNumber("보너스 번호를 입력해 주세요.");
        System.out.println(bonusNumber);

        Winner winner = new Winner();
        for(int i=0;i<insertedMoney;i++){
            winner.checkLottoNumbers(userLotto.get(i),inputList);
        }
        List<Integer> result = winner.getResult();
        System.out.println(result);
    }
}
