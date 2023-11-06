package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoService {

    private final InputView inputView;
    private final OutputView outputView;
    private LottoGenerator lottoGenerator;
    private Integer userMoney;
    private Lottos myLottos;
    private Integer myBonusNumber;
    private Lotto winnerLotto;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        handleUserMoney();

        myLottos = lottoGenerator.generateMyTickets();
        outputView.showMyTickets(myLottos.toDto());

//        handleWinnerNumber();
//        handleBonusNumber();
//
//        LottoComputer lottoComputer = new LottoComputer(winnerLotto, myBonusNumber); // myLottos use DTO
//        outputView.showResult(lottoComputer.simulate());
    }

    private void handleBonusNumber() {
        outputView.askBonusNumber();
        inputView.readBonusNumber();
    }

    private void handleWinnerNumber() {
        outputView.askWinnerNumber();
        inputView.readWinnerNumber();
    }

    private void handleUserMoney() {
        outputView.askMoney();
        while (true) {
            try {
                lottoGenerator = new LottoGenerator(inputView.readMoney());
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}