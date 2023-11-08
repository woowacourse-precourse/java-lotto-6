package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {

    private static final String ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String SHOW_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String ERROR_NEED_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    private static final String BLANK = "";

    public int askPurchaseMoney() {
        println(ASK_PURCHASE_MONEY);
        return toNumber(Console.readLine());
    }

    public void showLottoTickets(List<Lotto> lottoTickets) {
        printBlankLine();
        println(lottoTickets.size() + SHOW_PURCHASE_LOTTO_COUNT);
        for (Lotto lotto : lottoTickets) {
            println(lotto.toString());
        }
    }

    private int toNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NEED_NUMBER);
        }
    }

    private void printBlankLine() {
        println(BLANK);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
