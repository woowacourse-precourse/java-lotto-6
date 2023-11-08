package lotto.controller;

import lotto.constant.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.model.Input;
import lotto.model.LottoUtil;
import lotto.model.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final Input input;
    private final LottoUtil lottoUtil;
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomGenerator randomGenerator;

    private List<Lotto> lottos;
    private int count;

    public void run() {
        createLottos();
        createWinningLotto();
        compareLotto();
    }

    public LottoController(Input input, LottoUtil lottoUtil
            , InputView inputView, OutputView outputView, RandomGenerator randomGenerator) {
        this.input = input;
        this.lottoUtil = lottoUtil;
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerator = randomGenerator;
    }

    public void createLottos() {
        inputView.inputAmountView();
        this.count = input.inputAmountType();
        List<List<Integer>> randomNumbers = randomGenerator.getRandomNumbers(count);
        this.lottos = lottoUtil.lottoCreateCount(randomNumbers);
        outputView.outputLotto(lottos);
    }

    public void createWinningLotto() {
        inputView.inputWinningNumberView();
        Lotto winningLottoNumbers = input.inputLottoNumber();
        inputView.inputWinningBonusNumberView();
        int bonusNumber = input.inputLottoBonusNumber();
        WinningLotto winningLotto = WinningLotto.getInstance();
        winningLotto.setLotto(winningLottoNumbers);
        winningLotto.setBonusNumber(bonusNumber);
    }

    public void compareLotto() {
        Map<Rank, Integer> rank = lottoUtil.compareLottoNumbers(lottos, WinningLotto.getInstance());
        float rateOfReturn = lottoUtil.rateOfReturn(count * LottoConstants.UNIT, rank);
        outputView.outputRank(rank, rateOfReturn);
    }
}
