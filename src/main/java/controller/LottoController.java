package controller;

import domain.Lotto;
import domain.LottoNumberGenerator;
import domain.Price;
import domain.repository.LottoRepository;
import view.InputView;

public class LottoController {

    private Price price;
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public void run() {

    private void createLotto() {
        int numOfLotto = price.numOfLotto();
        for(int i=0;i<numOfLotto;i++) {
            lottoRepository.save(new Lotto(lottoNumberGenerator.createLottoNumber()));
        }
    }

    private void getPriceByUserInput() {
        try {
            int input = InputView.enterPrice();
            price = new Price(input);
        } catch (IllegalArgumentException e) {
            getPriceByUserInput();
        }
    }
}
