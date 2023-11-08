package lotto.controller;

import lotto.domain.EnumLotto;
import lotto.domain.Lotto;
import lotto.service.Game;
import lotto.view.Input;
import lotto.view.Output;
import lotto.repository.LottoRepository;
import lotto.util.RandomUtil;

public class Controller {
    private final Game game;
    private final LottoRepository lottoRepository;
    private final RandomUtil randomUtil;
    private final Output output;
    private final Input input;

    public Controller(Game game, LottoRepository lottoRepository, Input input) {
        this.game = game;
        this.lottoRepository = lottoRepository;
        this.input = input;
        this.output = new Output(lottoRepository);
        randomUtil = new RandomUtil();
    }

    public void createLotto() {
        setBuyNumberOfLotto();
        setLottoNumbers();
    }

    public void printLottoGameResult() {
        output.printGameResult(game.getRankCount());
        output.printGameResult(game.getEarningsRate());
    }

    private void setBuyNumberOfLotto() {
        int numberOfLotto = input.inputValidateNumberOfLotto(EnumLotto.LOTTO_PRICE.getNumber());
        lottoRepository.setNumberOfLotto(numberOfLotto);
        output.printBuyNumberOfLotto();
    }

    private void setLottoNumbers() {
        for(int i = 0; i < lottoRepository.getNumberOfLotto(); i++) {
            createLottoNumbers();
        }
        output.printGetLottoNumbers();
    }

    private void createLottoNumbers() {
        lottoRepository.createLotto(new Lotto(randomUtil.getRandomNumbers()));
    }
}