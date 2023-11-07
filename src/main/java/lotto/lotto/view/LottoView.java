package lotto.lotto.view;

import java.util.List;

public class LottoView {
    public static void printUserCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printUserLotto(List<List<Integer>> lottos){
        for(List<Integer> lotto : lottos){
            printLotto(lotto);
        }
    }

    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto.toString());
    }
}
