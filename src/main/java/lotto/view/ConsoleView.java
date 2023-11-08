package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import lotto.dto.IssuedLottoTicketsDto;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.dto.ResultItemDto;

public class ConsoleView implements View {

    private static final String EXCEPTION_MESSAGE = "[ERROR] %s\n";
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_OF_LOTTO_ISSUED_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String RESULT_ROI_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(" (#,##0원)");

    @Override
    public void displayException(String message) {
        System.out.println();
        System.out.printf(EXCEPTION_MESSAGE, message);
    }

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
    public void displayResult(ResultDto result) {
        System.out.println();
        for (ResultItemDto resultItem : result.resultItems()) {
            System.out.println(getResultItemMessage(resultItem));
        }
        System.out.printf(RESULT_ROI_MESSAGE, result.roi().toString());
    }

    private String getResultItemMessage(ResultItemDto resultItem) {
        StringBuilder message = new StringBuilder();
        message.append(resultItem.numberOfMatch()).append("개 일치");
        if (resultItem.isBonusMatch()) {
            message.append(", 보너스 볼 일치");
        }
        message.append(DECIMAL_FORMAT.format(resultItem.prizeMoney()));
        message.append(" - ");
        message.append(resultItem.count()).append("개");
        return message.toString();
    }

}
