package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <pre>
 * Collections.unmodifiableList(), List.copyOf() 학습 테스트
 *
 * 불변 객체를 생성할 때 어떤 방식으로 방어적 복사를 수행해야 할까?
 * Collections.unmodifiableList는 원본 리스트 참조를 그대로 가져오기 때문에 원본 리스트의 변화에 영향을 받는다.
 * List.copyOf는 원소를 가지고 새로운 ImmutableList에 넣기 때문에 원본 리스트의 변화에 영향을 받지 않는다.
 *
 * 결론: 불변 객체를 생성할 때는 List.copyOf를 사용하자. (만약 참조 필드가 있으면 해당 필드 모두 불변이어야 함)
 * </pre>
 */
class ImmutableTest {

    @DisplayName("Collections.unmodifiableList()은 원본 리스트의 변화를 따라간다")
    @Test()
    void CollectionsUnmodifiableListTest() {
        List<Integer> origin = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        UnmodifiableLottoBag unmodifiableLottoBag = new UnmodifiableLottoBag(origin);

        origin.add(45);

        List<Integer> unmodifiableLottos = unmodifiableLottoBag.getLottos();
        assertThat(unmodifiableLottos).size().isEqualTo(7);
    }

    @DisplayName("List.copyOf()는 원본 리스트의 변화에 영향이 없다")
    @Test()
    void ListCopyOfTest() {
        List<Integer> origin = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        ListCopyOfLottoBag listCopyOfLottoBag = new ListCopyOfLottoBag(origin);

        origin.add(45);

        List<Integer> listCopyOfLottos = listCopyOfLottoBag.getLottos();
        assertThat(listCopyOfLottos).size().isEqualTo(6);
    }

    private static class UnmodifiableLottoBag {
        private final List<Integer> Lottos;

        UnmodifiableLottoBag(List<Integer> lottos) {
            Lottos = java.util.Collections.unmodifiableList(lottos);
        }

        public List<Integer> getLottos() {
            return Lottos;
        }
    }

    private static class ListCopyOfLottoBag {
        private final List<Integer> Lottos;

        ListCopyOfLottoBag(List<Integer> lottos) {
            Lottos = List.copyOf(lottos);
        }

        public List<Integer> getLottos() {
            return Lottos;
        }
    }
}
