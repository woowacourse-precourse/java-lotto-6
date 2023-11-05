package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getLottoPurchaseAmount(){
        String input = Console.readLine();

        int lottoPurchaseAmount = checkIntegerFormat(input);
        checkDivisibilityBy1000(lottoPurchaseAmount);

        return lottoPurchaseAmount/1000;
    }

    public static List<Integer> getLottoWinningNumbers(){
        String[] inputs = Console.readLine().split(",");
        List<Integer> lottoWinningNumbers = new ArrayList<>();

        for(String input : inputs) {
            int checkedInput = checkIntegerFormat(input);
            isValidRange(checkedInput);
            lottoWinningNumbers.add(checkedInput);
        }
        return lottoWinningNumbers;
    }

    public static int getBonusNumber(){
        String input = Console.readLine();
        int bonusNumber = checkIntegerFormat(input);
        isValidRange(bonusNumber);
        return bonusNumber;
    }

    private static void checkDivisibilityBy1000(int number) {
        if(number%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 1000원 단위로 입력해주세요.");
        }
    }
    public static int checkIntegerFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
    public static void isValidRange(int number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력학세요.");
        }
    }


}
