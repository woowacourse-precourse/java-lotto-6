package lotto.View;

import lotto.domiain.Lotto;

import java.util.List;

public class OutputLottoList {

    public static void myLottoList(List<Lotto> lotto, int ticketCount){
        for (int i = 0; i < ticketCount; i++) {
            System.out.println(lotto.get(i));
        }
    }
    
}
