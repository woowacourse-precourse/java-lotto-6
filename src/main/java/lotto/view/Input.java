package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {


    public int insertMoney() {
          System.out.println("구입금액을 입력해 주세요.");
          int money = Integer.parseInt(Console.readLine().trim());
          return money;
      }
}
