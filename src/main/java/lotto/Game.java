package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void start(){
        insertCoin();
    }

    public Integer insertCoin(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Integer count = validCoin(Integer.parseInt(input));

        return count;
    }

    public Integer validCoin(Integer input){
        if (input % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        return input%1000;
    }
}