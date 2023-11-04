package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoException;

public class LottoTicket {

    public int lottoTicketService() {
        // 사용자에게 로또 구입 금액을 입력하라고 요청
        System.out.println("로또 구입 금액을 입력해주세요:");
        String inputValue = Console.readLine();

        // 입력 값을 검증하고 구매한 티켓의 수를 계산

        return validateNumber(inputValue);

    }

    private int validateNumber(String inputValue) {
        try {
            int parseIntValue = Integer.parseInt(inputValue);
            validateAmount(parseIntValue);
            return parseIntValue / 1000;
        } catch (NumberFormatException e) {
            // 입력 값이 정수가 아닌 경우 예외를 발생시킴
            throw new LottoException(LottoException.validateNaturalNumber);
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            // 금액이 1000원 단위가 아니라면 예외를 발생시킴
            throw new LottoException(LottoException.checkAmountValidity);
        }
    }
}
