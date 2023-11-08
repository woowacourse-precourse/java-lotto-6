package lotto;

import java.util.List;

public class Printing {
    private final List<Lotto> lottos;
    private final static String END = "당첨 통계\n---";

    public Printing(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private void printResult() {
        System.out.println(END);

    }
}
