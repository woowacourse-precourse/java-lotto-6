package lotto.view;

import lotto.domain.LottoChecker;
import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void showCount(int count) {
        System.out.println();
        System.out.println(String.valueOf(count)+"개를 구매했습니다.");
    }
    public static void showLottoTickets(List<Lotto> tickets) {
        for(Lotto ticket : tickets){
            System.out.println(ticket.toString());
        }
    }

    public static void showLottoResult(List<Integer> result) {
        for(int i : result){
            System.out.println(i);
        }
    }
}
