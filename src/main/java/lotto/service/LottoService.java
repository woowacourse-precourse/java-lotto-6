package lotto.service;

import lotto.constants.Message;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.utils.RandomUtils;

import java.util.*;

public class LottoService {

    private final RandomUtils randomUtils = new RandomUtils();
    private final List<Lotto> buyLottos = new ArrayList<>();

    public List<Lotto> getBuyLottos() {
        return buyLottos;
    }

    public void setBuyLotto(int payMoney) {
        validatePaidAmount(payMoney);

        for (int i = 0; i < payMoney / Value.LOTTO_TICKET_PRICE; i++) {
            List<Integer> numbers = new ArrayList<>(randomUtils.pickSixUniqueRandomNumbers());
            buyLottos.add(new Lotto(numbers));
        }
    }

    private void validatePaidAmount(int payMoney) {
        if (payMoney < Value.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException();
        }

        if ((payMoney % Value.LOTTO_TICKET_PRICE) != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void showBuyLottos() {
        System.out.println(buyLottos.size() + Message.USER_LOTTOS_COUNT_MESSAGE);

        for (Lotto buyLotto : buyLottos) {
            System.out.println(buyLotto.toString());
        }
    }
}
