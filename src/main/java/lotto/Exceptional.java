package lotto;

import static PrintEnums.ErrorMessages.*;
import static PrintEnums.MagicNumbers.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

//V모델 입출력에서 검증 v1
//도메인에서 검증 v2


public class Exceptional {

    public static boolean checkUserCashExceptional(String userCash) {
        try {
            if (userCash.matches("^[\\D]*$")) {
                throw new IllegalArgumentException("숫자만 입력 에러");
            }
            if (Integer.parseInt(userCash) % 1000 != 0) {
                throw new IllegalStateException("1000나누기 입력 에러");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_OUTOFNUMBER.getErrorMessage());
            return true;
        } catch (IllegalStateException e){
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_THOUSAND.getErrorMessage());
            return true;
        }
        return false;
    }

    public static boolean numbersLengthExceptional(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_OUTOFLENGTH.getErrorMessage());
            return true;
        }
        return false;
    }

    public static boolean inRangeNumberExceptional(int numberInside) {
        try {
            if (numberInside < CHECK_NUMBER_ONE.getMagicNumber()) {
                throw new IllegalArgumentException();
            }
            if (CHECK_NUMBER_FOURTYFIVE.getMagicNumber() < numberInside) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_OUTOFRANGE.getErrorMessage());
            return true;
        }
        return false;
    }
    public static Boolean inRangeBonusNumberExceptional(List<Integer> numbersCopy, int numberInside) {
        try {

            if (numberInside < CHECK_NUMBER_ONE.getMagicNumber()) {
                throw new IllegalArgumentException();
            }
            if (CHECK_NUMBER_FOURTYFIVE.getMagicNumber() < numberInside) {
                throw new IllegalArgumentException();
            }
            if (numbersCopy.contains(numberInside)) {
                throw new IllegalStateException();
            }
            return false;
        }catch (IllegalArgumentException e){
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_OUTOFRANGE.getErrorMessage());
            return true;
        }catch (IllegalStateException e){
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_OUTOFTYPE.getErrorMessage());
            return true;
        }

    }

}




