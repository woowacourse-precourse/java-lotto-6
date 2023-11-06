package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInput userInput = new UserInput();
        int insertedMoney = userInput.insertMoney("구입금액을 입력해 주세요.");
        System.out.println(insertedMoney);

        List<Integer> inputList = userInput.inputWinnerNumbers("당첨 번호를 입력해 주세요.");
        System.out.println(inputList);

        int bonusNumber = userInput.inputBonusNumber("보너스 번호를 입력해 주세요.");
        System.out.println(bonusNumber);
    }
}
