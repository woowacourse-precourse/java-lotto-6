package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private User user;

    public GameManager() {
        this.user = new User();
    }

    public void startGame(){
        user.payMoney();
        user.buyLottos();
        user.showMyLottos();
        user.predictWinningNumber();
    }



}
