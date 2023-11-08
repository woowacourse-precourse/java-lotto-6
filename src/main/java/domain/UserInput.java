package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> randomNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    public int countLotto(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
        int count = money/1000;
        return count;
    }
    public void ableBuy(){
        while(true){
            try {
                int money = buy();
                countLotto(money);
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public int buy() {

        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }

    }
}
