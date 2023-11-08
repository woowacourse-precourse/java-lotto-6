package domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public int countLotto(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }
        int count = money/1000;
        return count;
    }
    public int ableBuy(){
        while(true){
            try {
                int money = buy();
                return countLotto(money);
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
