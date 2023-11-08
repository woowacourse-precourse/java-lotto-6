package lotto;

import java.util.List;

public class Printing {
    private final List<Lotto> lottos;

    public Printing(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void printLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
