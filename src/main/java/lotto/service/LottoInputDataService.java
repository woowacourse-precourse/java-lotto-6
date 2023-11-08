package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoUtil lottoUtil = new LottoUtil();

    public List<Integer> inputLottoNumbers() {
        outputView.askLottoNumbers();
        List<Integer> lottoNumbers = LottoUtil.lottoNumbersParser(inputView.inputLottoNumbersView());
        return lottoNumbers;
    }
}
