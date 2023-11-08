package lotto.domain;

import lotto.application.IOService;

import java.util.List;

public class WinningNumber {
    private List<Integer> prizeNumbers;
    private int bonusNumber;
    public WinningNumber(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static boolean validatePrizeNumber(String prizeNumbers) {
        try {
            validateCnt(prizeNumbers);
            validateAllInteger(prizeNumbers);
            validateAllRange(prizeNumbers);
            validateAllDuplicate(prizeNumbers);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private static void validateCnt(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        if (split.length != 6) {
            IOService.printErrorPrizeNumberCnt();
            throw new IllegalArgumentException();
        }
    }
    private static void validateAllInteger(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        try {
            for (String s : split)
                Integer.parseInt(s);
        } catch (NumberFormatException e) {
            IOService.printPrizeNumberInteger();
            throw new IllegalArgumentException();
        }
    }
    private static void validateAllRange(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        for (String s : split) {
            int number = Integer.parseInt(s);

            if (number < 1 || number > 45) {
                IOService.printErrorPrizeNumberRange();
                throw new IllegalArgumentException();
            }
        }
    }


    private static void validateAllDuplicate(String prizeNumbers) {
        String[] split = prizeNumbers.split(",");

        for (int i = 0; i < split.length; ++i) {
            if (isDuplicated(split, i)) {
                IOService.printErrorPrizeNumberDuplicate();
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isDuplicated(String[] arr, int index) {
        String target = arr[index];

        for (int i = 0; i < index; ++i) {
            if (arr[i].equals(target))
                return true;
        }

        return false;
    }

    public static boolean validateBonusNumber(List<Integer> prizeNumbers, String bonusNumber){
        try {
            validateBonusNumberCnt(bonusNumber);
            validateBonusNumberInteger(bonusNumber);
            validateBonusNumberRange(bonusNumber);
            validateBonusNumberDuplicated(prizeNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private static void validateBonusNumberCnt(String bonusNumber) {
        String[] split = bonusNumber.split(",");

        if (split.length != 1) {
            IOService.printErrorBonusNumberCnt();
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusNumberInteger(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            IOService.printBonusNumberInteger();
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusNumberRange(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);

        if (number < 1 || number > 45) {
            IOService.printBonusNumberRange();
            throw new IllegalArgumentException();
        }
    }
    private static void validateBonusNumberDuplicated(List<Integer> prizeNumbers, String bonusNumber) {
        int target = Integer.parseInt(bonusNumber);

        for (Integer prizeNumber : prizeNumbers) {
            if(prizeNumber == target){
                IOService.printErrorBonusNumberDuplicate();
                throw new IllegalArgumentException();
            }
        }
    }
}
