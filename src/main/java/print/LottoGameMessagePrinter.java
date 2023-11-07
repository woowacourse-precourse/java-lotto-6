package print;

import java.util.List;
import lotto.Lotto;
import validate.Validator;

public abstract class LottoGameMessagePrinter {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void lottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void InputBuyLottoTicketMessage() {
        printMessage("구입금액을 입력해 주세요.");
    }

    public static void InputWinningNumber() {
        printMessage("당첨 번호를 입력해 주세요.");
    }
    public static void InputBonusNumber() {
        printMessage("보너스 번호를 입력해 주세요.");
    }
    public static void printResultMessage() {
        printMessage("당첨 통계");
    }
    public static void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            Validator.validate(lotto.getNumbers());
            lottoNumbers(lotto.getNumbers());
        }
    }
    public static void printPurchasedTickets(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
    }
}
