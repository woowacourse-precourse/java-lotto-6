package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.converter.MessageConverter;
import lotto.model.dto.WinningNumDTO;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String writePurchasedLottos() {
        return MessageConverter.writePurchasedLottos(lottos);
    }

    public Result checkResult(WinningNumDTO winningNumDTO) {
        List<Ranking> rankings = new ArrayList<>();
        lottos.forEach(lotto -> {
            rankings.add(lotto.checkResult(winningNumDTO));
        });
        return new Result(rankings);
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }
}
