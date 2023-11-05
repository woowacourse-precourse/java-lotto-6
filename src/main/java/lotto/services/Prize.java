package lotto.services;

import static lotto.exception.ExceptionHandler.noLengthOfSix;
import static lotto.exception.ExceptionHandler.notBetween1And45;
import static lotto.exception.ExceptionHandler.numberInDuplicate;
import static lotto.utils.Utils.is1And45;
import static lotto.utils.Utils.stringToList;
import static lotto.utils.Utils.stringToSplit;

import java.util.Arrays;
import java.util.List;

public class Prize {

    public List<Integer> createPrizeNumber(String prize) {
        validatePrizeLength(prize);
        validatePrizeRange(prize);
        validatePrizeDuplicate(prize);

        return stringToList(prize);
    }

    private void validatePrizeRange(String prize) {
        String[] nums = stringToSplit(prize);
        boolean result = Arrays.stream(nums).allMatch(num -> is1And45(Integer.parseInt(num)));

        if (!result) {
            notBetween1And45();
        }
    }

    private void validatePrizeLength(String prize) {
        String[] nums = stringToSplit(prize);

        if (nums.length != 6) {
            noLengthOfSix();
        }
    }

    private void validatePrizeDuplicate(String prize) {
        List<Integer> nums = stringToList(prize);

        long distinctCount = nums.stream().distinct().count();

        if (distinctCount != nums.size()) {
            numberInDuplicate();
        }
    }
}
