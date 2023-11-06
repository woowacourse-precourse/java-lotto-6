package lotto;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

        Money.inputMoney();
        Money.printLottoNum();

        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<Money.lottoNum;i++){

            Lotto lotto = new Lotto(Lotto.makeLotto());
            lottos.add(lotto);
            lotto.printLotto();

        }



    }
}
