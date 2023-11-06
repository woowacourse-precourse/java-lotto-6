package controller;

import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.Price;
import domain.repository.LottoRepository;
import view.InputView;
import view.OutputView;

public class LottoController {

    private Price price;
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public void run() {
        initPriceByUserInput();
        printNumOfLotto(price.numOfLotto());
        createLotto();
        showLottoTicket();
    }

    private void get

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