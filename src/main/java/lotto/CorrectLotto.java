package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CorrectLotto {
    private Lotto correct_lotto;
    private int bonus;

    public void setCorrect_lotto(Lotto correct_lotto) {
        this.correct_lotto = correct_lotto;
    }

    public Lotto getCorrect_lotto() {
        return correct_lotto;
    }
    public int getBonus() {
        return bonus;
    }

    public void printInputNumbersMessage(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    private int countComma(String input_numbers){
        int count = 0;
        for(int i = 0; i < input_numbers.length(); i++){
            if(input_numbers.charAt(i) == ',')
                count++;
        }
        return count;
    }

    // 입력값이 없는 부분이 있는지 확인
    private void checkEmptyPart(int expect, int size){
        if(expect != size){
            throw new IllegalArgumentException("입력값이 없는 부분이 있습니다. 6개의 당첨 번호를 콤마로 구분하여 입력해 주세요.");
        }
    }

    public List<Integer> convertStringToInteger(String input_numbers){
        String[] numbers = input_numbers.split(",");
        checkEmptyPart(countComma(input_numbers) + 1, numbers.length);

        List<Integer> converted_numbers = new ArrayList<>();
        for(String number : numbers){
            int converted_number = CommonFunction.convertToInt(number.strip());
            converted_numbers.add(converted_number);
        }

        return converted_numbers;
    }
    public void inputCorrectLotto(String input_numbers){
        List<Integer> converted_numbers = convertStringToInteger(input_numbers);
        correct_lotto = new Lotto(converted_numbers);
    }

    public void printInputBonusMessage(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    // 보너스 번호가 당첨 번호와 중복되는지 확인
    public void checkNumberDuplicate(int number){
        if(correct_lotto.getNumbers().contains(number)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public void inputBonus(String input_number){
        int converted_number = CommonFunction.convertToInt(input_number.strip());
        CommonFunction.checkNumberIn1to45(converted_number);
        checkNumberDuplicate(converted_number);
        bonus = converted_number;
    }
}
