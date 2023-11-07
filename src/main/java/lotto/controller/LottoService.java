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
    private Lotto winngLotto;
    private Integer bonusNumber;
    private Integer userMoney;

    public LottoService(InputView inputView, OutputView outputView, LottoComputer lottoComputer,
                        LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoComputer = lottoComputer;
        this.lottoGenerator = lottoGenerator;
    }

    public void run() {
        configMoneyOfGenerator();

        boughtLottos = lottoGenerator.generateMyLottos();
        outputView.showMyTickets(boughtLottos.toDto());

        configWinningLottoOfComputer();
        configBoughtLottoOfComputer();
        configBonusNumberOfComputer();

        lottoComputer.config(winnerLotto);
        lottoComputer.config(myLottos);
//        lottoComputer.config(bonus);
        outputView.showResult(lottoComputer.simulate());
    }

    private void handleWinnerNumber() {
        outputView.askWinnerNumber();
        while (true) {
            try {
                winnerLotto = Lotto.toLotto(inputView.readWinnerNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    private void handleBonusNumber() {
        outputView.askBonusNumber();
        while (true) {
            try {

                lottoComputer.validateBonus(inputView.readBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void configMoneyOfGenerator() {
        outputView.askMoney();
        while (true) {
            try {
                lottoGenerator.configMoney(inputView.readMoney());
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}