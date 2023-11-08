package lotto.lotto.view;

import java.util.List;

import lotto.lotto.model.Lotto;

public class LottoView {

    private static final StringBuilder sb = new StringBuilder();

    private static void printUserCount(int count){
        sb
            .append(count)
            .append("개를 구매했습니다.")
        ;
        System.out.println(sb);
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
