package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.util.InputConvertUtil;

public class InputView {

    public static int inputPurchaseAmount(){
        String purchaseAmount = Console.readLine();
        validateNotEmpty(purchaseAmount);
        validateIntegerType(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputLottoNumber(){
        String lottoInput = Console.readLine();
        List<String> lottoNumbers = InputConvertUtil.lottoNumberToLottoList(lottoInput);
        validateEachNumberNotEmpty(lottoNumbers);
        return InputConvertUtil.lottoNumberToIntegerList(lottoNumbers);
    }

    private void validateEachNumberNotEmpty(List<String> lottoNumbers) {
        for (String lottoNumber : lottoNumbers) {
            validateNotEmpty(lottoNumber);
        }
    }

    private static void validateIntegerType(String input) {
        Pattern pattern = Pattern.compile("^-?\\d+$");
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 정수 타입이어야 합니다");
        }
    }

    private static void validateNotEmpty(String input) {
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] : 입력 값은 공백일 수 없습니다");
        }
    }

}
