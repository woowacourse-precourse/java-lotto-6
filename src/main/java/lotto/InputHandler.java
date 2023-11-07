package lotto;

import java.util.*;

public class InputHandler {
    
    private static final Integer maxNumber = 45;
    private static final Integer minNumber = 1;
    
    
    public Integer readCost(String input) {
        try {
            Integer cost = Integer.parseInt(input);
            return divideByThousand(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만을 입력해야 합니다.", e);
        }
    }
    
    private Integer divideByThousand(Integer cost) {
        if(cost % 1000 == 0) {
            return cost;
        }
        throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지는 숫자를 입력해야 합니다.");
    }
    
    public List<Integer> readWinningNumber(String numberArray) {
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
    public Integer readBonusNumber(String inputNumber, List<Integer> winnginNumber) {
        Integer bonusNumber;
        try {
            bonusNumber= Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 하나의 숫자만을 입력해야 합니다.", e);
        }
        validateNumber(bonusNumber, winnginNumber);
        return bonusNumber;
    }
    
    private void validateNumber(List<Integer> winningNumbers) {
        if(winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6 개의 숫자를 입력해 주세요.");
        }
        if(winningNumbers.stream().anyMatch(i -> i < minNumber || i > maxNumber)) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
        }
        Set<Integer> set = new HashSet<>(winningNumbers);
        isItDuplicated(set);
    }
    private void isItDuplicated(Set<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if(set.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하습니다.");
        }
    }
    
    private void validateNumber(Integer bonusNumber, List<Integer> winnginNumbers) {
        if(bonusNumber < minNumber || bonusNumber > maxNumber){
            throw new IllegalArgumentException(" 입력[ERROR] 1~45 사이의 숫자를해야 합니다.");
        }
        isItDuplicated(bonusNumber, winnginNumbers);
    }
    private void isItDuplicated(Integer bonusNumer, List<Integer> winnginNumber) {
        if(winnginNumber.contains(bonusNumer)) {
            throw new IllegalArgumentException("[ERROR] 이미 입력한 당첨 번호와 중복됩니다.");
        }
    }

}
