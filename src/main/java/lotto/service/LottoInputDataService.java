package lotto.service;

import lotto.domain.Lotto;
import lotto.exception.LottoException;
import lotto.util.LottoUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoInputDataService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoUtil lottoUtil = new LottoUtil();
    private final LottoException lottoException = new LottoException();

    public Lotto inputLottoData() {
        List<Integer> lottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusNumber();
        return setLotto(lottoNumbers, bonusNumber);
    }

    public List<Integer> inputLottoNumbers() {
        List<Integer> lottoNumbers;
        while (true) {
            try {
                outputView.askLottoNumbers();
                lottoNumbers = lottoUtil.lottoNumbersParser(inputView.inputLottoNumbersView());
                lottoException.validateLottoNumbers(lottoNumbers);
                return lottoNumbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public int inputBonusNumber() {
        outputView.askBonusNumber();
        int bonusNumber = lottoUtil.bonusNumberParser(inputView.inputBonusNumberView());
        return bonusNumber;
    }

    public Lotto setLotto(List<Integer> lottoNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(lottoNumbers);
        while (true) {
            try {
                lottoException.validateBonusNumbers(lottoNumbers, bonusNumber);
                lotto.setBonusNumber(bonusNumber);
                return lotto;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                bonusNumber = inputBonusNumber();
            }
        }
    }
}
