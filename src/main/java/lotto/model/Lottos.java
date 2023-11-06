package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottoList = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    @Override
    public String toString() {
        return lottoList.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
