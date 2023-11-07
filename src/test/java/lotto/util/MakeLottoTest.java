package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MakeLottoTest {

    @Test
    @DisplayName("랜덤 번호 생성 함수가 잘 작동하는 지 확인하는 테스트")
    public void getRandomNumbers() {
        int MIN_NUM = 1;
        int MAX_NUM = 45;
        int SIZE = 6;

        List<Integer> randomNumbers = MakeRandomNumbers.getRandomNumbers();

        assertNotNull(randomNumbers);
        assertEquals(SIZE, randomNumbers.size());
        assertTrue(randomNumbers.stream().allMatch(num -> num >= MIN_NUM && num <= MAX_NUM));

        Set<Integer> uniqueNumbers = randomNumbers.stream().collect(Collectors.toSet());
        assertEquals(randomNumbers.size(), uniqueNumbers.size());

        List<Integer> sortedNumbers = randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
        assertIterableEquals(sortedNumbers, randomNumbers);
    }

    @Test
    @DisplayName("수를 받고 그 수 만큼 로또를 만드는지 확인")
    void makeLottoList(){
        int lottoTicket = 6;
        List<Lotto> list = new MakeLotto().makeLottoList(lottoTicket);
        assertEquals(list.size(),6);
    }
}
