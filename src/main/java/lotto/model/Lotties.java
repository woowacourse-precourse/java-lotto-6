package lotto.model;

import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public Lotto get(int index) {
        return lotties.get(index);
    }

    public int size() {
        return lotties.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lotties.size(); i++) {
            stringBuilder.append(lotties.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Lotto> getLotties() {
        return lotties;
    }
}
