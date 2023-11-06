package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력가능합니다.";
    private static List<Integer> lottoNumberList;

    public static String inputPlayerAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> inputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        return numberList(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String lottoNumber) {
        String[] split = lottoNumber.split(",");
        lottoNumberList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            lottoNumberList.add(inputToInt(split[i]));
        }
        return lottoNumberList;
    }

    private static int inputToInt(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

}
