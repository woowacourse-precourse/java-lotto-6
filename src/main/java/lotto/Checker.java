package lotto;

import java.util.List;
import java.util.HashSet;


import java.util.Arrays;
import java.util.stream.Collectors;
public class Checker {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_LENGTH = 6;
	
    public static int checkPayment(String str) {
        try {
            int payment = Integer.parseInt(str);
            if (payment <= 0 || payment % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " Invalid payment amount.");
            }
            return payment / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Payment must be a number.");
        }
    }
    public static int checkBonusInput(List<Integer> list, String str) {
        try {
            int bonusNumber = Integer.parseInt(str);
            if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " Bonus number must be within the valid range.");
            }
            if (list.contains(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + " Bonus number must not be one of the winning numbers.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Bonus number must be a number.");
        }
    }

    public static List<Integer> checkWinningInput(String str) {
        List<Integer> intObj = parseIntList(str);
        validateLottoNumbers(intObj);
        return intObj;
    }
    private static List<Integer> parseIntList(String str) {
        try {
            return Arrays.stream(str.split(","))
                         .map(String::trim)
                         .map(Integer::parseInt)
                         .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " All entries must be numbers.");
        }
    }
    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Must enter exactly six numbers.");
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Duplicate numbers are not allowed.");
        }
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " Numbers must be within the valid range.");
        }
    }
}
