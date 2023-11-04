package lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String REQUEST_INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public void printRequestInputBuyMoney() {
        System.out.println(REQUEST_INPUT_BUY_MONEY_MESSAGE);
    }

    public void printLottoTicket(int buyTicket) {
        printEmptyLine();
        System.out.println(buyTicket + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumberStore) {
        for (List<Integer> lottoNumber : lottoNumberStore) {
            Collections.sort(lottoNumber);
            System.out.println(lottoNumber);
        }
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
