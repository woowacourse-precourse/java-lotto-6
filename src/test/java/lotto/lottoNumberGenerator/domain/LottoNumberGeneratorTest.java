package lotto.lottoNumberGenerator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("6개의 서로 다른 랜덤한 로또 번호를 생성해서 반환한다.")
    @Test
    void 로또_발행() {
        List<Integer> numbers = LottoNumberGenerator.makeLottoNumbers();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }

}
