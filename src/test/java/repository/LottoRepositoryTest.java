package repository;

import domain.Lotto;
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
        List<Lotto> lottoList = new ArrayList<>(3);
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(2,3,4,5,6,7)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(3,4,5,6,7,8)));

        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);

        lottoRepository.add(lottoList.get(0));
        lottoRepository.add(lottoList.get(1));
        lottoRepository.add(lottoList.get(2));

        Assertions.assertThat(lottoRepository.size()).isEqualTo(3);
    }
    @Test
    void 로또추가(){
        lottoRepository = new LottoRepository(3);

        List<Lotto> lottoList = new ArrayList<>(3);
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(2,3,4,5,6,7)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(3,4,5,6,7,8)));

        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);

        lottoRepository.add(lottoList.get(0));
        lottoRepository.add(lottoList.get(1));
        lottoRepository.add(lottoList.get(2));

        Assertions.assertThat(lottoRepository.findAll()).containsExactly(lotto1,lotto2,lotto3);

    }

}