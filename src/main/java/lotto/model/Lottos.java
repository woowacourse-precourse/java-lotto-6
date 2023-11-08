package lotto.model;

import java.util.List;

public record Lottos(List<Lotto> lottosInfo) {

    public Lottos(List<Lotto> lottosInfo) {
        this.lottosInfo = lottosInfo;
    }
}