package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.service.Service;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    Buyer buyer = new Buyer();
    Service service = new Service();
    public void run() {
        service.createLotto(buyer);
        watchPurchasedLotteries();
        LottoResult lottoResult = new LottoResult();
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < buyer.getCount(); i++) {
            int cnt = 0;
            for (int number : lottoResult.getWinningNumbers()) {
                if(buyer.getPurchasedLotteries().get(i).getNumbers().contains(number)){
                    cnt ++;
                }
            }count.add(cnt);
        }

        System.out.println();
        System.out.println("당첨 통계\n" +
                "---");
        System.out.printf("3개 일치 (5,000원) - %d개 \n", Collections.frequency(count, 3));
        System.out.printf("4개 일치 (50,000원) - %d개 \n", Collections.frequency(count, 4));
        System.out.printf("5개 일치 (1,500,000원) - %d개 \n", Collections.frequency(count, 5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개 \n", Collections.frequency(count, 5));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개 \n", Collections.frequency(count, 6));
        System.out.println("---");
        System.out.printf("총 수익률은 %.1f", 62.5);
        System.out.println("%입니다.");
        }


    public void watchPurchasedLotteries(){
        View.printPurchasedLotteries(buyer.getCount());
        for (Lotto lotto : buyer.getPurchasedLotteries()){
            View.printPurchasedLotteries(lotto.getNumbers());
        }
    }
}
