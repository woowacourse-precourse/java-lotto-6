package lotto.view;

import static lotto.domain.LottoNumbers.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumbers.MIN_LOTTO_NUMBER;

public class ExceptionMessage {
//
//    public static final int CNT_LOTTO_NUMBER = 6;
//    public static final int MIN_LOTTO_NUMBER = 1;
//
//    public  static final int MAX_LOTTO_NUMBER = 45;
    //public static final int LOTTO_PRICE = 1000;
    private static final String NOT_NUMBER_SIZE = "[ERROR]당첨번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 로또 번호는"+MIN_LOTTO_NUMBER +"부터" + MAX_LOTTO_NUMBER +  "사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_OVERLAP = "[ERROR] 숫자가 중복되었습니다.확인해주세요.";

    private static final String INPUT_TYPE_ERROR =  "[ERROR] 숫자만 입력이 가능합니다.";

    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 반드시 한장은 사셔야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + MIN_LOTTO_NUMBER + "단위여야 합니다.";


    public void rangeException(){
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void sizeException(){
        System.out.println(NOT_NUMBER_SIZE);

    }

    public static void overlapException(){
        System.out.println(NOT_NUMBER_OVERLAP);
    }
    public static void numberException(){
        System.out.println(NOT_NUMBER_ERROR);
    }
    public static void typeEXCEPTIOM(){
        System.out.println(INPUT_TYPE_ERROR);

    }

    public static void naturalException(){
        System.out.println(NOT_NATURAL_NUMBER_ERROR);
    }

    public static void divisibleException(){
        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
    }















}
