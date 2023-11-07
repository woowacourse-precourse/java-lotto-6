package lotto.exception;

import java.util.List;
import lotto.LottoConfig;

public class LottoException {

    private final LottoConfig lottoConfig = new LottoConfig();
    private static final int ZERO_PRICE = 0;
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String TICKET_ERROR_MESSAGE = "구입 금액이 잘못 되었습니다. 티켓 한장의 가격은 1000원입니다.";
    private static final String DIGIT_ERROR_MESSAGE = "는 숫자가 아닙니다. 숫자를 입력해 주세요.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 숫자 범위(1~45)를 벗어났습니다.";
    private static final String LENGTH_ERROR_MESSAGE = "입력이 잘못 되었습니다. 중복하지 않는 1~45까지의 숫자 6개를 입력해 주세요.";
    private static final String BONUS_ERROR_MESSAGE = "당첨 숫자와 중복됩니다. 다시 입력해 주세요.";


    public boolean purchaseAmountCheckMain(String purchaseAmount) {
        try {
            return purchaseAmountCheckSub(purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean purchaseAmountCheckSub(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if ((amount < lottoConfig.TICKET_PRICE) || ((amount % lottoConfig.TICKET_PRICE) != ZERO_PRICE)) {
            throw new IllegalArgumentException(ERROR_PREFIX + TICKET_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean numberCheck(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + userInput + DIGIT_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean lottoRangeCheckMain(int number) {
        try {
            return lottoRangeCheckSub(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean lottoRangeCheckSub(int number) {
        if ((number < lottoConfig.LOTTO_MIN_NUM) || (number > lottoConfig.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(ERROR_PREFIX + number + OUT_OF_RANGE_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean numberLengthCheckMain(List<Integer> winningNumbers) {
        try {
            return numberLengthCheckSub(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean numberLengthCheckSub(List<Integer> winningNumbers) {
        if (winningNumbers.size() != lottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + LENGTH_ERROR_MESSAGE);
        }
        return true;
    }

    public boolean duplicateBonusNumberCheckMain(List<Integer> winningNumber, int bonusNumber) {
        try {
            return duplicateBonusNumberCheckSub(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean duplicateBonusNumberCheckSub(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + BONUS_ERROR_MESSAGE);
        }
        return true;
    }
}
