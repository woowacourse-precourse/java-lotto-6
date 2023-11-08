package lotto.service;

import lotto.domain.Lotto;
import lotto.utils.LottoUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<Integer> inputLottoNumbers() {
        outputView.askLottoNumbers();
        List<Integer> lottoNumbers = LottoUtil.lottoNumbersParser(inputView.inputLottoNumbersView());
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        outputView.askBonusNumber();
        int bonusNumber = LottoUtil.bonusNumberParser(inputView.inputBonusNumberView());
        return bonusNumber;
    }

    public Lotto setLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(bonusNumber);
        return lotto;
    }
}
