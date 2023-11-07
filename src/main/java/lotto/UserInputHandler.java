package lotto;

import static lotto.ExceptionHandler.checkMoneyUnitValidity;
import static lotto.ExceptionHandler.checkWinningNumbersValidity;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputHandler {

    public static void requestPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static int getLottoPurchaseAmount() {
        while (true) {
            try {
                String purchase = Console.readLine();
                checkMoneyUnitValidity(Integer.parseInt(purchase));
                return Integer.parseInt(purchase);
            } catch (Exception e) {
                System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력헤야 합니다.");
            }
        }
    }

    public static void requestInputForWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> inputWinningNumbers() {
        while (true) {

            try {
                String winning = Console.readLine();
                ArrayList<String> winningNum = new ArrayList(Arrays.asList(winning.split(",")));
                ArrayList<Integer> intNumList = removeEmptySpace(winningNum);
                checkWinningNumbersValidity(intNumList);

                return intNumList;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        }

    }

    public static ArrayList<Integer> removeEmptySpace(ArrayList<String> winningNum) {
        ArrayList<Integer> intNumList = new ArrayList();
        for (int i = 0; i < winningNum.size(); i++) {
            String winningNumber = winningNum.get(i).replace(" ", "");
            int number = Integer.parseInt(winningNumber);
            intNumList.add(number);
        }
        return intNumList;
    }

}
