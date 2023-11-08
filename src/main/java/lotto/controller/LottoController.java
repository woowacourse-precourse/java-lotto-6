package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.dto.LottoDto;
import lotto.domain.money.Money;
import lotto.domain.statistics.LottoResult;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.NumberGenerator;

public class LottoController {

    private final NumberGenerator lottoNumberGenerator;

    public LottoController(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoDto> transferLottoDtos(Lottos lottos) {
        return lottos.mapToLottoDtos();
    }
    public Lottos buyLottos(int money) {
        Money userMoney = new Money(money);
        int numberOfLottos = userMoney.getNumberOfLottos();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }

        return new Lottos(lottos);
    }



}
