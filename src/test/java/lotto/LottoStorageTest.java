package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStorageTest {
    LottoStorage lottoStorage;

    @BeforeEach
    void setUp() {
        lottoStorage = new LottoStorage();
    }

    @Test
    @DisplayName("로또 저장을 성공한다.")
    void test_SaveLottoSuccessful() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto savedLotto = lottoStorage.saveLotto(lotto);

        //then
        assertThat(savedLotto).isEqualTo(lotto);
    }

    @Test
    @DisplayName("존재하는 로또가 없으면 빈 리스트를 반환한다.")
    void test_FindAllLotteriesSuccessful_EmptyList() {
        //when
        List<Lotto> lotteries = lottoStorage.findAllLotteries();

        //then
        assertThat(lotteries).isEmpty();
    }

    @Test
    @DisplayName("존재하는 로또가 있을 때 로또들의 리스트를 반환한다.")
    void test_FindAllLotteriesSuccessful_ListOfLotteries() {
        //given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(45, 44,43,42,41,10));
        lottoStorage.saveLotto(firstLotto);
        lottoStorage.saveLotto(secondLotto);

        //when
        List<Lotto> lotteries = lottoStorage.findAllLotteries();

        //then
        assertThat(lotteries).hasSize(2);
    }
}
