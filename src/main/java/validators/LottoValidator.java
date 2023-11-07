package validators;

import constants.ErrorCodeConstant;
import constants.GameConstant;
import java.util.List;

public class LottoValidator {

    /** 사용자에 문자열 로또번호 입력 받기
     *
     * @return 공백 입력, 숫자/콤마 외의 문자가 있을 경우 예외 발생
     */
    public static boolean isVerifyInputLotto(String inputLotto){
        isBlankLottoNumbers(inputLotto);
        isNumberAndComma(inputLotto);
        isVerifyArrayLotto(inputLotto);

        return true;
    }

    private static void isVerifyArrayLotto(String inputLotto){
        inputLotto = inputLotto.trim();

        final String COMMA = ",";
        String[] lottoNumbers = inputLotto.split(COMMA);

        isNullLottoNumbers(lottoNumbers);
        for(String number : lottoNumbers){
            isBlankLottoNumbers(number);
        }
    }

    private static void isBlankLottoNumbers(String lottoNumbers){
        if(lottoNumbers.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
        }
    }

    private static void isNumberAndComma(String lottoNumber){
        final String NUMBER_AND_COMMA_REGEX = "^[0-9,]+$";

        if(!lottoNumber.matches(NUMBER_AND_COMMA_REGEX)) {
            throw new IllegalArgumentException(ErrorCodeConstant.NUMBER_AND_COMMA_VALIDATION_ERROR);
        }
    }

    private static void isNullLottoNumbers(String[] lottoNumbers){
        if(lottoNumbers == null || lottoNumbers.length == 0){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
        }
    }

    public static boolean isVerifyLotto(List<Integer> numbers){
        try{
            numbers.stream()
                    .forEach(number -> isBetweenLottoNumber(number));
        }catch (IllegalArgumentException iae){
            return false;
        }
        return true;
    }

    private static void isBetweenLottoNumber(int number){
        if (number < GameConstant.MIN_LOTTO_NUMBER || number > GameConstant.MAX_LOTTO_NUMBER)  {
            throw new IllegalArgumentException(ErrorCodeConstant.BETWEEN_LOTTO_NUMBER_ERROR);
        }
    }

}
