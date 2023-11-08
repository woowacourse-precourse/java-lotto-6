package lotto;

import java.util.List;

public class OutputUser {
    public void outputBuyLotto(Integer totalLottoCount){
        System.out.printf("%d개를 구매했습니다.\n", totalLottoCount);
    }
    public void outputBuyLottoNumbers(List<Lotto> numberTickets){
        for (Lotto lotto : numberTickets){
            System.out.println(lotto.getNumbers());
        }
    }
}
