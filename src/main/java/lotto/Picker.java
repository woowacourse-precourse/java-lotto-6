package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Picker {
    private List<Integer> winNumbers;
    private Integer winBonusNumber;

    public List<Integer> generateWinNumbers(){
        String winNumbersInput = readLine();
        validateWinNumbers(winNumbersInput);

        for(String winNumberInput : winNumbersInput.split(",")){
            this.winNumbers.add(Integer.parseInt(winNumberInput));
        }
        return this.winNumbers;
    }

    private void validateWinNumbers(String winNumbersInput) {
        if(!winNumbersInput.contains(",")){
            throw new IllegalArgumentException("[ERROR] ,로 구분하여 입력해주세요.");
        }

        for(String winNumberInput : winNumbersInput.split(",")){
            if (!Character.isDigit(winNumberInput.charAt(0))) {
                throw new IllegalArgumentException("[ERROR] 공백없이 ,로 구분하여 숫자를 입력해주세요");
            }
        }

        for(String winNumberInput : winNumbersInput.split(",")){
            if (Integer.parseInt(winNumberInput)<1 || Integer.parseInt(winNumberInput)>45) {
                throw new IllegalArgumentException("[ERROR] 1이상 45이하인 숫자만 입력해주세요.");
            }
        }

        List<Integer> winNumbers = new ArrayList();
        for(String winNumberInput : winNumbersInput.split(",")){
            winNumbers.add(Integer.parseInt(winNumberInput));
        }
        if(winNumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력해주세요.");
        }
    }

    public int generateWinBonusNumber(){
        String winBonusNumberInput = readLine();
        validateWinBonusNumber(winBonusNumberInput);
        this.winBonusNumber = Integer.parseInt(winBonusNumberInput);
        return this.winBonusNumber;
    }

    private void validateWinBonusNumber(String winBonusNumberInput) {
        if (!Character.isDigit(winBonusNumberInput.charAt(0))) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }

        if (Integer.parseInt(winBonusNumberInput)<1 || Integer.parseInt(winBonusNumberInput)>45) {
            throw new IllegalArgumentException("[ERROR] 1이상 45이하인 숫자만 입력해주세요.");
        }
    }
}
