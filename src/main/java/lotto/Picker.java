package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Picker {
    private List<Integer> winNumbers = new ArrayList<Integer>();
    private Integer winBonusNumber;

    public List<Integer> generateWinNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winNumbersInput = readLine();
        validateWinNumbers(winNumbersInput);

        for(String winNumberInput : winNumbersInput.split(",")){
            this.winNumbers.add(Integer.parseInt(winNumberInput));
        }
        return this.winNumbers;
    }

    private void validateWinNumbers(String winNumbersInput) {
        if(!winNumbersInput.contains(",")){
            System.out.println("[ERROR] ,로 구분하여 입력해주세요.");
            throw new IllegalArgumentException();
        }

        for(String winNumberInput : winNumbersInput.split(",")){
            if (!Character.isDigit(winNumberInput.charAt(0))) {
                System.out.println("[ERROR] 공백없이 ,로 구분하여 숫자를 입력해주세요");
                throw new IllegalArgumentException();
            }
        }

        for(String winNumberInput : winNumbersInput.split(",")){
            if (Integer.parseInt(winNumberInput)<1 || Integer.parseInt(winNumberInput)>45) {
                System.out.println("[ERROR] 1이상 45이하인 숫자만 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }

        List<Integer> winNumbers = new ArrayList();
        for(String winNumberInput : winNumbersInput.split(",")){
            winNumbers.add(Integer.parseInt(winNumberInput));
        }
        if(winNumbers.size()!=6){
            System.out.println("[ERROR] 숫자 6개를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public int generateWinBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String winBonusNumberInput = readLine();
        validateWinBonusNumber(winBonusNumberInput);
        this.winBonusNumber = Integer.parseInt(winBonusNumberInput);
        return this.winBonusNumber;
    }

    private void validateWinBonusNumber(String winBonusNumberInput) {
        for(String winBonusNumber : winBonusNumberInput.split("")){
            if (!Character.isDigit(winBonusNumber.charAt(0))) {
                System.out.println("[ERROR] 숫자를 입력해주세요");
                throw new IllegalArgumentException();
            }
        }

        int winBonusNumber = Integer.parseInt(winBonusNumberInput);
        if (winBonusNumber<1 || winBonusNumber>45) {
            System.out.println("[ERROR] 1이상 45이하인 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }

        if(this.winNumbers.contains(winBonusNumber)){
            System.out.println("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}
