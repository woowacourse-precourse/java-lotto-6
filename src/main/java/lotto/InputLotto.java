package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputLotto {

    public static String PurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = Console.readLine();
        System.out.println("");

        return inputPurchaseAmount;
    }


    public static String winningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        System.out.println("");

        return inputWinningNumber;
    }

    public static List<Integer> saveNumbers(String inputWinningNumber) {

        // 입력받은 숫자를 쉼표로 분할하고 List에 저장
        List<Integer> numbers = new ArrayList<>();
        String[] numberStrings = inputWinningNumber.split(",");
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            numbers.add(number);
        }

        return numbers;
    }

    public static int bonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        System.out.println("");
        int bonusNumber = Integer.parseInt(inputBonusNumber);


        return bonusNumber;
    }


}
