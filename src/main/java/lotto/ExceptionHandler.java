package lotto;

import java.util.Arrays;
import java.util.List;

public class ExceptionHandler {
  public static final String ERROR_01 = "[ERROR] 아무것도 입력하지 않았습니다.";
  public static final String ERROR_02 = "[ERROR] 숫자 이외의 문자를 입력하였습니다.";
  public static final String ERROR_03 = "[ERROR] 구입 금액이 1000원 단위가 아닙니다.";
  public static final String ERROR_04 = "[ERROR] 숫자의 갯수가 올바르지 않습니다.";
  public static final String ERROR_05 = "[ERROR] 숫자가 범위가 올바르지 않습니다.";
  public static final String ERROR_06 = "[ERROR] 중복되는 숫자가 입력되었습니다.";


  public int purchaseAmountException(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException(ERROR_01);
    } else if (!input.chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException(ERROR_02);
    }
    int purchaseAmount = Integer.parseInt(input);
    if (purchaseAmount % 1000 != 0) {
      throw new IllegalArgumentException(ERROR_03);
    }
    return purchaseAmount;
  }

  public Lotto lottoNumException(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException(ERROR_01);
    } else if (!input.replaceAll(", ", "").chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException(ERROR_02);
    }
    List<Integer> lottoNum = Arrays.stream(input.split(","))
      .map(Integer::valueOf).toList();
    // If there is an exception within the Lotto constructor
    // it is propagated back to the input class
    return new Lotto (lottoNum);
  }

  public int bonusNumException(List<Integer> lottoNum, String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException(ERROR_01);
    } else if (!input.chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException(ERROR_02);
    }
    int bonusNum = Integer.parseInt(input);
    if ((bonusNum < 1) || (bonusNum > 45)) {
      throw new IllegalArgumentException(ERROR_05);
    } else if (lottoNum.contains(bonusNum)) {
      throw new IllegalArgumentException(ERROR_06);
    }
    return bonusNum;
  }
}
