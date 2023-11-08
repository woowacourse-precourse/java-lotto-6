package lotto.lotto.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoRepositoryImplTest {

    LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl();

    @BeforeEach
    void before() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
        lottoRepository.saveLotto(numbers);
        lottoRepository.saveLotto(numbers);
    }

    @Test
    @DisplayName("발행된 랜덤 복권 1개 찾기 테스트")
    void findOneTest() {
        Assertions.assertThat(lottoRepository.findOne(1).getNumbers().get(5)).isEqualTo(6);
    }

    @Test
    @DisplayName("발행된 모든 랜덤 복권 찾기 테스트")
    void findAllTest() {
        Assertions.assertThat(lottoRepository.findAll().size()).isEqualTo(2);
    }
}