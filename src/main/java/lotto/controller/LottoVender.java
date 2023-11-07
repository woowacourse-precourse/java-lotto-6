package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVender {
    private final int LOTTO_PRICE = 1000;
    private int inputPrice;
    private int lottoCount;

    public int getLottoCount() {
        return lottoCount;
    }
    public int getInputPrice() {
        return inputPrice;
    }

    /*public void start(){
        InputView inputview = new InputView();
        inputPrice = inputview.inputLottoPrice();
        payPrice(inputPrice);
        getLotto(lottoCount);
    }*/

    public void payPrice(int inputPrice){
        int buyLottoCount;
        lottoCount = inputPrice / LOTTO_PRICE;
    }

    public List<Lotto> getLotto(int buyLottoCount){
        List<Lotto> lottoticekts = new ArrayList<>();
        for(int i = 0; i<buyLottoCount; i++){
            //6개의 랜덤 로또 번호 생성해주는 numbers
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoticekts.add(new Lotto(numbers));
        }
        return lottoticekts;
    }

}
