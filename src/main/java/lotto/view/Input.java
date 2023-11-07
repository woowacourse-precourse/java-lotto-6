package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private static final String ERROR_ONLY_NUMBER = "하나의 숫자만 입력 가능합니다.";
    private static final String MESSAGE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_MAIN_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS_LOTTO = "보너스 번호를 입력해 주세요.";

    public int getPurchaseAmount() {
        System.out.println(MESSAGE_INPUT_AMOUNT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

    public List<Integer> getMainLottoNumber() {
        Output.printSpace();
        System.out.println(MESSAGE_INPUT_MAIN_LOTTO);
        String answer = Console.readLine();
        try {
            return Arrays.stream(answer.split(","))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

    public int getBonusNumber() {
        Output.printSpace();
        System.out.println(MESSAGE_INPUT_BONUS_LOTTO);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

}
