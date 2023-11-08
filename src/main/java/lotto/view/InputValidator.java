package lotto.view;

import lotto.global.ResponseStatus;
import lotto.global.constant.LottoConstant;
import lotto.global.error.ErrorMessage;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    public static ResponseStatus purchasePriceCheck(int lottoPurchasePrice){
        try{
            if(lottoPurchasePrice < LottoConstant.LOTTO_PRICE || lottoPurchasePrice % LottoConstant.LOTTO_PRICE != 0){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PURCHASE_PRICE.getMessage());
            }
        }catch(IllegalArgumentException e ){
            e.printStackTrace();
        }
        return ResponseStatus.OK;
    }

    public static ResponseStatus isInputValid(String userInput){
        if (userInput == null || userInput.equals(" ") || userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
        }
        return ResponseStatus.OK;
    }

    public static ResponseStatus isInputDigit(String userInput){
        isInputValid(userInput);
        if(!Pattern.matches("^[1-9]*$",userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
        }
        return ResponseStatus.OK;
    }

    public static ResponseStatus lottoLengthCheck(List<Integer> lottoNumbers){
        if(lottoNumbers.size() > LottoConstant.LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
        return ResponseStatus.OK;
    }

    public static <E> ResponseStatus lottoNumbersEmptyCheck(List<E> lottoNumbers){
        if(lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
        }
        return ResponseStatus.OK;
    }

    public static ResponseStatus isLottoInRange(int number){
        if(number < LottoConstant.LOTTO_NUMBER_RANGE_START || number > LottoConstant.LOTTO_NUMBER_RANGE_END){
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
        return ResponseStatus.OK;
    }
}
