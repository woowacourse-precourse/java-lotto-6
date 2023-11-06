package controller;

import controller.validator.BonusNumberValidator;
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
    private BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private WinningLotto winningLotto = new WinningLotto();

    public void run() {
        initPriceByUserInput();
        printNumOfLotto(price.numOfLotto());
        createLotto();
        showLottoTicket();
        initWinningNumber();
        initBonusNumber();
    }

    private void initBonusNumber() {
        try{
            OutputView.printEmptyLine();
            String input = InputView.enterBonusNumbers();
            int bonusNumber = bonusNumberValidator.checkBonusNumberValidation(input);
            winningLotto.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            initBonusNumber();
        }
    }

    private void initWinningNumber() {
        try {
            OutputView.printEmptyLine();
            String input = InputView.enterWinningNumbers();
            List<Integer> winningNumber = winningNumberValidator.checkWinningNumberValidation(input);
            winningLotto.setWinningNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            initWinningNumber();
        }
    }

    private void showLottoTicket() {
        OutputView.printEmptyLine();
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
            OutputView.printEmptyLine();
            String input = InputView.enterPrice();
            price = new Price(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            initPriceByUserInput();
        }
    }
}