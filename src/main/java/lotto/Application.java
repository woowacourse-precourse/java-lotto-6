package lotto;

import lotto.domain.BuyLotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        buyLotto.inputMoney();

        List<Integer> lottoNumbersPurchased = new ArrayList<>();
        lottoNumbersPurchased = buyLotto.numberLotto();
    }
}
