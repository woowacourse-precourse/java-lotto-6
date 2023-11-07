package lotto.view;

public class InputValidator {
    private static final String BLANK_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String NUMBER_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    private static final String THOUSAND_MESSAGE = "[ERROR] 금액은 천원 단위로 입력해주세요.";
    private static final String COMMA_MESSAGE = "[ERROR] 6개의 번호를 콤마로 구분하여 입력해주세요.";
    private static final String NUMRANGE_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자로만 입력해주세요.";
    public static void validateLottoAll(String inputPrice){
        validateBlank(inputPrice);
        validateNumber(inputPrice);
        validateDivision(inputPrice);
    }

    // 공백 입력한 경우 예외 처리
    private static void validateBlank(String inputPrice){
        if (inputPrice.trim()=="") throw new IllegalArgumentException(BLANK_MESSAGE);
    }

    // 숫자가 아닐경우 예외 처리
    private static void validateNumber(String inputPrice){
        try{
            Integer.parseInt(inputPrice.replace(",",""));
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_MESSAGE);
        }
    }

    //천원 단위로 나누어떨어지지않는 경우 예외 처리
    private static void validateDivision(String inputPrice){
        if (Integer.parseInt(inputPrice) % 1000 != 0) throw new IllegalArgumentException(THOUSAND_MESSAGE);
    }


    public static void validateInputLottoNum(String inputLottoNum){
        validateBlank(inputLottoNum);
        validateSixLength(inputLottoNum);
        validateNumberLength(inputLottoNum);
    }

    private static void validateSixLength(String inputNumbers){
        if(inputNumbers.split(",").length!=6) throw new IllegalArgumentException(COMMA_MESSAGE);
    }

    private static void validateNumberLength(String inputNumbers){
        String[] inputarr = inputNumbers.split(",");
        for(String num : inputarr){
            validateLottoRange(num);
        }
    }

    public static void validateInputBonusNum(String inputBonusNum){
        validateBlank(inputBonusNum);
        validateLottoRange(inputBonusNum);
    }

    public static void validateLottoRange(String inputNum){
        int num = Integer.parseInt(inputNum);
        if(num<1 || num>45) throw new IllegalArgumentException(NUMRANGE_MESSAGE);
    }


}
