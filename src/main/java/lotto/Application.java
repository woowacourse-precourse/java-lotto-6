package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        /*
        // 로또 당첨 금액 ENUM
        enum LottoAmount {
            FIFTH(5000), FOURTH(50000), THIRD(1500000), SECOND(30000000), FIRST(2000000000);

            private final int value;

            LottoAmount(int value) { this.value = value; }

            public int getValue() { return value; }
        }
         */

        // 입력 1. 로또 구입 금액 1000원 단위로 입력 받기
        int purchaseAmount = Integer.parseInt(Console.readLine());

        // -1000원으로 안 나누어지면 예외처리
        try {
            if(purchaseAmount % 1000 != 0){
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        // 게임 1. 구입금액에 따른 로또 구매 개수 구하기
        int lottoCount = purchaseAmount / 1000;



        // 입력 2. 쉼표 기준으로 구분해서 당첨 번호 입력 받기










    }
}
