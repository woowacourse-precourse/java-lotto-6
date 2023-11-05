package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNum {
    public List<Integer> inputLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputLottoNumber = Console.readLine();
            try {
                lottoNumbers = checkLottoNumbers(inputLottoNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoNumbers;
    }
    private List<Integer> checkLottoNumbers(String inputLottoNumber) {
        String[] inputLottoNumbers = inputLottoNumber.split(",");
        checkLottoNumberComma(inputLottoNumber);
        List<Integer> lottoNumbers = checkLottoNumbersToInt(inputLottoNumbers);
        checkLottoNumberSize(inputLottoNumbers);
        checkLottoNumberDup(inputLottoNumbers);
        checkLottoNumberRange(lottoNumbers);
        return lottoNumbers;
    }
    private void checkLottoNumberComma(String inputLottoNumbers){
        if(!inputLottoNumbers.contains(",")){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표(,)를 기준으로 구분해주세요.");
        }
    }
    private void checkLottoNumberSize(String[] inputLottoNumbers){
        if(inputLottoNumbers.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6가지를 입력해주세요.");
        }
    }
    private List<Integer> checkLottoNumbersToInt(String[] inputLottoNumbers) {
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
    private void checkLottoNumberDup(String[] inputLottoNumbers) {
        List<String> checkDup = new ArrayList<>();
        for (String number : inputLottoNumbers) {
            if (checkDup.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 중복없이 입력해주세요.");
            }
            checkDup.add(number);
        }
    }
    private void checkLottoNumberRange(List<Integer> lottoNumbers){
        for(int number : lottoNumbers){
            if (number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 당첨번호는 1 ~ 45 사이의 숫자를 입력해주세요.");
            }
        }
    }
}
