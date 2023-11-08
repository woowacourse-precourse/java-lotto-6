package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.LottoGame;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoGame lottoGame=new LottoGame();
        lottoGame.gameStart();
    }
}
