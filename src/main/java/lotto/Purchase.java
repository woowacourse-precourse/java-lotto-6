package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {

    public void process(){

        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());

        int lottoCount = checkLottoCount(money);
        System.out.println("구매 로또 수 : " + lottoCount);
    }

    public int checkLottoCount(int money){
        int lottoCount = money / 1000;
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액을 확인해주세요. 1장당 1000원");
        }

        return lottoCount;
    }
}
