package lotto;

import java.util.List;

public class Printing {
    private int numberOfLotto;
    private final List<Lotto> lottos;

    public Printing(int numberOfLotto, List<Lotto> lottos) {
        this.numberOfLotto = numberOfLotto;
        this.lottos = lottos;
    }

    public void printLotto() {
        System.out.println(lottos);
    }
}
