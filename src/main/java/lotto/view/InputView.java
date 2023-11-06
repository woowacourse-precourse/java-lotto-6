package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int getMoney(){
        while (true) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                return changeToInt(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = new ArrayList<>();
        String numbers =  Console.readLine();
        for (String s : numbers.split(",")){
            winNumbers.add(changeToInt(s));
        }
        return winNumbers;
    }

    public int getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return changeToInt(Console.readLine());
    }

    public int changeToInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요");
        }
    }
}
