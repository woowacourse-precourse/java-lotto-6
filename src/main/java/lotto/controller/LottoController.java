package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoSetPriceException;
import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final LottoSetPriceException lottoSetPriceException = new LottoSetPriceException();
    private final LottoService lottoService = new LottoService();

    public int LottoSetPrice() {
        String readPrice = Console.readLine();
        int lottoPrice = lottoSetPriceException.checkPriceException(readPrice);
        return lottoPrice;
    }

    public List<Lotto> makeLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = lottoService.makeRandomNumber();
            Lotto lotto = new Lotto(lottoNumber);

            lottos.add(lotto);
        }
        return lottos;
    }
}
