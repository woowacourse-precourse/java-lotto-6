package lotto.Input.winningnumber;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import lotto.Either;
import lotto.Lotto;

public class WinningNumberInputContext {

  public static Either<String, Lotto> validatedWinningLotto(String unValidatedNumbers) {
    Either<String, List<Integer>> either = validatedLottoInput(unValidatedNumbers);
    if (either.isLeft()) {
      return Either.left(either.getLeft());
    }
    return validatedLotto(unValidatedNumbers);
  }

  private static Either<String, Lotto> validatedLotto(String unValidatedNumbers) {
    try {
      Lotto lotto = new Lotto(getIntegers(unValidatedNumbers));
      return Either.right(lotto);
    } catch (IllegalArgumentException e) {
      return Either.left("[ERROR]" + e.getMessage());
    }
  }

  private static Either<String, List<Integer>> validatedLottoInput(String unValidatedNumbers) {
    try {
      String regex = "^[,0-9\\s]+$";
      validatedCharacters(unValidatedNumbers, regex);
    } catch (IllegalArgumentException e) {
      return Either.left("[ERROR]" + e.getMessage());
    }
    return Either.right(getIntegers(unValidatedNumbers));
  }

  private static void validatedCharacters(String unValidatedNumbers, String regex) {
    if (!unValidatedNumbers.matches(regex)) {
      throw new IllegalArgumentException("숫자와 쉼표만 입력 가능합니다.");
    }
  }

  private static List<Integer> getIntegers(String unValidatedNumbers) {
    return Arrays.stream(unValidatedNumbers.split(",")).mapToInt(Integer::parseInt)
        .boxed().toList();
  }
}
