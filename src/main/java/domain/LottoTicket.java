package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoExceptionMessages;

public class LottoTicket {

    public int lottoTicketService() {
        while (true) {
            String inputValue = Console.readLine();
            try {
                int parseIntValue = validateNumber(inputValue);
                validateAmount(parseIntValue);
                return parseIntValue / 1000;
            } catch (IllegalArgumentException e) {
                // 예외 발생 시 에러 메시지 출력
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateNumber(String inputValue) {
        try {
            int parseIntValue = Integer.parseInt(inputValue);
            if (parseIntValue <= 0) {
                throw new IllegalArgumentException(LottoExceptionMessages.NOT_A_NATURAL_NUMBER.getMessage());
            }
            return parseIntValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(LottoExceptionMessages.INVALID_AMOUNT.getMessage());
        }
    }
}
