package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputLottoList {

    public static void printLottoList(List<Lotto> lotto){
        for (int i = 0; i < lotto.size(); i++) {
            System.out.println(lotto.get(i));
        }
    }
    
}
