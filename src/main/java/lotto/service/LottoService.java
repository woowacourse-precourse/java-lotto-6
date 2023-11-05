package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Seller;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    InputView inputView;
    Seller seller;
    public LottoService() {
        this.inputView = new InputView();
        this.seller = new Seller();
    }

    public List<Lotto> purchaseLotto() {
        boolean purchased = false;
        List<Lotto> lottos = new ArrayList<>();

        while (!purchased) {
            try {
                int payment = inputView.requestPurchaseOfLotto();
                lottos = seller.sellLotto(payment);
                purchased = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottos;
    }
}
