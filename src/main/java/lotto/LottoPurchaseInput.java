package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaseInput {
    static String lottoPurchaseAmount = "";

    static void inputLottoPurchaseAmount() {
        while (true) {
            lottoPurchaseAmount = Console.readLine();
            if (LottoPurchaseInput.validateInputNotZero(lottoPurchaseAmount)) {
                continue;
            }
            if (LottoPurchaseInput.validateInputNumbers(lottoPurchaseAmount)) {
                continue;
            }
            if (LottoPurchaseInput.validateUnit(lottoPurchaseAmount)) {
                continue;
            }
            break;
        }
    }

    static boolean validateInputNotZero(String inputNum) {
        try {
            if (inputNum.charAt(0) == '0') {
                throw new IllegalArgumentException();
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.DO_NOT_START_ZERO.getErrorMessage());
            return true;
        }
    }

    static boolean validateUnit(String inputNum) {
        try {
            if (Integer.parseInt(inputNum) % 1000 != 0) {
                throw new IllegalArgumentException();
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INPUT_1000_UNIT.getErrorMessage());
            return true;
        }
    }

    static boolean validateInputNumbers(String inputNum) {
        int index = 0;
        try {
            if (inputNum.charAt(index) < '0' || inputNum.charAt(index) > '9') {
                throw new IllegalArgumentException();
            }
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.RANGE_IN_1_TO_45.getErrorMessage());
            return true;
        }
    }
}


