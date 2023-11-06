package lotto.publish;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.IntFunction;
import lotto.Either;
import lotto.Lotto;

public class IssueLottoContext {

  private IssueLottoContext() {
  }

  public static IssuedLottoEvent issue(IssueLottoCommand command) {
    Either<String, List<Lotto>> publish = IssuingContext.publish(command.getIssuedNumber(),
        getIntFunction());
    if (publish.isLeft()) {
      throw new IllegalArgumentException(publish.getLeft());
    }
    return IssuedLottoEvent.of(command.getIssuedNumber(), publish.getRight());
  }

  private static IntFunction<List<Integer>> getIntFunction() {
    return (number) -> Randoms.pickUniqueNumbersInRange(LottoIssueRule.START_INCLUSIVE.getValue(),
        LottoIssueRule.END_INCLUSIVE.getValue(), LottoIssueRule.COUNT.getValue());
  }
}
