package domain;

import exception.LottoException;

public class LottoTicket {

    public int lottoTicketService(String inputValue) {

        // 입력 값을 검증하고 구매한 티켓의 수를 계산

        return validateNumber(inputValue);

    }

    private int validateNumber(String inputValue) {
        try {
            int parseIntValue = Integer.parseInt(inputValue);
            if(parseIntValue<=0){
                // 입력 값이 정수가 아닌 경우 예외를 발생시킴
                throw new LottoException(LottoException.ERROR_NOT_A_NATURAL_NUMBER);
            }
            validateAmount(parseIntValue);
            return parseIntValue / 1000;
        } catch (NumberFormatException e) {
            throw new LottoException(LottoException.ERROR_INVALID_NUMBER_FORMAT);
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            // 금액이 1000원 단위가 아니라면 예외를 발생시킴
            throw new LottoException(LottoException.ERROR_INVALID_AMOUNT);
        }
    }
}
