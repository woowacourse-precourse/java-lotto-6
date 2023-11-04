package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utility.vo.LottoResponse;

public class IssuedLottos {
    private final List<Lotto> lottos;

    public IssuedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int numberOfIssuedLottos() {
        return lottos.size();
    }

    public List<LottoResponse> convertToResponse() {
        return lottos.stream()
            .map(Lotto::convertToResponse)
            .collect(Collectors.toList());
    }
}
