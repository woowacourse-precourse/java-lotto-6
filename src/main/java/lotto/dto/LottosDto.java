package lotto.dto;

import lotto.domain.Lotto;

import java.util.ArrayList;

public record LottosDto(
        ArrayList<Lotto> lottos
) {
    public Lotto[] toArr() {
        Lotto[] arr = new Lotto[lottos().size()];
        for (int i = 0; i < lottos().size(); i++) {
            arr[i] = lottos.get(i);
        }
        return arr;
    }
}
