package controller;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import model.Grader;
import model.Lotto;
import model.WinningLotto;
import view.PrintError;
import view.PrintResult;

import java.util.ArrayList;
import java.util.List;

public class Store {

  private final PrintError printError = new PrintError();

  // 로또 시작
  public void start() {
    int money = inputMoney();
    List<Lotto> lottos = giveLotto(money);
    WinningLotto winningLotto = inputWinningLotto();

    Grader grader = new Grader();
    List<Integer> winningDetails = grader.compareLottoWinningLotto(lottos, winningLotto);
    double earningRatio = grader.calculateEarningRatio(money, winningDetails);

    PrintResult printResult = new PrintResult();
    printResult.winningDetailPrint(winningDetails);
    printResult.earningRatioPrint(earningRatio);
  }


  // 구입 금액 입력
  public int inputMoney() {
    boolean isValid = false;
    int money = 0;

    while(!isValid) {
      System.out.println("구입금액을 입력해 주세요.");
      String moneyInput = Console.readLine();

      try {
        validateMoneyIsNumber(moneyInput);
        money = Integer.parseInt(moneyInput);
        validateUnitOfThousandMoney(money);
        isValid = true;
      } catch (IllegalArgumentException e) {

      }
    }

    return money;
  }

  // 구입 금액이 숫자인지 확인
  public void validateMoneyIsNumber(String money) {
    for(char c : money.toCharArray()) {
      if(!Character.isDigit(c)) {
        printError.moneyNotNumber();
        throw new IllegalArgumentException();
      }
    }
  }

  // 구입 금액이 1000단위로 나누어 떨어지는지 확인
  public void validateUnitOfThousandMoney(int money) {
    if(money % 1000 != 0) {
      printError.moneyUnitOfThousand();
      throw new IllegalArgumentException();
    }
  }



  public List<Lotto> giveLotto(int money) {
    int count = money / 1000;
    System.out.println("\n" + count + "개를 구매했습니다.");
    List<Lotto> lottos = new ArrayList<>();
    for(int i = 0; i < count; i++) {
      List<Integer> number = makeLottoNumber();
      Lotto lotto = new Lotto(number);
      lotto.printLotto();
      lottos.add(lotto);
    }
    return lottos;
  }

  public List<Integer> makeLottoNumber() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }

  public WinningLotto inputWinningLotto() {
    System.out.println("당첨 번호를 입력해 주세요");
    String numbersInput = Console.readLine();
    System.out.println("보너스 번호를 입력해 주세요");
    int bonusNumber = Integer.parseInt(Console.readLine());

    List<Integer> numbers = new ArrayList<>();
    String[] numberInputSplit = numbersInput.split(",");
    for(String number : numberInputSplit) {
      numbers.add(Integer.parseInt(number));
    }
    return new WinningLotto(numbers, bonusNumber);
  }







}
