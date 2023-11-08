package lotto.dto;

import lotto.domain.Lottos;

public class LottosIssuanceResponse {
    private final int count;
    private final Lottos lottos;

    public LottosIssuanceResponse(int count, Lottos lottos) {
        this.count = count;
        this.lottos = lottos;
    }

    @Override
    public String toString() {

        return count + "개를 구매했습니다\n"
                + lottos.toString();
    }
}
