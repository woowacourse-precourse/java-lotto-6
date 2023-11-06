package lotto.exception;


import java.util.*;
import java.util.stream.Collectors;

public final class Validator {
    public static void validatePurChaseAmount(String amount) {
        if(!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
        int amountInteger = Integer.parseInt(amount);
        if(amountInteger % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매금액을 다시 입력해주세요");
        }
        if(amountInteger < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상만 구매가능합니다.");
        }
    }

    public static void validateWinningNumber(String winningNum) {
        String[] numbers = winningNum.split(",");
        Set<Integer> duplicateSet = new HashSet<>();
        if(numbers.length > 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 입력 가능합니다.");
        }
        for(String num : numbers) {
            if(!num.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
            }
            int lottoNum = Integer.parseInt(num);
            if(lottoNum < 1 || lottoNum > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45까지의 번호를 입력해주세요.");
            }
            duplicateSet.add(lottoNum);
        }
        if(duplicateSet.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 불가능합니다.");
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if(!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
        if(Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45까지의 번호를 입력해주세요.");
        }
        if(winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 불가능합니다.");
        }
    }
}
