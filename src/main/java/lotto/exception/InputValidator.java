package lotto.exception;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Playing;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class InputValidator {



    public static int checkPurchaseAmountInput(){

        while(true){
            try{
                String input = Console.readLine();
                checkNullOrEmpty(input);
                Integer purchaseAmount = convertInputToNumber(input);
                checkIsPositiveNumber(purchaseAmount);
                checkIsDivided(purchaseAmount);
                return purchaseAmount;
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkIsDivided(Integer input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어지지 않습니다. 다시 입력해주세요.");
        }
    }

    public static void checkIsPositiveNumber(Integer input){
        if (input <= 0){
            throw new IllegalArgumentException("[ERROR] 양수값이 아닙니다. 다시 입력해주세요.");
        }
    }

    public static Integer checkValidBonusNumberInput(List<Integer> winningNumbers){
        Integer bonus = 0;
        while(true) {
        try{
            String input = Console.readLine();
            bonus = convertInputToNumber(input);
            checkBonusDuplicated(bonus, winningNumbers);
            checkNullOrEmpty(input);
            checkValidRange(bonus);
            break;
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            }
        }

        return bonus;
    }

    public static Integer convertInputToNumber(String input){
        try{
            Integer bonus = Integer.parseInt(input);
            return bonus;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }


    public static void checkBonusDuplicated(Integer bonus, List<Integer> winningNumbers){
        if (winningNumbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private static void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다. 다시 입력해주세요.");
        }
    }

    private static List<Integer> convertInputToNumbers(String[] splitInput) {
        try {
            return Arrays.stream(splitInput)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 있습니다. 다시 입력해주세요.");
        }
    }

    private static void checkValidCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다. 다시 입력해주세요.");
        }
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다. 다시 입력해주세요.");
        }
    }

    private static void checkValidRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    private static void checkValidRange(Integer number) {
        if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
    }

    public static List<Integer> checkWinningNumbersInput() {
        while (true) {
            try {
                String input = Console.readLine();
                checkNullOrEmpty(input);
                List<Integer> winningNumbers = convertInputToNumbers(input.split(","));
                checkValidCount(winningNumbers);
                checkDuplicate(winningNumbers);
                checkValidRange(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
