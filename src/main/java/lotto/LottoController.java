package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class LottoController {

    private LottoGame lg = new LottoGame();
    private PriceValidator priceValidator = new PriceValidator();
    private int price = 0;
    private List<Lotto> lottoList;
    private Lotto winningNumber;

    public boolean validatePrice(String number){
        if(!priceValidator.validateNumber(number)) {
            return false;
        }
        price = Integer.parseInt(number);
        if(!priceValidator.validateThousands(price)) {
            return false;
        }
        return true;
    }
    public List<Integer> lottoMaker(){
        List<Integer> lotto = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            int random = Randoms.pickNumberInRange(1,45);
            if(lotto.contains(random)){
                i--;
                continue;
            }
            lotto.add(random);
        }
        return lotto;
    }
    public void buyLotto(){
        lottoList = new ArrayList<>();
        lottoList.add(new Lotto(lottoMaker()));
    }
}
