package lotto.view;

import lotto.global.ResponseStatus;
import lotto.global.constant.LottoConstant;
import lotto.global.error.ErrorMessage;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidator {

    public static ResponseStatus purchasePriceCheck(int lottoPurchasePrice){
        try{
            if(lottoPurchasePrice < LottoConstant.LOTTO_PRICE || lottoPurchasePrice % LottoConstant.LOTTO_PRICE != 0){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PURCHASE_PRICE.getMessage());
            }
            return ResponseStatus.OK;
        }catch(IllegalArgumentException e ){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch (Error e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static ResponseStatus isInputValid(String userInput){
        try{
            if (userInput == null || userInput.equals(" ") || userInput.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
            }
            return ResponseStatus.OK;
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch (Error e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static ResponseStatus isInputDigit(String userInput){
        try{
            isInputValid(userInput);
            if(!Pattern.matches("^[1-9]*$",userInput)) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_NUMBER.getMessage());
            }
            return ResponseStatus.OK;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static ResponseStatus lottoLengthCheck(List<Integer> lottoNumbers){
        try{
            if(lottoNumbers.size() != LottoConstant.LOTTO_NUMBER_COUNT){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
            return ResponseStatus.OK;
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static <E> ResponseStatus lottoNumbersEmptyCheck(List<E> lottoNumbers){
        try{
            if(lottoNumbers.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_INVALID.getMessage());
            }
            return ResponseStatus.OK;
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch(Exception e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static <E> ResponseStatus lottoNumbersDuplicatedCheck(List<E> lottoNumbers){
        try{
            Set<E> uniqueNumbers = lottoNumbers.stream().collect(Collectors.toSet());
            if(uniqueNumbers.size() != lottoNumbers.size()){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATED.getMessage());
            }
            return ResponseStatus.OK;
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }

    public static ResponseStatus isLottoInRange(int number){
        try{
            if(number < LottoConstant.LOTTO_NUMBER_RANGE_START || number > LottoConstant.LOTTO_NUMBER_RANGE_END){
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
            }
            return ResponseStatus.OK;
        }catch(IllegalArgumentException e){
            e.printStackTrace();
            return ResponseStatus.BAD;
        }catch(Exception e){
            e.printStackTrace();
            return ResponseStatus.ERROR;
        }
    }
}
