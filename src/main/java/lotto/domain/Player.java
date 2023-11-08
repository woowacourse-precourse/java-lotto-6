package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Player {
    int money;
    List<Lotto> lottos;



    //로또를 구매하는 기능
    //로또를 발행하는 기능을 포함하고 있다. 리팩토링 대상
    public List<Lotto> purchaseLotto(int purchaseQuantity) {
        int lottoAmount = purchaseQuantity/1000;
        money = purchaseQuantity%1000;
        List<Lotto> issuedLotto = new ArrayList<>();

        for(int i=0; i<lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            issuedLotto.add(lotto);
        }

        lottos = issuedLotto;
        return issuedLotto;
    }

}
