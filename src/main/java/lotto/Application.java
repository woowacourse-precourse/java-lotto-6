package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    List<Integer> lottonm = new ArrayList<>;
    int coin = 0;
    System.out.println("구입금액을 입력해 주세요");
    coin = Integer.parseInt(Console.readLine());


    try{
        if(coin % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }catch (IllegalArgumentException e){

    }


    Lotto lotto = new Lotto();


    }
}
