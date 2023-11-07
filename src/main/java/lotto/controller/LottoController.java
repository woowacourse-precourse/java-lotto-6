package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PlayerAmount;
import lotto.util.Converter;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        setting();
    }

    private void setting() {
        Lottos lottos = createLottos();
        LottoResult lottoResult = setLottoResult();
    }

    private Lottos createLottos() {
        int count = new PlayerAmount(inputView.getPlayerAmount()).getLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(0, count)
                .forEach(lotto -> new Lotto(RandomNumberGenerator.generate()));

        return Lottos.create(lottos);
    }

    private LottoResult setLottoResult() {
        List<Integer> winningNumber = Converter.convertToIntList(inputView.getLottoWinningNumbers());
        String bonusNumber = inputView.getBonusNumber();

        return LottoResult.create(winningNumber, bonusNumber);
    }
}
