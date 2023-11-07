package lotto.domain;

import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;


    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public String getLottiesStatus() {
        StringBuilder builder = new StringBuilder();

        for (Lotto lotto : lotties) {
            builder.append(lotto);
        }

        return builder.toString();
    }
}
