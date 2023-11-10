package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoNumNotNumException;
import lotto.exception.LottoNumRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String getInputAmount(){
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static List<Integer> getLottoNums(){
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        return separateInputLottoNums(Console.readLine());
    }

    public static int getBonusNum(){
        System.out.println(BONUS_INPUT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> separateInputLottoNums(String inputLottoNums) {
        return Arrays.stream(inputLottoNums.split(","))
                .map(str -> {
                    try {
                        return Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        throw new LottoNumNotNumException();
                    }
                })
                .collect(Collectors.toList());
    }
}
