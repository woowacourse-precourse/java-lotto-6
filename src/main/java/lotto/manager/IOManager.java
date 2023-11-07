package lotto.manager;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputValidator;
import lotto.Lotto;
import lotto.Statistics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.utility.StringUtil.*;

public class IOManager {

    InputValidator inputValidator = new InputValidator();

    public void printPayAmountInputGuide() {
        System.out.println(ENTER_PAY_AMOUNT.getMessage());
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

    public void printWinningBonusNumberInputGuide() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }

    public void printWinningStatisticsGuide() {
        System.out.println(PRINT_WINNING_STATISTICS_PHRASES.getMessage());
    }

    public void printWinningStatistics() {
        Statistics statistics = Statistics.getInstance();

        Map<Integer, Integer> winningNumberMatchCount = statistics.getWinningNumberMatchCount();

        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "3개 일치", "5,000", winningNumberMatchCount.get(3));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "4개 일치", "50,000", winningNumberMatchCount.get(4));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "5개 일치", "1,500,000", winningNumberMatchCount.get(5));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "5개 일치, 보너스 볼 일치", "30,000,000", winningNumberMatchCount.get(51));
        System.out.printf(PRINT_WINNING_DETAILS.getMessage(), "6개 일치", "2,000,000,000", winningNumberMatchCount.get(6));

    }

    public void printProfit(double profit) {
        System.out.printf(PRINT_PROFIT.getMessage(), profit);
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

    public List<Integer> readWinningNumber() {
        String[] inputWinningNumber = Console.readLine().replaceAll("\\s", "").split(",");
        List<Integer> winningNumber = new ArrayList<>();

        if (!inputValidator.isDigit(inputWinningNumber))
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_NOT_DIGIT.getMessage());

        for(String element: inputWinningNumber) {
            winningNumber.add(Integer.parseInt(element));
        }

        if (!inputValidator.isValidNumberRange(winningNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());
        }

        if (!inputValidator.isVailidWinningNumberCount(winningNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_INVALID_COUNT.getMessage());
        }

        if (!inputValidator.hasDuplicates(winningNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_WINNING_NUMBER_DUPLICATE.getMessage());
        }
        return winningNumber;
    }

    public int readWinningBonusNumber() {
        String inputBonusNumber = Console.readLine();

        if (!inputValidator.isDigit(inputBonusNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_NOT_DIGIT.getMessage());
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);

        if (!inputValidator.isValidNumberRange(bonusNumber)) {
            throw new IllegalArgumentException(PRINT_ERR_NUMBER_INVALID_RANGE.getMessage());
        }

        return bonusNumber;

    }
}
