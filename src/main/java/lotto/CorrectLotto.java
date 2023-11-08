package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CorrectLotto {
    private Lotto correct_lotto;

    public void printInputNumbersMessage(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public int countComma(String input_numbers){
        int count = 0;
        for(int i = 0; i < input_numbers.length(); i++){
            if(input_numbers.charAt(i) == ',')
                count++;
        }
        return count;
    }

    public List<Integer> convertStringToPositiveInt(String input_numbers){
        String[] numbers = input_numbers.split(",");
        int count_comma = countComma(input_numbers);

        // 입력값이 없는 부분이 있는지 확인
        if(numbers.length != count_comma + 1){
            throw new IllegalArgumentException("입력값이 없는 부분이 있습니다. 6개의 당첨 번호를 입력해 주세요.");
        }

        List<Integer> converted_numbers = new ArrayList<>();
        for(String number : numbers){
            String striped_number = number.strip();

            // 입력값이 숫자인지 확인
            int converted_number;
            try {
                converted_number = Integer.parseInt(striped_number);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("입력값이 숫자가 아닙니다. 1~45 사이의 숫자를 입력해주세요.");
            }

            converted_numbers.add(converted_number);
        }

        return converted_numbers;
    }
    public void inputNumbers(){
        String input_numbers = readLine();
        List<Integer> converted_numbers = convertStringToPositiveInt(input_numbers);

        while(true) {
            try {
                correct_lotto = new Lotto(converted_numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }
    }

}
