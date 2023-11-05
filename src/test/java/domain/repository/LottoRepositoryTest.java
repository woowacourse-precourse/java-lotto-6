package domain.repository;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    private final LottoRepository lottoRepository = new LottoRepository();

    @DisplayName("LottoRepository에 각 Lotto 인스턴스가 저장되는지 확인")
    @Test
    void checkSavingLotto() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(numbers);
        int sizeBeforeSave = lottoRepository.getAllLotto().size();
        lottoRepository.save(lotto);
        Assertions.assertEquals(sizeBeforeSave+1,lottoRepository.getAllLotto().size());
    }
}