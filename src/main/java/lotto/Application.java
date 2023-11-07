package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            LottoSystem lottoSystem = new LottoSystem();
            lottoSystem.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }

    }
}
