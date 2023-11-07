package lotto.service;

import lotto.domain.Client;
import lotto.view.InputView;

public class ClientSVC {
    public void insertLottoNumber(Client client) {
        InputView.insertLottoNumber();
        client.setLotto();
    }

    public void insertBonusNumber(Client client) {
        InputView.insertBonusNumber();
        client.setBonusNum();
    }
}
