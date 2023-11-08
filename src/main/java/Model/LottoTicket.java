package Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;
    private final int price;

    public LottoTicket(int price) {
        divide(price);
        this.price = price;
        lottos = new ArrayList<>();
        for (int i = 0; i < (price / 1000); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    private void divide(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 1,000으로 나누어 떨어지지 않습니다.");
        }
    }

    public int getPrice() {
        return price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
