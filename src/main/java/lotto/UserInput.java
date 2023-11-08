package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int insertMoney(String prompt) {
        while (true) {
            System.out.println(prompt);
            String userInput = Console.readLine();
            try {
                int insertedMoney = Integer.parseInt(userInput);
                return (insertedMoney / 1000);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 정수로 입력해야 합니다.");
            }
        }

    }

    public List<Integer> inputWinnerNumbers(String prompt) {
        while (true) {
            System.out.println(prompt);

            String userInput = Console.readLine();
            try {
                String[] splitStrings = userInput.split(",");
                List<Integer> resultList = new ArrayList<>();
                for (String str : splitStrings) {
                    int num = Integer.parseInt(str.trim());
                    resultList.add(num);
                }

                new Lotto(resultList);
                return resultList;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(String prompt) {
        while (true) {

            System.out.println(prompt);
            String userInput = Console.readLine();
            try {
                int bonusNumber = Integer.parseInt(userInput);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

        }
    }
}
