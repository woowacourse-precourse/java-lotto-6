package validators;

import constants.ErrorCodeConstant;
import constants.GameConstant;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {

    /** 사용자에 문자열 로또번호 입력 받기
     *
     * @return 공백 입력, 숫자/콤마 외의 문자가 있을 경우 예외 발생
     */
    public static void verifyInputLotto(String inputLotto){
        CommonValidator.isBlank(inputLotto);
        isNumberAndComma(inputLotto);
        isVerifyArrayLotto(inputLotto);
    }

    private static void isVerifyArrayLotto(String inputLotto){
        inputLotto = inputLotto.trim();

        final String COMMA = ",";
        String[] lottoNumbers = inputLotto.split(COMMA);

        isNullLottoNumbers(lottoNumbers);
        for(String number : lottoNumbers){
            CommonValidator.isBlank(number);
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


    public static void verifyLotto(List<Integer> numbers){
        isLottoNumber6Length(numbers);
        numbers.stream()
                .forEach(number -> isBetweenLottoNumber(number));
        isDuplicatesLottoNumber(numbers);
    }

    private static void isLottoNumber6Length(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCodeConstant.DEFAULT_LOTTO_NUMBER_LENGTH_ERROR);
        }
    }

    private static void isBetweenLottoNumber(int number){
        if (number < GameConstant.MIN_LOTTO_NUMBER || number > GameConstant.MAX_LOTTO_NUMBER)  {
            throw new IllegalArgumentException(ErrorCodeConstant.BETWEEN_LOTTO_NUMBER_ERROR);
        }
    }

    private static void isDuplicatesLottoNumber(List<Integer> numbers){
        if (isDuplicatesNumber(numbers)) {
            throw new IllegalArgumentException(ErrorCodeConstant.DUPLICATES_LOTTO_NUMBER_ERROR);
        }
    }

    private static boolean isDuplicatesNumber(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctNumbers.size() < numbers.size();
    }


    public static void verifyBonusLotto(String inputBonusLotto, List<Integer> lottoNumber){
        CommonValidator.isBlank(inputBonusLotto);
        CommonValidator.isOnlyNumber(inputBonusLotto);

        int bonusLotto = Integer.parseInt(inputBonusLotto);
        isBetweenLottoNumber(bonusLotto);
        isContainsLottoNumber(bonusLotto, lottoNumber);
    }

    private static void isContainsLottoNumber(int bonusLotto, List<Integer> lottoNumber){
        if (lottoNumber.contains(bonusLotto)) {
            throw new IllegalArgumentException(ErrorCodeConstant.DUPLICATES_LOTTO_NUMBER_ERROR);
        }
    }

}
