package lotto.validation;

import lotto.model.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValidationUtils {
    private static final int PRICE_LOTTO = 1000;
    private static final String COMMA = ",";
    private static final String DOUBLE_COMMA = ",,";
    private static final String INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 됩니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자를 입력해야 합니다.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INVALID_COMMA_AT_START_END = "시작과 끝에는 쉼표를 입력할 수 없습니다.";
    private static final String RANGE_LIMIT = "1부터 45 사이의 정수만 입력가능 합니다.";
    private static final String NO_DUPLICATE_NUMBERS = "중복된 숫자는 입력할 수 없습니다.";
    private static final String SIX_NUMBERS_REQUIRED = "당첨 번호는 총 6개를 입력해야 합니다";
    private static final String NO_SPACE_NEXT_TO_COMMA = "쉼표옆에 공백을 입력할 수 없습니다.";
    private static final String NO_CONSECUTIVE_COMMAS = "연속된 쉼표는 입력할 수 없습니다.";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public ValidationUtils() {}

    public boolean validateUserAmount(String userInput) {
        int userAmount;

        try {
            userAmount = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(NOT_NUMBER_ERROR_MESSAGE);
            return false;
        }

        if (userAmount / PRICE_LOTTO != 0 && userAmount % PRICE_LOTTO == 0) {
            return true;
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE);
        }

        return false;
    }

    public boolean validateWinningNumber(String winningNumber) {
        StringBuilder stringBuilder = new StringBuilder(winningNumber);
        StringTokenizer stringTokenizer = new StringTokenizer(winningNumber, COMMA);
        List<Integer> tempWinningNumber = new ArrayList<>();
        StringBuilder errorMessage = new StringBuilder();

        try {
            //입력이 없는건 아닌지
            if (stringBuilder.isEmpty()) {
                errorMessage.append(INPUT_WINNING_NUMBER);
                throw new IllegalArgumentException();
            }
            //마지막에 콤마로끝나는지
            if (stringBuilder.substring(winningNumber.length()-1).equals(COMMA)) {
                errorMessage.append(INVALID_COMMA_AT_START_END);
                throw new IllegalArgumentException();
            }
            //시작이 콤마인지
            if (stringBuilder.substring(0, 1).equals(COMMA)) {
                errorMessage.append(INVALID_COMMA_AT_START_END);
                throw new IllegalArgumentException();
            }
            //콤마가 연속 두개인지함
            for (int i = 0; i < stringBuilder.length() - 2; i++) {
                validateDoubleComma(stringBuilder, i, errorMessage);
            }
            //콤마옆에 공백이있는지 없는지
            for (int i = 1; i < stringBuilder.length() - 1; i++) {
                validateSpaceNextToComma(stringBuilder, i, errorMessage);
            }

            //1~45사이인지
            //중복된 숫자가 있는지
            int token;
            while(stringTokenizer.hasMoreTokens()) {
                token = Integer.parseInt(stringTokenizer.nextToken());

                if (token < 1 || 45 < token) {
                    errorMessage.append(RANGE_LIMIT);
                    throw new IllegalArgumentException();
                }

                if (tempWinningNumber.contains(token)) {
                    errorMessage.append(NO_DUPLICATE_NUMBERS);
                    throw new IllegalArgumentException();
                }

                tempWinningNumber.add(token);
            }

            //숫자가 6개인지
            if (tempWinningNumber.size() != 6) {
                errorMessage.append(SIX_NUMBERS_REQUIRED);
                throw new IllegalArgumentException();
            }

            return true;
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + errorMessage);
        }

        return false;
    }

    private void validateSpaceNextToComma(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if(stringBuilder.substring(i, i + 1).equals(COMMA)) {
            validateIllegal(stringBuilder, i, temp_err);
        }
    }

    private void validateIllegal(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if (stringBuilder.substring(i - 1, i).equals(COMMA) || stringBuilder.substring(i +1, i +2).equals(" ")) {
            temp_err.append(NO_SPACE_NEXT_TO_COMMA);
            throw new IllegalArgumentException();
        }
    }

    private void validateDoubleComma(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if (stringBuilder.substring(i, i + 2) .equals(DOUBLE_COMMA)) {
            temp_err.append(NO_CONSECUTIVE_COMMAS);
            throw new IllegalArgumentException();
        }
    }

    public boolean validateBonusNumber(WinningNumber winningNumber, String bonusNumber) {
        String errorMessage = "";

        try {
            int number = Integer.parseInt(bonusNumber);

            if (number < 1 || 45 < number) {
                errorMessage += RANGE_LIMIT;
                throw new IllegalArgumentException();
            }

            if (winningNumber.contains(number)) {
                errorMessage += NO_DUPLICATE_NUMBERS;
                throw new IllegalArgumentException();
            }

            return true;
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + errorMessage);
        }

        return false;
    }
}
