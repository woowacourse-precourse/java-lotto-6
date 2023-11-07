package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.outputMessage;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private final ArrayList<Lotto> lotteries = new ArrayList<>();
    private final int price;

    public ArrayList<Lotto> getLotteries() {
        return lotteries;
    }

    public Buyer(int price) {
        this.price = price;
        makeLotteries();
        outputMessage.buyMessage(lotteries);
    }

    private void makeLotteries() {
        int amount = calculationAmount(price);
        for (int i = 0; i < amount; i++) {
            List<Integer> lottoNumber = makeLottoNumber();
            Lotto lotto = new Lotto(lottoNumber);
            lotteries.add(lotto);
        }
    }

    private int calculationAmount(int price) {
        return price / 1000;
    }

    private List<Integer> makeLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
