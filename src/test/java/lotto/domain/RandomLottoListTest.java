package lotto.domain;

import lotto.global.utils.generator.RandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RandomLottoListTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @DisplayName("랜덤으로 생성한 6자리 List를 오름차순으로 정렬한다.")
    @Test
    void sortRandomLottoNumberByAscending() {
//        given
        RandomLottoList randomLottoList = new RandomLottoList(randomNumberGenerator);
        List<Integer> sortedLottoList = randomLottoList.getRandomLottoList();

//        whenAndThen
        for (int i = 0; i < sortedLottoList.size() - 1; i++) {
            Assertions.assertTrue(sortedLottoList.get(i) < sortedLottoList.get(i + 1));
        }
    }
}