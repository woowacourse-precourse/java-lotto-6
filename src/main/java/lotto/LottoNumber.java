package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class LottoNumber {
  public List<Integer> lottoNumber() {
    System.out.println("당첨 번호를 입력해 주세요.");
    List<Integer> winningNumbers = readNumbers(Console.readLine());
    Collections.sort(winningNumbers);

    return winningNumbers;

  }

  public int bonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    int bonusNumber = Integer.parseInt(Console.readLine());

    return bonusNumber;
  }

  // 쉼표로 구분된 숫자 문자열 -> 정수 리스트
  private static List<Integer> readNumbers(String readLine) {

    return List.of(readLine.split(",")).stream().map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
