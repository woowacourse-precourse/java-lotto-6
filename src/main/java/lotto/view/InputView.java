package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_NUMBER_ERROR_MESSAGE = "구매 금액에 숫자를 입력해야 합니다.";

    public int inputPurchaseMoney() {
        System.out.println(INPUT_PURCHASE_MONEY_MESSAGE);
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NUMBER_ERROR_MESSAGE);
        }
    }

    public List<Integer> inputWinLottoNumber() {
        System.out.println(INPUT_WIN_LOTTO_NUMBER_MESSAGE);
        try {
            String input = Console.readLine();
            String[] split = input.split(",");
            return Arrays.stream(split)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NUMBER_ERROR_MESSAGE);
        }
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_WIN_LOTTO_BONUS_NUMBER_MESSAGE);
        try{
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
