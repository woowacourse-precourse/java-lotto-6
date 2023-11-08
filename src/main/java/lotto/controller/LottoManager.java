package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.Customer;
import lotto.domain.Lucky;
import lotto.domain.ResultRepository;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManager {
    private Customer customer;
    private LottoService lottoService;
    private InputView inputView=new InputView();
    private OutputView outputView=new OutputView();
    private ResultRepository resultRepository=new ResultRepository();

    public void buyLotto(){
        customer=new Customer(inputView.inputMoney());
        customer.pay();
        outputView.printCount(customer.getLottos().size());
        showLottoList();
        playLotto();
    }

    private void showLottoList(){
        customer.getLottos().stream()
                .forEach(lotto->outputView.printLotto(lotto));
    }

    private void playLotto(){
        checkLucky();
        showStatistics();
        solveRateOfReturn();
    }
    private void checkLucky(){
        String luckyNumber=inputView.inputLucky();
        int bonus=inputView.inputBonus();
        Lucky lucky=new Lucky(luckyNumber,bonus);
        resultRepository.init();
        customer.getLottos().stream()
                .forEach(lotto->resultRepository.save(lucky.checkWinning(lotto)));
    }

    private void showStatistics(){
        outputView.printWinningStatistics(resultRepository);
    }

    private void solveRateOfReturn(){
        Calculator calculator=new Calculator();
        outputView.printRateOfReturn(calculator.getRateOfReturn());
    }
}
