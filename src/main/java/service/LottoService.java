package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Lottos;
import domain.Player;
import utils.Validator;

import java.util.Collections;
import java.util.List;

public class LottoService {
    private Player player;
    private Lottos lottos = new Lottos();

    public void buyLotto(int input) {
        lottos = new Lottos();
        Validator.checkMoney(input);

    }

}
