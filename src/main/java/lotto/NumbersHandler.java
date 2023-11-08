package lotto;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;

public class NumbersHandler {
    static final int minNumber = 1;
    static final int maxNumber = 45;
    static final int duplication = 2;
    private final List<Integer> winningNumbers = new ArrayList<>();
    private  int bonusNumber;

    NumbersHandler() {}

    public void init(){

        while(true){
            System.out.println("당첨 번호를 입력해 주세요.");
            String numbersInput=Console.readLine();
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();

            try {
                if (!isNumber(numbersInput, bonusNumberInput)) throw new IllegalArgumentException("문자가 아닌 숫자를 입력해 주세요");
                if(!isValidNumber()) throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                if(hasDuplicate())throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");

                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }

    }

    public boolean isNumber(String numbersInput,String bonusNumberInput){
        try{
            bonusNumber=Integer.parseInt(bonusNumberInput);
            String[] numbers = numbersInput.split(",");
            for (String number : numbers) {
                winningNumbers.add(Integer.parseInt(number));
            }
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public boolean isValidNumber() {
        for (int number:winningNumbers){
            if (number < minNumber || number > maxNumber) return false;
        }
        return minNumber<=bonusNumber && bonusNumber<=maxNumber;
    }

    public boolean hasDuplicate() {
        List<Integer> numberCount = new ArrayList<>(maxNumber + 1);
        for (int number = minNumber - 1; number <= maxNumber; number++) numberCount.add(0);

        numberCount.set(bonusNumber, numberCount.get(bonusNumber) + 1);

        for (int number : winningNumbers) {
            numberCount.set(number, numberCount.get(number) + 1);
            if (numberCount.get(number) >= duplication) return true;
        }
        return false;
    }

    public List<Integer> convertedWinningNumbers() {

        return winningNumbers;
    }

    public int convertedBounsNumber() {
        return bonusNumber;
    }
}
