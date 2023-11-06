package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private int money;
    private int ticketCount;
    private List<Lotto> lottos;
    private final int LOTTO_NUMBER_COUNT = 6;

    User(){
        getMoney();
    }

    public void getRandomLotto(){
        System.out.println("\n" + Message.LOTTO_RANDOM_PRINT);
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    private void getMoney(){
        System.out.println(Message.INPUT_MONEY);
        while(true){
            try{
                this.money = Integer.parseInt(Console.readLine());
                this.ticketCount = getTicketCount(money);
                return;
            } catch (IllegalArgumentException e){
                System.out.println(Message.ERROR_MESSAGE + " " + Message.ONE_HUNDRED_DIVIDE);
            }
        }
    }

    /**
     * 천원단위로 나눠 떨어지지 않을 때 예외처리
     * */
    private int getTicketCount(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        return money / 1000;
    }

}
