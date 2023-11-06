package lotto.service;

import lotto.domain.Client;

public class ClientSVC {
    public void insertLottoNumber(Client client) {
        client.setLotto();
    }

    public void insertBonusNumber(Client client) {
        client.setBonusNum();
    }
}
