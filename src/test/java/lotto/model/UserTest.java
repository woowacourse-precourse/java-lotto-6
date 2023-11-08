package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("발행한 로또 수 만큼 오름 차순 정렬 검증")
    public void 로또_오름차순_정렬() {
        User user = new User(3);

        List<List<Integer>> lottoCount = user.getLottoCount();

        for (List<Integer> lotto : lottoCount) {
            List<Integer> sortedLotto = lotto.stream()
                    .sorted()
                    .collect(Collectors.toList());
            assertEquals(sortedLotto, lotto);
        }
    }
}