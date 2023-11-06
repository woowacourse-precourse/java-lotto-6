package lotto.manager;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputValidator;
import lotto.Lotto;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utility.StringUtil.*;

public class IOManager {

    InputValidator inputValidator = new InputValidator();

    public void printPayAmountInputGuide() {
        System.out.println(ENTER_PAY_AMOUNT.getMessage());
    }

    public int readPayAmount() {
        String inputPayAmount = Console.readLine().replaceAll("\\s", "");

        if (!inputValidator.isDigit(inputPayAmount)) {
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMOUNT_NOT_DIGIT.getMessage());
        }

        int payAmount = Integer.parseInt(inputPayAmount);

        if ( !inputValidator.isMultipleOfUnit(payAmount) ) {
            throw new IllegalArgumentException(PRINT_ERR_PAY_AMOUNT_INVALID_UNIT_INTERVER.getMessage());
        }

        return payAmount;
    }

    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.printf(PRINT_LOTTO_COUNT.getMessage(), lottoTicketCount);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWiningNumberInputGuide() {
        System.out.println(ENTER_WINNING_NUMBER.getMessage());
    }

    public List<Integer> readWinningNumber() {
        String[] inputWinningNumber = Console.readLine().replaceAll("\\s", "").split(",");
        List<Integer> winningNumber = new ArrayList<>();

        if (!inputValidator.isDigit(inputWinningNumber))
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_NOT_DIGIT.getMessage());

        for(String element: inputWinningNumber) {
            winningNumber.add(Integer.parseInt(element));
        }
        return winningNumber;
    }
}
