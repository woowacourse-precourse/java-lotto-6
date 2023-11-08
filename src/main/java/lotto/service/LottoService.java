package lotto.service;

import lotto.data.LottoRepository;
import lotto.io.output.LottoOutput;

public class LottoService {
    private final LottoRepository lottoRepository;
    private int lottoCnt;

    public LottoService() {
        lottoRepository = new LottoRepository();
    }

    public void start() {
        getSpendMoney();
        getUserLottos();
        getLottoNumber();
        getBonusNumber();
        compareNumbers();
        getResult();
    }

    private void getSpendMoney() {
        LottoOutput.printInputMoney();
        lottoCnt = lottoRepository.getSpendMoney();
        LottoOutput.printNewLine();
    }

    private void getUserLottos() {
        LottoOutput.printConfirmMoney(lottoCnt);
        lottoRepository.getUserLottos(lottoCnt);
    }

    private void getLottoNumber() {
        LottoOutput.printInputLottoNumber();
        lottoRepository.getLottoNumber();
        LottoOutput.printNewLine();
    }

    private void getBonusNumber() {
        LottoOutput.printInputBonusNumber();
        lottoRepository.getBonusNumber();
    }

    private void compareNumbers() {
        lottoRepository.compareNumbers();
        LottoOutput.printNewLine();
    }

    private void getResult() {
        LottoOutput.printGetResult();
        lottoRepository.getResult();
    }
}
