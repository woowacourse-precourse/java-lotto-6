package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class View {

    private static final String COMMA = ",";
    private static final String BLANK = "";
    private static final String ASK_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String SHOW_PURCHASE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String ERROR_NEED_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    private static final String ERROR_INVALID_LOTTO_FORMAT = "[ERROR] 당첨 번호 6자를 %s로 구분하여 입력해 주세요.".formatted(COMMA);

    public int askPurchaseMoney() {
        println(ASK_PURCHASE_MONEY);
        return askNumber();
    }

    public List<Integer> askWinningNumbers() {
        println(ASK_WINNING_NUMBERS);
        return askNumbers();
    }

    public int askBonusNumber() {
        println("보너스 볼을 입력해 주세요.");
        return askNumber();
    }

    public void showLottoTickets(List<Lotto> lottoTickets) {
        printBlankLine();
        println(lottoTickets.size() + SHOW_PURCHASE_LOTTO_COUNT);
        for (Lotto lotto : lottoTickets) {
            println(lotto.toString());
        }
    }

    private int askNumber() {
        return toNumber(readLine(), ERROR_NEED_NUMBER);
    }

    private List<Integer> askNumbers() {
        String input = readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String numberCandidate : input.split(COMMA)) {
            numbers.add(toNumber(numberCandidate, ERROR_INVALID_LOTTO_FORMAT));
        }
        return numbers;
    }

    private int toNumber(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }
    }

    private void printBlankLine() {
        println(BLANK);
    }

    private String readLine() {
        return Console.readLine();
    }

    private void println(String message) {
        System.out.println(message);
    }
}
