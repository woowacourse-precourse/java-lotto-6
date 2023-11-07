package lotto.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {


    @DisplayName("LottoRepository 싱글톤 체크")
    @Test
    void getInstance() {
        LottoRepository instance = LottoRepository.getInstance();
        Assertions.assertThat(instance).isInstanceOf(LottoRepository.class);
    }

    @DisplayName("LottoRepository 로또 저장 및 값 추출 확인")
    @Test
    void addLottoAndGetLottoTicket() {
        LottoRepository instance = LottoRepository.getInstance();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int lottoNumber = 1; lottoNumber < 7; lottoNumber++) {
            lottoNumbers.add(lottoNumber);
        }
        Lotto lotto = new Lotto(lottoNumbers);
        instance.addLotto(lotto);
        List<Lotto> lottoTicket = instance.getLottoTicket();
        Assertions.assertThat(lottoTicket.get(0)).isEqualTo(lotto);
    }

}