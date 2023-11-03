package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int price = Price.inputPrice();
        int amount = Price.calculateAmount(price);
        System.out.println(amount + "개를 구매했습니다.");

        Lotto[] lottos = Create.createLottos(amount);
        Lotto.printLottos(lottos);
    }





}
