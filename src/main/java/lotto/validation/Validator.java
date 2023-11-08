package lotto.validation;

import lotto.constant.message.ErrorMessage;

import java.util.HashSet;

import static lotto.constant.SystemData.*;

public class Validator {
    /* 공통 */
    public static void checkLottoNumberArrayRange(int[] numbers) {
        for(int number : numbers){
            checkLottoNumberRange(number);
        }
    }

    public static void checkLottoNumberRange(int number) {
        if(number >= MIN_IN_LOTTO_NUMBER && number <= MAX_IN_LOTTO_NUMBER){
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
    }


    /* 로또 구입 금액 */
    public static void checkInputPriceUnitValidation(int inputPrice) {
        if (inputPrice % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT);
    }


    /* 당첨 번호 6자리 */
    public static void checkDuplicateWinningNumber(int[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int number : numbers){
            if(hashSet.contains(number)){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBER);
            }
            hashSet.add(number);
        }
    }

    public static void checkWinningNumberCount(int[] numbers) {
        if(numbers.length != NUMBER_OF_WINNING_NUMBER){
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_LENGTH);
        }
    }


    /* 보너스 번호 */
    public static void checkDuplicateBonusNumber(int bonusNumber, int[] winningNumbers) {
        for(int winningNumber : winningNumbers){
            if(bonusNumber == winningNumber){
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER);
            }
        }
    }
}
