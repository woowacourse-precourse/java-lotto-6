package controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {

  public void start() {
    int money = inputMoney();


  }


  public int inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    int money = Integer.parseInt(Console.readLine());
    validateMoney(money);
    return money;
  }

  public void validateMoney(int money) {
    if(money % 1000 != 0) {
      throw new IllegalArgumentException();
    }
  }




}
