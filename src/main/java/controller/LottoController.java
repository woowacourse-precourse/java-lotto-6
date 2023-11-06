package controller;

import controller.validator.WinningNumberValidator;

import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.Price;
import domain.WinningLotto;
import domain.repository.LottoRepository;

import java.util.List;

import view.InputView;
import view.OutputView;

public class LottoController {

    private Price price;
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private WinningLotto winningLotto = new WinningLotto();

    public void run() {
        initPriceByUserInput();
        printNumOfLotto(price.numOfLotto());
        createLotto();
        showLottoTicket();
    }

    private List<Integer> initWinningNumber() {
        try {
            String input = InputView.enterWinningNumbers();
            List<Integer> winningNumber = winningNumberValidator.checkWinningNumberValidation(input);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            return initWinningNumber();
        }
    }

    private void showLottoTicket() {
        for(Lotto lotto : lottoRepository.getAllLotto()) {
            OutputView.printLottoTickets(lotto.getNumbers());
        }
    }

    private void createLotto() {
        for(int i=0;i<price.numOfLotto();i++) {
            lottoRepository.save(new Lotto(lottoNumberGenerator.createLottoNumber()));
        }
    }

    private void printNumOfLotto(int number) {
        OutputView.printEmptyLine();
        OutputView.printNumOfLotto(number);
    }

    private void initPriceByUserInput() {
        try {
            String input = InputView.enterPrice();
            price = new Price(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            initPriceByUserInput();
        }
    }
}