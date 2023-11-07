package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        if (!userInput.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        int money = Integer.parseInt(userInput);
        if (money == 0 || money % 1000 != 0){
            throw new IllegalArgumentException("1000단위의 수를 입력해주세요.");
        }
        return money;
    }

    public String[] getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers.split(",");
    }

    public String getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
