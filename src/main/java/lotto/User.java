package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static final int LOTTO_PRICE = Price.LOTTO.getLottoPrice();
    private int haveSeveralLotto = 0;

    // 구입 금액 입력 및 로또 갯수 반환
    public int inputAmount() {
        int allLottoPay = Integer.parseInt(Console.readLine());

        if(allLottoPay % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[Error] 로또 구입 금액이 맞지 않습니다.");
        }
        haveSeveralLotto = allLottoPay/LOTTO_PRICE;
        return haveSeveralLotto;
    }



}
