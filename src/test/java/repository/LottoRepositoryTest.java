package repository;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoRepositoryTest {
    LottoRepository lottoRepository = new LottoRepository(3);


    @BeforeEach
    void clearRepository(){
        lottoRepository.clear();
    }

    @Test
    void repository_사이즈체크(){
        List<List<Integer>> lottoList = new ArrayList<>(3);

        lottoList.add(new ArrayList<>(List.of(1,2,3,4,5,6)));
        lottoList.add(new ArrayList<>(List.of(2,3,4,5,6,7)));
        lottoList.add(new ArrayList<>(List.of(3,4,5,6,7,8)));

        lottoRepository.add(lottoList.get(0));
        lottoRepository.add(lottoList.get(1));
        lottoRepository.add(lottoList.get(2));

        Assertions.assertThat(lottoRepository.size()).isEqualTo(3);
    }
    @Test
    void 로또추가(){
        lottoRepository = new LottoRepository(3);
        List<List<Integer>> lottoList = new ArrayList<>(3);

        lottoList.add(new ArrayList<>(List.of(1,2,3,4,5,6)));
        lottoList.add(new ArrayList<>(List.of(2,3,4,5,6,7)));
        lottoList.add(new ArrayList<>(List.of(3,4,5,6,7,8)));



        lottoRepository.add(lottoList.get(0));
        lottoRepository.add(lottoList.get(1));
        lottoRepository.add(lottoList.get(2));

        Assertions.assertThat(lottoRepository.findAll()).containsExactly(
                new Lotto(lottoList.get(0))
                ,new Lotto(lottoList.get(1))
                ,new Lotto(lottoList.get(2)));

    }

}