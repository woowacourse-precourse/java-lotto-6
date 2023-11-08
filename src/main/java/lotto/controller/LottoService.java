package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoComputer;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoService {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final LottoComputer lottoComputer;
    private Lottos boughtLottos;

    public LottoService(InputView inputView, OutputView outputView, LottoComputer lottoComputer,
                        LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoComputer = lottoComputer;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        configMoneyOfGenerator();

        boughtLottos = lottoGenerator.generateLottos();

        outputView.showMyTickets(boughtLottos.toDto());

        configWinningLottoOfComputer();
        configBoughtLottoOfComputer();
        configBonusNumberOfComputer();

        outputView.showResult(lottoComputer.simulate());
    }

    private void configBoughtLottoOfComputer() {
        lottoComputer.configBoughtLottos(boughtLottos);
    }

    private void configWinningLottoOfComputer() {
        outputView.askWinningLotto();
        while (true) {
            try {
                lottoComputer.configWinningLotto(Lotto.toLotto(inputView.read()));
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void configBonusNumberOfComputer() {
        outputView.askBonusNumber();
        while (true) {
            try {
                lottoComputer.configBonus(inputView.read());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void configMoneyOfGenerator() {
        outputView.askMoney();
        while (true) {
            try {
                lottoGenerator.configMoney(inputView.read());
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}