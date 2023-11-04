package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final User user;

    public LottoGame(User user) {
        this.user = user;
    }

    public void printLottos(List<Lotto> lotts) {
        for (Lotto lo : lotts) {
            System.out.println(lo.getNumbers());
        }
    }


}
