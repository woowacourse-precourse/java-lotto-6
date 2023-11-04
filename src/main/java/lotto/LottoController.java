package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    static final int MONEY_UNIT = 1000;
    static final int LOTTERY_COST = 1000;

    LotteryService lotteryService = new LotteryService();
    public void run(){
        try{
            int userMoney = getMoney();
            int lotteryCount = userMoney / LOTTERY_COST;
            List<Lotto> totalLottery = lotteryService.getTotalLottery(lotteryCount);

        } catch(IllegalArgumentException e){

        }

    }

    private int getMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해주세요.");

        int money = Integer.parseInt(Console.readLine());

        if(money % MONEY_UNIT != 0){
            System.out.println("[ERROR] 돈은 1000단위로 입력해야 합니다.");

            throw new IllegalArgumentException();
        }

        return money;
    }
}
