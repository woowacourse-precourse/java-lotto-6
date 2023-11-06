package lotto.io.views;

import java.util.List;
import lotto.collaboration.lottos.Lotto;
import lotto.io.Input;
import lotto.io.Output;

public class LottoGameView {

    public static final String ERROR_HEADER_MESSAGE = "[ERROR]";

    public int askPurchaseAmount() {
        while (true) {
            Output.consoleLine("구입금액을 입력해 주세요.");
            try {
                return Input.consoleNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    public void showPurchaseLottos(List<Lotto> purchaseLottos) {
        for (Lotto purchaseLotto : purchaseLottos) {
            Output.consoleLine(purchaseLotto);
        }
    }

    public List<Integer> askWinningNumbers() {
        Output.consoleLine("당첨 번호를 입력해 주세요");
        while (true) {
            try {
                List<Integer> numbers = Input.consoleNumbers(",");
                validate(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_HEADER_MESSAGE + e.getMessage());
            }
        }
    }

    private static void validate(List<Integer> numbers) {
        occurExceptionIfNotSix(numbers);
        occurExceptionIfDuplicated(numbers);
    }

    private static void occurExceptionIfNotSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 여섯자리 숫자입니다.");
        }
    }

    private static void occurExceptionIfDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

}
