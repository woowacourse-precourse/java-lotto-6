package lotto.View;

import java.util.List;

public class OutputView {

    public static void printLottosSize(int size) {
        System.out.println(size+"개를 구매했습니다.");
    }

    public static void printLottosNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
