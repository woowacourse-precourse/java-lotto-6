package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.IssuedLottoTicketsDto;
import lotto.dto.LottoDto;

public class ConsoleView implements View {

    private static final String EXCEPTION_MESSAGE = "[ERROR] %s\n";
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO_ISSUED_MESSAGE = "%d개를 구매했습니다.\n";


    @Override
    public String getPurchaseAmount() {
        System.out.println();
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    @Override
    public String getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }

    @Override
    public void displayIssuedLottoTickets(IssuedLottoTicketsDto issuedLottoTickets) {
        System.out.println();
        System.out.printf(NUMBER_OF_LOTTO_ISSUED_MESSAGE, issuedLottoTickets.numberOfLottoIssued());
        for (LottoDto lotto :
                issuedLottoTickets.tickets()) {
            System.out.println(lotto.numbers());
        }
    }

    @Override
    public void displayException(String message) {
        System.out.println();
        System.out.printf(EXCEPTION_MESSAGE, message);
    }

}
