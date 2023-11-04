package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class outputMessage {
    public static void buyMessage(List<Lotto> Lotteries){
        int amount = Lotteries.size();
        System.out.println(Lotteries.size()+"개를 구매했습니다.");
        for (int i = 0; i < amount; i++){
            Lotto lotto = Lotteries.get(i);
            System.out.println(lotto.numbers);
        }
    }

}
