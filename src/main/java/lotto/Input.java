package lotto;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return readLine();
    }

    public static List<String> inputLottoNumber() {
        System.out.println(INPUT_LOTTO_MESSAGE);
        String input = readLine();
        return Arrays.asList(input.split(","));
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return readLine();
    }
}
