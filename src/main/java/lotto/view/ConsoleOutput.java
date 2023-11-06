package lotto.view;

import static lotto.view.constants.ConstantMessage.ALARM_HOW_MANY_BUY_LOTTO;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_LOTTO_NUMBERS;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.constants.ConstantMessage;

public class ConsoleOutput {
    private static final String DELIMITER = ", ";

    public static void askLottoAmount() {
        printConstantMessage(REQUEST_INPUT_PRICE);
    }

    public static void askLottoBonusNumber() {
        printConstantMessage(REQUEST_INPUT_BONUS_NUMBER);
    }

    public static void askWinningLottoNumbers() {
        printConstantMessage(REQUEST_INPUT_LOTTO_NUMBERS);
    }

    public static void printLottoTickets(LottoTicket lottoTicket) {
        Integer numberOfLotto = lottoTicket.getNumberOfLottos();
        printLottoTickets(numberOfLotto, ALARM_HOW_MANY_BUY_LOTTO);
        for (Lotto lotto : lottoTicket.getLottos()) {
            printLottoNumbers(lotto);
        }
    }

    private static void printConstantMessage(ConstantMessage message) {
        System.out.println(message.getMessage());
    }

    private static void printLottoTickets(Integer numberOfLotto, ConstantMessage message) {
        System.out.println(numberOfLotto + message.getMessage());
    }

    private static void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers.toString());
    }
}
