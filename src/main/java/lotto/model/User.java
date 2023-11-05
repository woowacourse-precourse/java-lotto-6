package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos;

    private User(int numberOfLotto) {
        lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    public static User purchaseLottos(PurchaseAmount purchaseAmount) {
        int numberOfLotto = purchaseAmount.divideByThousand();
        return new User(numberOfLotto);
    }

    public String getAllLottoTicketsNumbers() {
        String result = "";

        for (Lotto lotto : lottos) {
            result += lotto.getLottoNumbers();
            result += "\n";
        }

        return result;
    }

    public int getNumberOfLottoTickets() {
        return lottos.size();
    }
}
