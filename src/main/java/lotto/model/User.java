package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    int payed;
    List<Lotto> lottos;

    public User(){
        payed = getMoney();
    }


    private int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        if (!userInput.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        int money = Integer.parseInt(userInput);
        if (money == 0 || money % 1000 != 0){
            throw new IllegalArgumentException("1000단위의 수를 입력해주세요.");
        }
        return money;
    }

    public void buyLotto(LotteryMachine lotteryMachine){
        for (int i = 0; i < (payed / 1000); i++){
            Lotto lotto = new Lotto(lotteryMachine.draw());
            lottos.add(lotto);
        }
    }

    public void printLotto(){
        System.out.println( payed/1000 + "개를 구매했습니다.");
        for (Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

}
