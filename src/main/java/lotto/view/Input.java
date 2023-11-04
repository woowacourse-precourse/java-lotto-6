package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String MESSAGE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_MAIN_LOTTO = "당첨 범호를 입력해 주세요.";

    public int getPurchaseAmount() {
        System.out.println(MESSAGE_INPUT_AMOUNT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public List<Integer> getMainLottoNumber() {
        System.out.println(MESSAGE_INPUT_MAIN_LOTTO);
        String answer = Console.readLine();
        try {
            return Arrays.stream(answer.split(","))
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");

        }
    }

    //public int getBonusNumber(){

    //}


}
