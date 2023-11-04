package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.outputMessage;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private ArrayList<Lotto> Lotteries = new ArrayList<>();
    private int price;

    public Buyer(int price) {
        this.price = price;
        makeLotteries();
        outputMessage.buyMessage(Lotteries);
    }
    public void makeLotteries(){
        int amount = calculationAmount(price);
        for (int i = 0; i < amount; i ++ ){
            List<Integer> lottoNumber = makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            Lotteries.add(lotto);
        }
    }
    public int calculationAmount(int price){
            return price/1000;
    }

    public static List<Integer> makeLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }






}
