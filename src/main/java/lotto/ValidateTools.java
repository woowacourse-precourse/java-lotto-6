package lotto;

import static java.lang.Integer.parseInt;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateTools {
    public void validateSpace(String input){
        if (input.length() != input.replace(" ", "").length()){
            throw new IllegalArgumentException("[ERROR] 공백이 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public void validateOverOne(String input){
        if (input.split(",").length > 1){
            throw new IllegalArgumentException("[ERROR] 1개 이상이 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public void validatePoint(String input){
        if (input.contains(".")){
            throw new IllegalArgumentException("[ERROR] 소수점은 입력할 수 없습니다. 다시 입력해주세요");
        }
    }

    public void validateNumber(String input){
        try {
            parseInt(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
        }
    }

    public void validateDuplicateBonus(int bonus, List<Integer> winningNums){
        if (winningNums.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되었습니다. 다시 입력해주세요.");
        }
    }

    public void validate1to45(int num){
        if (num < 1 || num > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45사이 입니다. 다시 입력해주세요.");
        }
    }

    public void validateZeroLess(int num){
        if (num <= 0){
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요. 다시 입력해주세요.");
        }
    }

    public void validateDuplicateLottos(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요.");
        }
    }

    public void validate6Nums(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }

    public boolean validateDivided(int cost){
        if (cost%1000 > 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다. 다시 입력해주세요");
        }
        return true;
    }

}
