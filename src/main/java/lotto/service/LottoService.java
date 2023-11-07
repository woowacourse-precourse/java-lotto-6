package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cunsumer;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;
import lotto.view.LottoPrint;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    final int amount = 1000;
    final int size = 6;
    final int start = 1;
    final int end = 45;
    RandomUtils randomUtils = new RandomUtils();
    LottoPrint lottoPrint = new LottoPrint();
    Cunsumer consumer;
    public void purchaseLotto(){
        int money = inputMoney();
        int quantity = money / amount;

        ArrayList<Lotto> lotto = new ArrayList<>();
        for(int i = 0; i < quantity; i++){
            lotto.add(purchaseOneLotto());
        }
        consumer = new Cunsumer(lotto);
        lottoPrint.purchaseLottoPrint(quantity, consumer.getPurchasedLotto());
    }

    private Lotto purchaseOneLotto(){
        List<Integer> numbers = randomUtils.randomNumber(size, start, end);
        return new Lotto(numbers);
    }
    public int inputMoney() {
        String input = Console.readLine();
        int money = 0;
        try{
            money = Integer.parseInt(input);
            try{
                if(money % 1000 != 0) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] 천원 단위로 입력해주세요.");
                money = inputMoney();
            }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            money = inputMoney();
        }
        return money;
    }

}
