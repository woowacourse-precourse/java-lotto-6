package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.EnumGame;
import lotto.service.Game;
import lotto.util.Validator;
import lotto.view.Input;
import lotto.repository.LottoRepository;
import lotto.util.RandomUtil;

public class Controller {
    private Game game;
    private LottoRepository lottoRepository;
    private RandomUtil randomUtil;

    public Controller(Game game) {
        lottoRepository = new LottoRepository(getNumberOfLotto());
        randomUtil = new RandomUtil();
    }

    public void createLotto(){
        for(int i = 0; i < lottoRepository.getNumberOfLotto(); i++){
            setLottoNumbers();
        }
        for(Lotto lotto : lottoRepository.getLottos()){
            System.out.println(lotto.getNumbers());
        }
    }

    private int getNumberOfLotto() {
        boolean isValidate = false;
        String input = "";

        while(!isValidate){
            input = Input.inputBuyPrice();
            isValidate = validateBuyPrice(input);
        }

        return Integer.parseInt(input) / EnumGame.LOTTO_PRICE.getMoney();
    }

    private boolean validateBuyPrice(String input) {
        try{
            Validator.validateRemainderNumber(input);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void setLottoNumbers() {
        lottoRepository.createLotto(new Lotto(randomUtil.getRandomNumbers()));
    }
}