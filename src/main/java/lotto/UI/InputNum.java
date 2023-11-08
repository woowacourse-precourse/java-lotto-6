package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNum {
    public List<Integer> inputLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputLottoNumber = Console.readLine();
            try {
                lottoNumbers = checkLottoNumbers(inputLottoNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputLottoNumbers();
            }
        return lottoNumbers;
    }

    private List<Integer> checkLottoNumbers(String inputLottoNumber) {
        String[] inputLottoNumbers = inputLottoNumber.split(",");
        checkLottoNumberComma(inputLottoNumber);
        List<Integer> lottoNumbers = checkLottoNumbersToInt(inputLottoNumbers);
        return lottoNumbers;
    }
    public static void checkLottoNumberComma(String inputLottoNumbers){
        if(!inputLottoNumbers.contains(",")){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표(,)를 기준으로 구분해주세요.");
        }
    }
    public static List<Integer> checkLottoNumbersToInt(String[] inputLottoNumbers) {
        List<Integer> lottoNumbersToInt = new ArrayList<>();
        try {
            for (String number : inputLottoNumbers) {
                lottoNumbersToInt.add(Integer.parseInt(number));
            }
            return lottoNumbersToInt;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 숫자로만 입력해주세요.");
        }
    }
}
