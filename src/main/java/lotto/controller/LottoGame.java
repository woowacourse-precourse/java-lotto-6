package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Output;
import lotto.model.User;

import java.util.Comparator;
import java.util.List;

public class LottoGame {
    public void gameStart(){
        User user = new User();
        int amount = purchaseAmount();
        setAmount(user, amount);
        setLoopCount(user, amount);
        setLottoTickets(user);
        printLottoTickets(user);

    }

    public void printLottoTickets(User user){
        for(int i = 0; i < user.getLoopCount(); i++){
            System.out.println(user.getLottoTickets().get(i).toString());
        }
    }

    public List<Integer> randomSortNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // 오름차순 정렬
        randomNumbers.sort(Comparator.naturalOrder());
        return randomNumbers;
    }

    public void setLottoTickets(User user){
        System.out.println(user.getLoopCount() + Output.LOOP_COUNT_MESSAGE);
        for(int i = 0; i < user.getLoopCount(); i++){
            List<Integer> randomLotto = randomSortNumbers();
            Lotto lotto = new Lotto(randomLotto);
            user.setLottoTicket(lotto);
        }
    }

    public boolean loopCountCheck(int amount){
        if(amount % 1000 != 0){
            return false;
        }
        return true;
    }

    public void setLoopCount(User user, int amount){
        if(loopCountCheck(amount)){
            user.calculationLoopCount();
        }
    }

    public int purchaseAmount(){
        System.out.println(Output.PURCHASE_AMOUNT_MESSAGE);
        int amount = amountInput();
        return amount;
    }

    public void setAmount(User user, int amount){
        user.setMoney(amount);
    }

    public int amountInput(){
        String beforeAmount = Console.readLine();
        if(!isNumber(beforeAmount)){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        int afterAmount = Integer.parseInt(beforeAmount);
        return afterAmount;
    }

    public boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
