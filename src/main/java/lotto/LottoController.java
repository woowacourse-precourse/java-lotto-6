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
            printLotteryList(totalLottery);
            Lotto winningNumber = getWinningNumber();
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
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

    private void printLotteryList(List<Lotto> totalLottery){
        System.out.println();
        System.out.println(totalLottery.size() + "개를 구매했습니다.");
        for(Lotto lottery : totalLottery){
            lottery.printLotteryNumber();
        }
    }

    private Lotto getWinningNumber() throws IllegalArgumentException{
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> number = new ArrayList<>();
        String[] inputWinningNumber = Console.readLine().split(",");
        for (String eachNumber : inputWinningNumber) {
            number.add(Integer.parseInt(eachNumber));
        }

        try{
            return new Lotto(number);
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }
}
