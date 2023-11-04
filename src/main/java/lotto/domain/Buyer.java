package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private ArrayList<Lotto> Lotteries = new ArrayList<>();
    private int price;

    public Buyer(int price) {
        this.price = price;
    }
    public int calculationAmount(int price){
            return price/1000;
    }

    public static List<Integer> makeLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void makeLotteries(){
        List<Integer> lottoNumber = makeLottoNumber();
        int amount = calculationAmount(price);
        for (int i = 0; i < amount; i ++ ){
            Lotto lotto = new Lotto(lottoNumber);
            Lotteries.add(lotto);
        }
    }


}
