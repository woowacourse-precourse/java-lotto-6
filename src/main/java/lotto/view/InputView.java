package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int getInputMoney(){
        System.out.println(MONEY_INPUT_MESSAGE);
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> getLottoNums(){
        // 형식에 맞는지 validation 필요
        System.out.println(LOTTO_NUMBERS_INPUT_MESSAGE);
        String inputLottoNums = Console.readLine();
        return separateInputLottoNums(inputLottoNums);
    }

    public static int getBonusNum(){
        System.out.println(BONUS_INPUT_MESSAGE);
        String inputBonusNum = Console.readLine();
        return Integer.parseInt(inputBonusNum);
    }

    public static List<Integer> separateInputLottoNums(String inputLottoNums){
        return Arrays.stream(inputLottoNums.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
