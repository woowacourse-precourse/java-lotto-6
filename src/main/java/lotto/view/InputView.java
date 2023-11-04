package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchasePrice;
import lotto.util.ExceptionMessage;
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
        try {
            System.out.println(Message.INPUT_MONEY.message);
            String input = Console.readLine();
            Integer convertInput = TypeConvertor.stringToInt(input);
            return PurchasePrice.of(convertInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }

    public LottoTicket getLottoTicket() {
        try {
            System.out.println(Message.PICK_LOTTO_TICKET_NUMBER.message);
            String input = Console.readLine();
            List<Integer> integers = TypeConvertor.stringToStringList(input);
            return new LottoTicket(Lotto.of(integers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoTicket();
        }
    }

    private enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        PICK_LOTTO_TICKET_NUMBER("당첨 번호를 입력해주세요.");

        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
