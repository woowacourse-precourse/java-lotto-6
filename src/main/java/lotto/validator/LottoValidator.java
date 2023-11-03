package lotto.validator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoValidator {
    private static final String INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다";
    private static final String AMOUNT_INPUT_CORRECT_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 1000원 단위로 입력할 수 있습니다.";
    private static final String AMOUNT_INPUT_EMPTY_EXCEPTION_MESSAGE = "[ERROR] 숫자를 입력해주세요";
    private static final String LOTTO_INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 숫자를 입력해주세요";
    private static final String LOTTO_INPUT_SIZE_EXCEPTION_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요";
    private static final String LOTTO_INPUT_RANGE_EXCEPTION_MESSAGE = "[ERROR] 1~45의 숫자를 입력해주세요";
    private static final String LOTTO_INPUT_DUPLICATION_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    private static final String BONUS_INPUT_DUPLICATION_LOTTO_EXCEPTION_MESSAGE = "[ERROR] 입력한 로또 번호와 보너스 번호는 겹칠 수 없습니다.";


    public static boolean amountInputValidator(String amount){
        return inputOnlyNumberValidator(amount) &&
                inputAmountRangeValidator(amount) &&
                inputAmountEmptyValidator(amount);
    }

    private static boolean inputAmountEmptyValidator(String amount){
        if( amount.length() ==0 ){
            throw new IllegalArgumentException(AMOUNT_INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }

    private static boolean inputAmountRangeValidator(String amount){
        if( Integer.parseInt(amount) % 1000 != 0  || amount.equals("0")){
            throw new IllegalArgumentException(AMOUNT_INPUT_CORRECT_AMOUNT_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean winningLottoValidator(String line){
        List<Integer> lotto = InputLottoOnlyNumberValidator(line);
        return inputLottoRangeValidator(lotto) && inputLottoDuplicationNumberValidator(lotto) && inputLottoSizeValidator(lotto);

    }

    private static boolean inputLottoRangeValidator(List<Integer> lotto){
        return lotto.stream().anyMatch(LottoValidator::lottoNumberRangeValidator);
    }

    private static boolean inputLottoDuplicationNumberValidator(List<Integer> lotto){
        int duplicationLottoSize = (int) lotto.stream().distinct().count();
        if(duplicationLottoSize != lotto.size()){
            throw new IllegalArgumentException(LOTTO_INPUT_DUPLICATION_NUMBER_EXCEPTION_MESSAGE);

        }
        return true;
    }
    private static boolean inputLottoSizeValidator(List<Integer> lotto){
        if(lotto.size() !=6){
            throw new IllegalArgumentException(LOTTO_INPUT_SIZE_EXCEPTION_MESSAGE);
        }
        return true;
    }
    private static List<Integer> InputLottoOnlyNumberValidator(String line){
        List<Integer> lotto = new ArrayList<Integer>();
        try {
            String[] splitStr = line.split(",");
            Arrays.stream(splitStr).forEach(
                    l -> lotto.add(Integer.parseInt(l))
            );
            return lotto;
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE);
        }
    }
    public static boolean inputWinningBonusValidator(List<Integer> lotto, String line){
        return inputOnlyNumberValidator(line) && lottoNumberRangeValidator(Integer.parseInt(line)) &&inputWinningBonusDuplicationLottoValidator(lotto, Integer.parseInt(line));
    }

    private static boolean inputOnlyNumberValidator(String line){
        try{
            Integer.parseInt(line);
            return true;
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean lottoNumberRangeValidator(int lottoNumber){
        if( lottoNumber <=0 || lottoNumber >=46  ){
            throw new IllegalArgumentException(LOTTO_INPUT_RANGE_EXCEPTION_MESSAGE);
        }
        return true;
    }


    private static boolean inputWinningBonusDuplicationLottoValidator(List<Integer> lotto, int bonus){
        boolean duplicationBonus = lotto.stream().anyMatch(l -> l==bonus);
        if(duplicationBonus){
            throw new IllegalArgumentException(BONUS_INPUT_DUPLICATION_LOTTO_EXCEPTION_MESSAGE);
        }
        return true;
    }


}
