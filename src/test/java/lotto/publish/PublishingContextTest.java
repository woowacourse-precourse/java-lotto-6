package lotto.publish;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.IntFunction;
import lotto.Either;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PublishingContextTest {

  @DisplayName("발행 테스트")
  @Test
  void publish() {
    // given
    int startInclusive = 1;
    int endInclusive = 45;
    int count = 6;
    IssuedNumber issuedNumber = IssuedNumber.of(3).getRight();
    IntFunction<List<Integer>> intToListFunction = (i) -> Randoms.pickUniqueNumbersInRange(
            startInclusive, endInclusive, count)
        .stream().toList();

    // when
    Either<String, List<Lotto>> publish = IssuingContext.publish(issuedNumber,intToListFunction);

    // then
    assertThat(publish.isRight()).isTrue();
    assertThat(publish.getRight().get(0).getNumbers()).isSorted();
    assertThat(publish.getRight()).hasSize(issuedNumber.getValue());
    assertThat(publish.getRight().stream().map(Lotto::size).allMatch(size -> size == count)).isTrue();
    assertThat(publish.getRight().stream().map(Lotto::getNumbers)
        .flatMap(List::stream)
        .allMatch(i -> i >= startInclusive && i <= endInclusive)).isTrue();
  }

  @DisplayName("중복 발행시 중복 발생 메시지 반환")
  @Test
  void if_lotto_list_duplicated() {
    // given
    IssuedNumber issuedNumber = IssuedNumber.of(3).getRight();

    // when
    Either<String, List<Lotto>> lists = IssuingContext.publish(
        issuedNumber, (i) -> List.of(1, 2, 3, 4, 5, 6));

    // then
    assertThat(lists.isLeft()).isTrue();
    assertThat(lists.getLeft()).isEqualTo("중복 발생");
  }
}