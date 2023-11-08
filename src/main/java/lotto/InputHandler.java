package lotto;

import java.util.*;

public class InputHandler {
    
    public static Integer readCost(String input) {
        try {
            Integer cost = java.lang.Integer.parseInt(input);
            isItNaturalNumber(cost);
            return divideByThousand(cost);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만을 입력해야 합니다.");
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000 단위의 자연수를 입력해야 합니다.");
            return 0;
        }
    }
    private static void isItNaturalNumber(Integer cost) {
        if(cost == 0 || cost < 0) {
            throw new IllegalArgumentException();
        }
    }
    
    private static Integer divideByThousand(Integer cost) {
        if(cost % 1000 == 0) {
            return cost;
        }
        throw new IllegalArgumentException();
    }
    
    public static List<Integer> readWinningNumber(String numberArray) {
        List<Integer> result;
        try {
            List<String> array = Arrays.stream(numberArray.split(",")).toList();
            result = array.stream().map(Integer::parseInt).toList();
            validateNumber(result);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만을 입력해야 합니다.");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.MESSAGE_INSTRUCTION);
            return null;
        }
        return result;
    }
    public static Integer readBonusNumber(String inputNumber, List<Integer> winnginNumber) {
        Integer bonusNumber;
        try {
            bonusNumber= Integer.parseInt(inputNumber);
            validateNumber(bonusNumber, winnginNumber);
        } catch (NumberFormatException e) {
            System.out.println(Constants.MESSAGE_INSTRUCTION_BONUS);
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.MESSAGE_INSTRUCTION_BONUS);
            return null;
        }
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
            throw new IllegalArgumentException();
        }
    }
    
    private static void isNumberOutOfRange(List<Integer> winningNumbers) {
        if(winningNumbers.stream().anyMatch(i -> i < Constants.MIN || i > Constants.MAX)) {
            throw new IllegalArgumentException();
        }
    }
    
    private static void isItDuplicated(Set<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if(set.size() < Constants.LOTTONUMBER) {
            throw new IllegalArgumentException();
        }
    }
    
    private static void validateNumber(Integer bonusNumber, List<Integer> winnginNumbers) {
        isNumberOutOfRange(bonusNumber);
        isItDuplicated(bonusNumber, winnginNumbers);
    }
    
    private static void isNumberOutOfRange(Integer bonusNumber) {
        if(bonusNumber < Constants.MIN || bonusNumber > Constants.MAX){
            throw new IllegalArgumentException("[ERROR] "+Constants.MIN+"~"+Constants.MAX+" 사이의 숫자를 입력해야 합니다.");
        }

    }
    private static void isItDuplicated(Integer bonusNumer, List<Integer> winnginNumber) {
        if(winnginNumber.contains(bonusNumer)) {
            throw new IllegalArgumentException("[ERROR] 이미 입력한 당첨 번호와 중복됩니다.");
        }
    }

}
