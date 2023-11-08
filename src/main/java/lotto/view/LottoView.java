package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class LottoView {
    private static final String LOTTO_BUY_MESSAGE= "개를 구매했습니다.";


    //로또 몇장
    public void printLottoAmount(int lottoAmount){
        System.out.println(lottoAmount+LOTTO_BUY_MESSAGE);
    }

    //로또 번호
    public void printLottoNumber(List<Integer> numbers){
        System.out.println(numbers);
    }
}
