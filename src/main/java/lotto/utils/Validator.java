package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    private static final String INVALID_OUT_OF_RANGE = "[ERROR] 각 로또 번호는 1과 45 사이의 값이어야 합니다.";
    private static final String INVALID_LOTTO_COUNT = "[ERROR] 로또 번호 개수가 6개가 아닙니다.";
    private static final String NO_INPUT_VALUE = "[ERROR] 입력된 값이 없습니다 확인해주세요";
    private static final String DUPLICATE_VALUE = "[ERROR] 당첨 번호에 중복된 번호가 존재합니다.";

    private static final String NOT_INPUT_FORM = "[ERROR] 입력 형식에 올바르게 입력되지 않았습니다.";


    public static void checkAmount(Integer purchaseAmount) throws IllegalArgumentException{
        if((purchaseAmount % 1000) != 0 || purchaseAmount <= 0){
            throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력 해주세요");
        }
    }

    public static void checkInputForm(String purchaseAmount) throws IllegalArgumentException {
        if (!purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_INPUT_FORM);
        }
    }

    public static String checkNullValue(String inputValue) throws IllegalArgumentException{
        if(inputValue.equals("")){
            throw new IllegalArgumentException(NO_INPUT_VALUE);
        }
        return inputValue;
    }


    public static void checkWinningNumber(List<Integer> winningNumber) throws IllegalArgumentException{
        checkLottoNumberSize(winningNumber);
        checkLottoNumberRange(winningNumber);
        checkLottoNumberDuplicate(winningNumber);
    }

    public static void checkPublishLottoNumber(List<Integer> lottoNumbers) throws IllegalArgumentException{
        checkLottoNumberSize(lottoNumbers);
        checkLottoNumberDuplicate(lottoNumbers);
    }

    public static void checkBonusNumber(List<Integer> winningNumber, Integer bonusNumber) throws IllegalArgumentException{
        checkLottoNumberRange(bonusNumber);
        checkLottoNumberDuplicate(winningNumber, bonusNumber);
    }


    private static void checkLottoNumberSize(List<Integer> lottoNumbers) throws IllegalArgumentException{
        if(lottoNumbers.size() != 6){
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT);
        }
    }

    private static void checkLottoNumberRange(List<Integer> lottoNumber) throws IllegalArgumentException{
        for(Integer number : lottoNumber){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException(INVALID_OUT_OF_RANGE);
            }
        }
    }

    private static void checkLottoNumberRange(Integer lottoNumber) throws IllegalArgumentException{
        if(lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE);
        }
    }



    private static void checkLottoNumberDuplicate(List<Integer> lottoNumber) throws IllegalArgumentException{
        Long lottoNumberCount = lottoNumber.stream().distinct().count();
        if(lottoNumberCount != lottoNumber.size()){
            throw new IllegalArgumentException(DUPLICATE_VALUE);
        }
    }

    public static void checkWinningNumberForm(String input) throws IllegalArgumentException {
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int checkNumber = Integer.parseInt(part.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_INPUT_FORM);
            }
        }
    }

    public static void checkBonusNumberForm(String input) throws IllegalArgumentException {
        if (!input.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE);
        }
    }

    private static void checkLottoNumberDuplicate(List<Integer> winningNumber, Integer bonusNumber) throws  IllegalArgumentException{
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_VALUE);
        }
    }
}
