package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        LottoStore lottoStore = new LottoStore();

        lottoStore.receiveMoney();
    }
}
