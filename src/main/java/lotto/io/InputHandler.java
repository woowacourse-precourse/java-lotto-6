package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.ErrorMessages;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static int readInputNumber() {
        String amount = Console.readLine();
        return convertNumber(amount);
    }

    // magicNumbers가 Lotto 번호로 유효한지 파악하기 위해 magicNumbers를 이용하여 더미 Lotto를 만듦.
    public static List<Integer> readInputMagicNumbers() {
        String[] targetStrings = Console.readLine().split(",");
        List<Integer> magicNumbers = new ArrayList<>();
        for (String string : targetStrings) {
            magicNumbers.add(convertNumber(string.trim()));
        }
        Lotto convert_to_Lotto_for_check_validation_it_is_unused = new Lotto(magicNumbers);
        return magicNumbers;
    }

    private static int convertNumber(String inStream) {
        try {
            int convertedNum = Integer.parseInt(inStream);
            if (convertedNum > 0) {
                return convertedNum;
            }
            throw new IllegalArgumentException(ErrorMessages.ERR_INPUT_IS_NOT_NUM.getMessage());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERR_INPUT_IS_NOT_NUM.getMessage());
        }
    }


}
