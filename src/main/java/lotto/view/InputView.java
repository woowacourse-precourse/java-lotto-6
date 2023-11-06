package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Converter;

public class InputView {

    private enum InputMessage {
        INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
        INPUT_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    public static String inputPurchaseMoney() {
        System.out.println(InputMessage.INPUT_PURCHASE_MONEY.message);
        return Console.readLine();
    }

    public static List<Integer> inputWinningLottoNumber() {
        System.out.println(InputMessage.INPUT_WINNING_LOTTO_NUMBER.message);
        return Converter.splitWithComma(Console.readLine());
    }
}