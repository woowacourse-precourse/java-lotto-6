package controller;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import model.Grader;
import model.Lotto;
import model.WinningLotto;
import view.PrintError;
import view.PrintResult;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Store {

  private final PrintError printError = new PrintError();
  private final WinningLotto winningLotto = new WinningLotto();

  // 로또 시작
  public void start() {
    int money = inputMoney();
    List<Lotto> lottos = giveLotto(money);
    WinningLotto winningLotto = inputWinningLotto();

    Grader grader = new Grader();
    List<Integer> winningDetails = grader.compareLottoWinningLotto(lottos, winningLotto);
    BigDecimal earningRatio = grader.calculateEarningRatio(money, winningDetails);

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
        validateIsNumber(moneyInput);
        money = Integer.parseInt(moneyInput);
        validateUnitOfThousandMoney(money);
        isValid = true;
      } catch (IllegalArgumentException e) {
      }
    }
    return money;
  }


  // 구입 금액이 숫자인지 확인
  public void validateIsNumber(String money) {
    for(char c : money.toCharArray()) {
      if(!Character.isDigit(c)) {
        printError.moneyNotNumber();
        throw new IllegalArgumentException();
      }
    }
  }


  // 구입 금액이 1000단위로 나누어 떨어지는지 확인
  public void validateUnitOfThousandMoney(int money) {
    if(money % 1000 != 0 || money == 0) {
      printError.moneyUnitOfThousand();
      throw new IllegalArgumentException();
    }
  }


  // 구입 금액만큼 로또 발급
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


  // 로또 번호 생성
  public List<Integer> makeLottoNumber() {
    return Randoms.pickUniqueNumbersInRange(1, 45, 6);
  }


  // 당첨 번호와 보너스 번호 입력
  public WinningLotto inputWinningLotto() {
    // 당첨 번호 입력
    List<Integer> numbers = inputWinningNumbers();
    // 보너스 번호 입력
    Integer bonusNumber = inputBonusNumber(numbers);
    return new WinningLotto(numbers, bonusNumber);
  }


  // 당첨 번호 입력
  public List<Integer> inputWinningNumbers() {

    boolean isValid = false;
    List<Integer> numbers = new ArrayList<>();
    while (!isValid) {
      System.out.println("당첨 번호를 입력해 주세요");
      String inputWinningNumbers = Console.readLine();
      numbers = new ArrayList<>();
      try {
        validateNumbersIsNumber(inputWinningNumbers);
        String[] inputWinningNumbersSplit = inputWinningNumbers.split(",");
        for(String number : inputWinningNumbersSplit) {
          numbers.add(Integer.parseInt(number));
        }
        winningLotto.validateNumbers(numbers);
        isValid = true;
      } catch (IllegalArgumentException e) {
      }
    }
    return numbers;
  }


  // 입력 받은 숫자들이 숫자인지 확인
  public void validateNumbersIsNumber(String numbersInput) {
    String[] numberInput = numbersInput.split(",");
    for(String number : numberInput) {
      validateIsNumber(number);
    }
  }


  // 보너스 번호 입력
  public Integer inputBonusNumber(List<Integer> numbers) {
    boolean isValid = false;
    int bonusNumber = 0;

    while (!isValid) {
      System.out.println("보너스 번호를 입력해 주세요");
      String inputBonusNumber = Console.readLine();
      try {
        validateIsNumber(inputBonusNumber);
        bonusNumber = Integer.parseInt(inputBonusNumber);
        winningLotto.validateBonusNumber(numbers, bonusNumber);
        isValid = true;
      } catch (IllegalArgumentException e) {
      }
    }
    return bonusNumber;
  }


}
