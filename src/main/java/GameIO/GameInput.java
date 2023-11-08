package GameIO;

import static PrintEnums.ErrorMessages.OUTPUT_ERROR;
import static PrintEnums.ErrorMessages.OUTPUT_ERROR_THOUSAND;
import static lotto.Exceptional.checkUserCashExceptional;
import static lotto.Exceptional.inRangeBonusNumberExceptional;
import static lotto.Exceptional.inRangeNumberExceptional;
import static lotto.Exceptional.numbersLengthExceptional;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameInput {


    private static boolean validateUserCash = true;

    public static int getUserCash() {
        int userCashCopy=0;
        String userCash = "";
        while (validateUserCash) {
//            System.out.println(userCash);
            userCash = Console.readLine();
//            System.out.println(userCash);
            validateUserCash = checkUserCashExceptional(userCash);
//            System.out.println(validateUserCash);
        }

        return Integer.parseInt(userCash);
        // gameTicket.setBonusNumber(userCashCopy);
    }

    //private static final String REGEXP_PATTERN_NUMBER = "^[\\d]";


    public static List<Integer> setupLottoNumbers() {
        List<Integer> numbersCopy = null;
        lottoNumbersValidate(numbersCopy);
        return numbers;

        // numbers 리스트 받았음 확인필요 넘버스 카피본 있음
    }


    public static int setupLottoBonusNumbers(List<Integer> numbers) {

        return lottoBonusValidate(numbers);
    }




//    public static int userCashValidate() {
//
//        return
//    }


    private static boolean validateLottoNumbers = true;
    private static List<Integer> numbers;

    public static void lottoNumbersValidate(List<Integer> numbersCopy) {
        while (validateLottoNumbers) {
            String UserHopeLottoNumbers = Console.readLine();
            numbersCopy = splitUserNumbers(UserHopeLottoNumbers);
            validateLottoNumbers = validateNumbersLength(numbersCopy);
            numbers = numbersCopy;
            for (int i = 0; i < numbersCopy.size(); i++) {
                validateLottoNumbers =validateLottoNumbers(numbersCopy.get(i));
            }

        }

    }
    private static boolean validateLottoNumbers(int numberInside) {
        // 포장필요 magicnumbers
        return inRangeNumberExceptional(numberInside);
        //익셉셔널쪽으로 날리기
    }

    private static boolean validateNumbersLength(List<Integer> numbers) {
        return numbersLengthExceptional(numbers);
    }

    private static List<Integer> splitUserNumbers(String Numbers) {
        List<String> ArgNumbers = Arrays.stream(Numbers.split(",")).toList();
        //System.out.println(ArgNumbers);
        List<Integer> numbersCopy = validateNumbersArgument(ArgNumbers);
        return numbersCopy;
    }

    private static List<Integer> validateNumbersArgument(List<String> Numbers) {
        List<Integer> NumbersCopy = new ArrayList<Integer>();
        try {
            for (int i = 0; i < Numbers.size(); i++) {
                NumbersCopy.add(Integer.parseInt(Numbers.get(i)
                        .replaceAll("[\\[\\]]", "")));
                //정규식 제거

            }
        } catch (IllegalArgumentException e) {
            System.out.println(OUTPUT_ERROR.getErrorMessage() + OUTPUT_ERROR_THOUSAND.getErrorMessage());
        }
        return NumbersCopy;
    }


    private static boolean validateBonusNumber = true;

    private static int lottoBonusValidate(List<Integer> numbers) {
        int numberInside = 0;
        while (validateBonusNumber) {
            String UserHopeLottoNumbers = Console.readLine();
            numberInside = Integer.parseInt(UserHopeLottoNumbers);
            validateBonusNumber = inRangeBonusNumberExceptional(numbers,numberInside);
        }
        return numberInside;
    }

}


