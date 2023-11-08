package lotto.service;

import lotto.LottoUtil;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoInputDataService {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private final LottoUtil lottoUtil = new LottoUtil();

    public Lotto inputLottoData() {
        List<Integer> lottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();
        return setLotto(lottoNumbers, bonusNumber);
    }

    public List<Integer> inputLottoNumbers() {
        resultView.askLottoNumbers();
        List<Integer> lottoNumbers = lottoUtil.lottoNumbersParser(inputView.inputLottoNumbersView());
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        resultView.askBonusNumber();
        int bonusNumber = lottoUtil.bonusNumberParser(inputView.inputBonusNumberView());
        return bonusNumber;
    }

    public Lotto setLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(bonusNumber);
        return lotto;
    }
}