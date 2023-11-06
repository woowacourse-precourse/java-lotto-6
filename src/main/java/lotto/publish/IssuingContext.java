package lotto.publish;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import lotto.Either;
import lotto.Lotto;

public class IssuingContext {

  private IssuingContext() {
  }

  public static Either<String, List<Lotto>> publish(IssuedNumber issuedNumber,
      IntFunction<List<Integer>> generator) {
    int publishingNumberValue = issuedNumber.getValue();
    List<List<Integer>> generate = generate(publishingNumberValue, generator);
    if (generate.size() != publishingNumberValue) {
      return Either.left("중복 발생");
    }
    return Either.right(generate.stream().map(Lotto::new).toList());
  }

  private static List<List<Integer>> generate(Integer n, IntFunction<List<Integer>> generator) {
    return IntStream.range(0, n)
        .mapToObj(generator)
        .map(list -> list.stream().sorted().toList())
        .distinct()
        .toList();
  }
}