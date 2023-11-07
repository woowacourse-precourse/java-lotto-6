package lotto.Controller;

import static java.lang.Integer.parseInt;
import static lotto.Constants.*;
import static lotto.ErrorMessages.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exceptable {


    public void validateSpace(String input){
        if (input.length() != input.replace(" ", "").length()){
            throw new IllegalArgumentException(VALIDATE_SPACE.getMessage());
        }
    }

    public void validateOverOne(String input){
        if (input.split(",").length > 1){
            throw new IllegalArgumentException(VALIDATE_OVER_ONE.getMessage());
        }
    }

    public void validatePoint(String input){
        if (input.contains(".")){
            throw new IllegalArgumentException(VALIDATE_POINT.getMessage());
        }
    }

    public void validateNumber(String input){
        try {
            parseInt(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(VALIDATE_NUMBER.getMessage());
        }
    }

    public void validateDuplicateBonus(int bonus, List<Integer> winningNums){
        if (winningNums.contains(bonus)){
            throw new IllegalArgumentException(VALIDATE_DUPLICATE_BONUS.getMessage());
        }
    }

    public void validate1to45(int num){
        if (num < START_INCLUSIVE.getNum() || num > END_INCLUSIVE.getNum()){
            throw new IllegalArgumentException(VALIDATE_1_TO_45.getMessage());
        }
    }

    public void validateZeroLess(int num){
        if (num <= 0){
            throw new IllegalArgumentException(VALIDATE_ZERO_LESS.getMessage());
        }
    }

    public void validateDuplicateLottos(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()){
            throw new IllegalArgumentException(VALIDATE_DUPLICATE_LOTTO.getMessage());
        }
    }

    public void validate6Nums(List<Integer> numbers){
        if (numbers.size() != LOTTO_NUMBER_COUNT.getNum()) {
            throw new IllegalArgumentException(VALIDATE_6_NUMS.getMessage());
        }
    }

    public boolean validateDivided(int cost){
        if (cost% LOTTO_PRICE.getNum() > 0){
            throw new IllegalArgumentException(VALIDATE_DIVIDED.getMessage());
        }
        return true;
    }

}
