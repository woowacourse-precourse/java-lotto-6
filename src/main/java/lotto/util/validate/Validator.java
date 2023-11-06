package lotto.util.validate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.dto.input.GetWinningNumberDto;

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

    public static int checkBonusNumber(GetWinningNumberDto getWinningNumberDto, String bonusNumberInput){
        checkNumberInBoundary(checkIsNumber(bonusNumberInput));
        checkNotInWinningNumber(getWinningNumberDto,bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private static boolean hasBonusNumber(GetWinningNumberDto getWinningNumberDto, String bonusNumberInput) {
        return getWinningNumberDto.getWinningNumbers().contains(Integer.parseInt(bonusNumberInput));
    }

    private static List<Integer> checkIsWinningNumber(String[] split) {
        return checkIsRealNumber(split, getWinningNumbersList());
    }

    private static ArrayList<Integer> getWinningNumbersList() {
        return new ArrayList<>();
    }

    private static List<Integer> checkIsRealNumber(String[] split, List<Integer> winningNumbersList) {
        checkNumberCounts(getNumberCount(split, winningNumbersList, ZERO));
        checkDistinct(winningNumbersList);
        return winningNumbersList;
    }

    private static int getNumberCount(String[] split, List<Integer> winningNumbersList, int numberCount) {
        for(String number: split){
            checkIsRealNumber(winningNumbersList, number);
            numberCount++;
        }
        return numberCount;
    }

    private static Set<Integer> getSet(List<Integer> winningNumbersList) {
        Set<Integer> numberSet = new HashSet<>(winningNumbersList);
        return numberSet;
    }

    private static boolean isNotDistinct(List<Integer> winningNumbersList, Set<Integer> numberSet) {
        return numberSet.size() != winningNumbersList.size();
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

    private static boolean isThousand(Integer money) {
        return money % THOUSAND != ZERO;
    }

    private static void checkDistinct(List<Integer> winningNumbersList) {
        if(isNotDistinct(winningNumbersList, getSet(winningNumbersList))){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자들은 입력하지 마세요.");
        }
    }

    private static void checkNotInWinningNumber(GetWinningNumberDto getWinningNumberDto, String bonusNumberInput) {
        if(hasBonusNumber(getWinningNumberDto, bonusNumberInput)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호들과 달라야 합니다.");
        }
    }

    private static void checkNumberCounts(int numberCount) {
        if(isNotRightCounts(numberCount)){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    private static void checkNumberInBoundary(int realNumber) {
        if (isNotRightBoundaryNumber(realNumber)){
            throw  new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static int checkThousand(Integer money) {
        if(isThousand(money)){
            throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 최소 천원이면서 천원 단위여야 합니다.");
        }
        return money;
    }

    private static Integer checkIsNumber(String buyMoney) {
        try{
            return Integer.valueOf(buyMoney);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자만 입력해주세요");
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
    }

    private static void checkIsRealNumber(List<Integer> winningNumbersList, String number) {
        try{
            int num = Integer.parseInt(number);
            checkNumberInBoundary(num);
            winningNumbersList.add(num);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }
}
