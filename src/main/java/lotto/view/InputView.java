package lotto.view;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.MessageConstants.*;

public class InputView {

    private static List<Integer> lottoNumberList;

    public static String getMoneyAmount() {
        System.out.println(INPUT_MONEY_AMOUNT);
        return Console.readLine();
    }

    public static List<Integer> getLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        return numberList(Console.readLine());
    }

    public static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> numberList(String lottoNumber) {
        String[] split = lottoNumber.split(",");
        lottoNumberList = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            lottoNumberList.add(setAmountInt(split[i]));
        }
        return lottoNumberList;
    }

    private static int setAmountInt(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

}