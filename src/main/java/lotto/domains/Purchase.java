package lotto.domains;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.PurchaseUnit;
import lotto.utils.Util;
import lotto.validates.PurchaseValidate;

public class Purchase {

    private List<Lotto> lottos;

    public Purchase(int purchaseAmount) {
        PurchaseValidate.validate(purchaseAmount);
        lottos = purchase(purchaseAmount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> purchase(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers;
        Lotto lotto;

        int purchaseUnit = PurchaseUnit.THOUSAND.getValue();
        for (int i = 0; i < purchaseAmount / purchaseUnit; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Util.sortList(numbers);

            lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

}

