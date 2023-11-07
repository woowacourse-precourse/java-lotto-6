package lotto.controller;

import lotto.domin.PlayerLottoAmount;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayerLottoAmount playerLottoAmount = null;
        playerLottoAmount = getPlayerLottoAmount(playerLottoAmount);


    }

    private static PlayerLottoAmount getPlayerLottoAmount(PlayerLottoAmount playerLottoAmount) {
        while (true) {
            try {
                return playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayPay());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
