package lotto.view.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputViewValidator {

    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer MINIMUM_RANGE = 1;
    private static final Integer MAXIMUM_RANGE = 45;
    private static final String STRING_EMPTY_ERROR_MESSAGE = "[ERROR] 입력은 빈 값이면 안됩니다.";
    private static final String TOTAL_AMOUNT_MUST_HAVE_THOUSAND_UNIT = "[ERROR] 총 구입 금액은 천 단위여야 합니다.";
    private static final String SHOULD_HAVE_SIX_NUMBERS= "[ERROR] 당첨 번호는 6개의 수여야 합니다.";
    private static final String NUMBER_INVALID_RANGE = "[ERROR] 당첨 번호는 1이상 45이하여야 합니다.";
    private static final String DUPLICATE_WINNER_NUMBER_EXISTS = "[ERROR] 각각의 당첨번호 간 중복되는 숫자가 존재해선 안됩니다.";
    private static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨번호와 중복되는 숫자가 아니어야 합니다.";
    private static final String PARSE_FAILURE_ERROR_MESSAGE = "[ERROR] 입력하는 수는 정수 형식만 가능합니다.";

    public void validateTotalAmount(String string) throws IllegalArgumentException{
        if (isStringEmpty(string)) throw new IllegalArgumentException(STRING_EMPTY_ERROR_MESSAGE);
        Long number = tryParseLong(string);
        if (isNotThousandUnit(number)) throw new IllegalArgumentException(TOTAL_AMOUNT_MUST_HAVE_THOUSAND_UNIT);
    }

    public void validateWinnerNumbers(String string) throws IllegalArgumentException{
        if (isStringEmpty(string)) throw new IllegalArgumentException(STRING_EMPTY_ERROR_MESSAGE);
        List<String> stringList = Arrays.asList(string.split(COMMA,-1));
        List<Integer> winnerNumberList = stringList.stream()
                .map(this::tryParseInt)
                .toList();
        if (winnerNumberList.size()!=6) throw new IllegalArgumentException(SHOULD_HAVE_SIX_NUMBERS);
        if (winnerNumberList.stream().anyMatch(this::isNumberInvalidRange)) throw new IllegalArgumentException(NUMBER_INVALID_RANGE);
        if (duplicateWinnerNumberExists(winnerNumberList)) throw new IllegalArgumentException(DUPLICATE_WINNER_NUMBER_EXISTS);
    }

    public void validateBonusNumber(String string, List<Integer> winnerNumberList) throws IllegalArgumentException{
        if (isStringEmpty(string)) throw new IllegalArgumentException(STRING_EMPTY_ERROR_MESSAGE);
        Integer bonusNumber = tryParseInt(string);
        if (isNumberInvalidRange(bonusNumber));
        if (isBonusNumberDuplicate(bonusNumber,winnerNumberList)) throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
    }

    private Boolean isStringEmpty(String string){
        if(string.equals(EMPTY_STRING)) return true;
        return false;
    }

    private Boolean isNotThousandUnit(Long number){
        if(number%LOTTO_PRICE != 0) return true;
        return false;
    }

    private Integer tryParseInt(String string) throws IllegalArgumentException{
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(PARSE_FAILURE_ERROR_MESSAGE);
        }
    }

    private Long tryParseLong(String string) throws IllegalArgumentException{
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(PARSE_FAILURE_ERROR_MESSAGE);
        }
    }

    public Boolean isNumberInvalidRange(Integer number){
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) return true;
        return false;
    }

    private Boolean duplicateWinnerNumberExists(List<Integer> winnerNumberList){
        List<Integer> distinctWinnerNumberList = winnerNumberList.stream()
                .distinct()
                .toList();
        if (winnerNumberList.size() != distinctWinnerNumberList.size()) return true;
        return false;
    }

    private Boolean isBonusNumberDuplicate(Integer bonusNumber, List<Integer> winnerNumberList){
        if (winnerNumberList.contains(bonusNumber)) return true;
        return false;
    }
}
