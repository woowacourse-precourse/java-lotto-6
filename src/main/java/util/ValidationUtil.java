package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidationUtil {
    public int validPurchaseLottoAmount(String lottoPurchaseAmount){
        validPurchaseIntegerLottoAmount(lottoPurchaseAmount);
        return validPurchaseRemainLottoAmount(lottoPurchaseAmount);
    }
    public void validPurchaseIntegerLottoAmount(String lottoPurchaseAmount) {
        if (!lottoPurchaseAmount.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }
    public int validPurchaseRemainLottoAmount(String lottoPurchaseAmount){
        int validPurchaseAmount = Integer.parseInt(lottoPurchaseAmount);
        if(validPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return validPurchaseAmount;
    }

    public String[] validWinningNumber(String input){
        String[] validEachWinningNumber = input.split(",");
        validCountWinningNumber(validEachWinningNumber);
        validDuplicateWinningNumber(validEachWinningNumber);
        validRangeWinningNumber(validEachWinningNumber);
        return validEachWinningNumber;
    }

    public void validCountWinningNumber(String[] array){
        if(array == null || array.length != 6){
            throw new IllegalArgumentException();
        }
    }
    public void validDuplicateWinningNumber(String[] array){
        List<Integer> numbers = Arrays.stream(array)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public void validRangeWinningNumber(String[] array){
        if(!Arrays.stream(array).mapToInt(Integer::parseInt).noneMatch(this::isValidRangeWinningNumber)){
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidRangeWinningNumber(int number){
        return number < 1 || number > 45;
    }
}
