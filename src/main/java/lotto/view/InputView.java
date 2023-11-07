package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int readPrice(){
        System.out.println("구매금액을 입력해주세요.");
        String userInput = Console.readLine();
        int price = validateStringToInteger(userInput);
        validatePriceUnit(price);
        return price;
    }

    public List<Integer> readLotto(){
        System.out.println("당첨번호를 입력해주세요.");
        String userInput = Console.readLine();
        String[] splittedUserInput = userInput.split(",");
        List<Integer> splittedNumber = new ArrayList<>();
        for (String input:splittedUserInput){
            int number = validateStringToInteger(input);
            splittedNumber.add(number);
        }
        return splittedNumber;
    }

    public String readBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
    private String[] spliteString(String input){
        String[] splittedNumber = input.split(",");
        return splittedNumber;
    }

    private int validateStringToInteger(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자형식으로 입력합니다.");
        }
    }
    private void validatePriceUnit(int price){
        if(price % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 지불해야합니다.");
        }
    }
}
