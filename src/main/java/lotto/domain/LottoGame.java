package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public LottoGame() {
        start();
    }

    private void start() {
        int userLottoPrice = readLottoPrice();
        
    }

    private int readLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());

        if(price % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }
        return price;
    }
}
