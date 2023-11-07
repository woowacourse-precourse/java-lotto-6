package lotto.lotto.view;

import java.util.List;

import lotto.lotto.model.Lotto;

public class LottoView {
    private static void printUserCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printUserLotto(List<Lotto> lottos){
        printUserCount(lottos.size());
        for(Lotto lotto : lottos){
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto){
        System.out.println(lotto.toString());
    }
}
