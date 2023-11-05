package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;
    private static final int NEED_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER= 45;
    private static final String COMMA = ",";
    public static int checkBuyMoney(String buyMoneyInput){
        return returnCount(checkThousand(checkIsNumber(buyMoneyInput)));
    }
    public static List<Integer> checkWinningNumbers(String winningNumbersInput){
        return checkIsWinningNumber(split(winningNumbersInput));
    }

    public static int checkBonusNumber(String bonusNumberInput){
        return checkNumberInBoundary(checkIsNumber(bonusNumberInput));
    }

    private static List<Integer> checkIsWinningNumber(String[] split) {
        return checkIsRealNumberIteration(split, new ArrayList<>(), 0);
    }

    private static List<Integer> checkIsRealNumberIteration(String[] split, List<Integer> winningNumbersList, int numberCount) {
        for(String number: split){
            checkIsRealNumber(winningNumbersList, number);
            numberCount++;
        }
        checkNumberCounts(numberCount);
        return winningNumbersList;
    }

    private static void checkNumberCounts(int numberCount) {
        if(isNotRightCounts(numberCount)){
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
    }

    private static boolean isNotRightCounts(int numberCount) {
        return isLowerThanSix(numberCount) || isBiggerThanSix(numberCount);
    }

    private static boolean isBiggerThanSix(int numberCount) {
        return numberCount > NEED_NUMBER_COUNT;
    }

    private static boolean isLowerThanSix(int numberCount) {
        return numberCount < NEED_NUMBER_COUNT;
    }

    private static void checkIsRealNumber(List<Integer> winningNumbersList, String number) {
        try{
            winningNumbersList.add(checkNumberInBoundary(Integer.parseInt(number)));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
    }

    private static int checkNumberInBoundary(int realNumber) {
        if (isNotRightBoundaryNumber(realNumber)){
            throw  new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return realNumber;
    }

    private static boolean isNotRightBoundaryNumber(int realNumber) {
        return isBiggerThanMinNumber(realNumber) || isLowerThanMaxNumber(realNumber);
    }

    private static boolean isLowerThanMaxNumber(int realNumber) {
        return realNumber > MAX_NUMBER;
    }

    private static boolean isBiggerThanMinNumber(int realNumber) {
        return realNumber < MIN_NUMBER;
    }

    private static String[] split(String winningNumbers) {
        return winningNumbers.split(COMMA);
    }

    private static int returnCount(Integer money) {
        return money / THOUSAND;
    }

    private static int checkThousand(Integer money) {
        if(isThousand(money)){
            throw new IllegalArgumentException("구입 금액 단위는 최소 천원이면서 천원 단위여야 합니다.");
        }
        return money;
    }

    private static boolean isThousand(Integer money) {
        return money % THOUSAND != ZERO;
    }

    private static Integer checkIsNumber(String buyMoney) {
        try{
            return Integer.valueOf(buyMoney);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }
}
