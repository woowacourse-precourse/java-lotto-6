package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import service.PrintService;

public class UserController {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";

    private static PrintService printService = new PrintService();

    public int enterBonus(){
        printService.requestUserInputMessage(ENTER_BONUS);
        String userInput = Console.readLine();
        try{
            int bonus = validateBonus(userInput);
            validateBonusRange(bonus);
            return bonus;
        }catch (IllegalArgumentException e){
            printService.errorMessage(e.getMessage());
            return enterBonus();
        }
    }
    public void validateBonusRange(int userInput){
        if(!(0 < userInput && userInput < 47)) {
            throw new IllegalArgumentException("보너스 번호가 범위를 벗어났습니다. 1 ~ 46 사이의 값을 입력하세요.");
        }
    }

    public int validateBonus(String userInput){
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자를 입력하세요.");
        }
    }

    public List<Integer> enterLottoNumbers(){
        printService.requestUserInputMessage(ENTER_LOTTO_NUMBER);

        String[] userInput = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String strNumber: userInput) {
            try{
                int number = validateWinningNumber(strNumber);
                validateWinningNumberRange(number);
                numbers.sort(Comparator.naturalOrder());
                numbers.add(number);

            }catch (IllegalArgumentException e){
                printService.errorMessage(e.getMessage());
                enterLottoNumbers();
            }
        }
        return numbers;
    }

    public void validateWinningNumberRange(int userInput){
        if(!(0 < userInput && userInput < 47)) {
            throw new IllegalArgumentException("당첨 번호의 범위를 벗어났습니다. 1 ~ 46 사이의 값을 입력하세요.");
        }
    }

    public int validateWinningNumber(String userInput){
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자를 입력하세요.");
        }
    }

    //구매 금액
    public int enterPurchaseAmount(){
        printService.requestUserInputMessage(ENTER_PURCHASE_AMOUNT);
        String userInput = Console.readLine();
        try {
            int intUserInput = validateBuyAmountIsInt(userInput);
            validateBuyAmountIsThousand(intUserInput);
            intUserInput /= 1000;

            printService.printAmount(intUserInput);
            return intUserInput;
        }catch (IllegalArgumentException e){
            printService.errorMessage(e.getMessage());
            return enterPurchaseAmount();
        }
    }

    public int validateBuyAmountIsInt(String userInput){
        try {
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }

    public void validateBuyAmountIsThousand(int userInput){
        if(userInput % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위를 입력해야 합니다.");
        }
    }

}
