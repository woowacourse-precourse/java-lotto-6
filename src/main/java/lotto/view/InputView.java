package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.util.TypeConvertor;

import java.util.List;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public PurchasePrice getMoney() {
        System.out.println(Message.INPUT_MONEY.message);
        String input = Console.readLine();
        Long convertInput = TypeConvertor.stringToLong(input);
        return PurchasePrice.of(convertInput);
    }

    public Lotto getWinningNumbers() {
        System.out.println(Message.PICK_TICKET_NUMBER.message);
        String input = Console.readLine();
        List<Integer> integers = TypeConvertor.stringToStringList(input);
        return Lotto.of(integers);
    }

    public BonusNumber getBonusNumber() {
        System.out.println(Message.PICK_TICKET_BONUS_NUMBER.message);
        String input = Console.readLine();
        Integer convertInput = TypeConvertor.stringToInt(input);
        return BonusNumber.of(convertInput);
    }

    private enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        PICK_TICKET_NUMBER("당첨 번호를 입력해주세요."),
        PICK_TICKET_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
