package lotto;


import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int inputMoney(){
        String moneyStr = Console.readLine();
        int money;

        try{
            money = Integer.parseInt(moneyStr);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원을 단위로 입력해주세요");
        }

        return money;
    }

    public List<Integer> inputAnswer(){
        List<Integer> answerNum = new ArrayList<>();
        String answerStr = Console.readLine();
        String[] answer = answerStr.split(",");

        try{
            for(String numStr: answer){
                answerNum.add(Integer.parseInt(numStr));
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        return answerNum;
    }



}
