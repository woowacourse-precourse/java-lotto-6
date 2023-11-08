package lotto.validate;

import lotto.constant.Constant;
import lotto.errormessage.InputError;

import java.util.List;

public class InputValidate {
    public static void validateIsNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < 48 || number.charAt(i) > 57) {
                throw new IllegalArgumentException(InputError.INPUT_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    public static void validateIsDivideThousand(String number){
        int num = Integer.parseInt(number);
        if(num%1000!=0) throw new IllegalArgumentException(InputError.INPUT_NOT_DIVIDE_THOUSAND_ERROR_MESSAGE);
    }

    public static void validateIsNumberOrRest(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if ((number.charAt(i) < 48 || number.charAt(i) > 57) && !(number.charAt(i)==44)) {
                throw new IllegalArgumentException(InputError.INPUT_NOT_NUMBER_OR_REST_ERROR_MESSAGE);
            }
        }
    }

    public static void validateIsSizeCorrect(String number){
        String result[] = number.split(",");
        if(result.length!= Constant.LOTTO_TOTAL_NUMBERS){
            throw new IllegalArgumentException(InputError.INPUT_NOT_CORRECT_SIZE_ERROR_MESSAGE);
        }
    }

    public static void validateIsRestCorrect(String number){
        int restCount = (int)countChar(number,',');
        if(restCount!=Constant.LOTTO_TOTAL_NUMBERS-1){
            throw new IllegalArgumentException(InputError.INPUT_NOT_CORRECT_REST_ERROR_MESSAGE);
        }
    }

    public static void validateIsCorrectRange(String number){
        String result[] = number.split(",");
        for(String str:result){
            int val = Integer.parseInt(str);
            if(val<Constant.LOTTO_START_NUMBER || val>Constant.LOTTO_END_NUMBER){
                throw new IllegalArgumentException(InputError.INPUT_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    public static void validateDuplicateNumber(List<Integer> lottoNumbers, String number){
        for(int num:lottoNumbers){
            if(num==Integer.parseInt(number)) throw new IllegalArgumentException(InputError.INPUT_IS_DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }
}
