package lotto;

import java.util.*;

public class InputHandler {
    
    public static Integer readCost(String input) {
        try {
            Integer cost = java.lang.Integer.parseInt(input);
            isItNaturalNumber(cost);
            return divideByThousand(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.", e);
        }
    }
    private static void isItNaturalNumber(Integer cost) {
        if(cost == 0 || cost < 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 자연수를 입력해야 합니다.");
        }
    }
    
    private static Integer divideByThousand(Integer cost) {
        if(cost % 1000 == 0) {
            return cost;
        }
        throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 숫자를 입력해야 합니다.");
    }
    
    public static List<Integer> readWinningNumber(String numberArray) {
        List<Integer> result;
        try {
            List<String> array = Arrays.stream(numberArray.split(",")).toList();
            result = array.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.");
        }
        validateNumber(result);
        return result;
    }
    public static Integer readBonusNumber(String inputNumber, List<Integer> winnginNumber) {
        Integer bonusNumber;
        try {
            bonusNumber= Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 하나의 숫자만을 입력해야 합니다.", e);
        }
        validateNumber(bonusNumber, winnginNumber);
        return bonusNumber;
    }
    
    private static void validateNumber(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        isItMissSized(winningNumbers);
        isNumberOutOfRange(winningNumbers);
        isItDuplicated(set);
    }
    
    private static void isItMissSized(List<Integer> winningNumbers) {
        if(winningNumbers.size() != Constants.LOTTONUMBER) {
            throw new IllegalArgumentException("[ERROR] 6 개의 숫자를 입력해 주세요.");
        }
    }
    
    private static void isNumberOutOfRange(List<Integer> winningNumbers) {
        if(winningNumbers.stream().anyMatch(i -> i < Constants.MIN || i > Constants.MAX)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
        }
    }
    
    private static void isItDuplicated(Set<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if(set.size() < Constants.LOTTONUMBER) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
        }
    }
    
    private static void validateNumber(Integer bonusNumber, List<Integer> winnginNumbers) {
        isNumberOutOfRange(bonusNumber);
        isItDuplicated(bonusNumber, winnginNumbers);
    }
    
    private static void isNumberOutOfRange(Integer bonusNumber) {
        if(bonusNumber < Constants.MIN || bonusNumber > Constants.MAX){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를해야 합니다.");
        }

    }
    private static void isItDuplicated(Integer bonusNumer, List<Integer> winnginNumber) {
        if(winnginNumber.contains(bonusNumer)) {
            throw new IllegalArgumentException("[ERROR] 이미 입력한 당첨 번호와 중복됩니다.");
        }
    }

}
