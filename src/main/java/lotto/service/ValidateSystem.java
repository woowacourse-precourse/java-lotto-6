package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateSystem {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]: ";
    private static final String ERROR_MESSAGE_PAYMENT_ACCOUNT_ZERO = "로또를 구매하실려면 0원이상의 금액으로 입력해주세요.";
    private static final String ERROR_MESSAGE_PAYMENT_ACCOUNT = "1,000단위의 금액으로 입력해주세요.";
    private static final String ERROR_MESSAGE_NUMBERS_SIZE = "6개의 숫자를 입력해야합니다.";
    private static final String ERROR_MESSAGE_NUMBER_DUPLICATE = "중복된 숫자가 있습니다.";
    private static final String ERROR_MESSAGE_NUMBER_RANGE = "1~45사이의 숫자만 입력해주세요.";
    private static final String ERROR_MESSAGE_BONUS_NUMBER = "당첨번호와 중복됩니다.";


    public void validatePaymentAccount(int paymentAccount){

        if(paymentAccount==0){
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_PAYMENT_ACCOUNT_ZERO);
        }

        if (paymentAccount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_PAYMENT_ACCOUNT);
        }

    }

    public void validateLottoNumbers(List<Integer> winningNumbers){

        if(winningNumbers.size()!=6){
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_NUMBERS_SIZE);
        }

        Set<Integer> setNumbers = new HashSet<>(winningNumbers);
        if(setNumbers.size()!= winningNumbers.size()){
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_NUMBER_DUPLICATE);
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.intValue() < LOTTO_MIN_NUMBER ||
                    winningNumber.intValue() > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_NUMBER_RANGE);
            }
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_BONUS_NUMBER);
        }

    }

}
