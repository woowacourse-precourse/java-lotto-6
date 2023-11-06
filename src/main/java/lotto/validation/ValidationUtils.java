package lotto.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValidationUtils {
    private static final String INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 됩니다.";

    public ValidationUtils() {}

    public boolean validateUserAmount(int money) {
        if (money / 1000 != 0 && money % 1000 == 0) {
            return true;
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(INCORRECT_THOUSANDS_FORMAT_ERROR_MESSAGE);
        }

        return false;
    }

    public boolean validateWinningNumber(String winnigNumber) {
        StringBuilder stringBuilder = new StringBuilder(winnigNumber);
        StringTokenizer stringTokenizer = new StringTokenizer(winnigNumber, ",");
        List<Integer> tempWinningNumber = new ArrayList<>();
        StringBuilder temp_err = new StringBuilder();
        try {
            //입력이 없는건 아닌지
            if (stringBuilder.isEmpty()) {
                temp_err.append("당첨 번호를 입력해 주세요.");
                throw new IllegalArgumentException();
            }
            //마지막에 콤마로끝나는지
            if (stringBuilder.substring(winnigNumber.length()-1).equals(",")) {
                temp_err.append("시작과 끝에는 쉼표를 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
            //시작이 콤마인지
            if (stringBuilder.substring(0, 1).equals(",")) {
                temp_err.append("시작과 끝에는 쉼표를 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
            //콤마가 연속 두개인지함
            for (int i = 0; i < stringBuilder.length() - 2; i++) {
                verifyDoubleComma(stringBuilder, i, temp_err);
            }
            //콤마옆에 공백이있는지 없는지
            for (int i = 1; i < stringBuilder.length() - 1; i++) {
                verifySpaceNextToComma(stringBuilder, i, temp_err);
            }

            //1~45사이인지
            //중복된 숫자가 있는지
            int token;
            while(stringTokenizer.hasMoreTokens()) {
                token = Integer.parseInt(stringTokenizer.nextToken());

                if (token < 1 || 45 < token) {
                    temp_err.append("1부터 45 사이의 정수만 입력가능 합니다.");
                    throw new IllegalArgumentException();
                }
                if (tempWinningNumber.contains(token)) {
                    temp_err.append("중복된 숫자는 입력할 수 없습니다.");
                    throw new IllegalArgumentException();
                }

                tempWinningNumber.add(token);
            }

            //숫자가 6개인지
            if (tempWinningNumber.size() != 6) {
                temp_err.append("당첨 번호는 총 6개를 입력해야 합니다");
                throw new IllegalArgumentException();
            }

            return true;
        } catch(IllegalArgumentException e) {
            System.out.println("[ERROR] " + temp_err);
        }

        return false;
    }

    private void verifySpaceNextToComma(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if(stringBuilder.substring(i, i + 1).equals(",")) {
            verifyIllegal(stringBuilder, i, temp_err);
        }
    }

    private void verifyIllegal(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if (stringBuilder.substring(i - 1, i).equals(",") || stringBuilder.substring(i +1, i +2).equals(" ")) {
            temp_err.append("쉼표옆에 공백을 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    private void verifyDoubleComma(StringBuilder stringBuilder, int i, StringBuilder temp_err) {
        if (stringBuilder.substring(i, i + 2) .equals(",,")) {
            temp_err.append("연속된 쉼표는 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }


}
