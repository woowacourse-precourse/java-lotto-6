package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPublisherTest {
    private LottoPublisher lottoPublisher;

    @BeforeEach
    void init() {
        lottoPublisher = new LottoPublisher();
    }

    @DisplayName("입력 받은 가격이 정수로 변환 가능한지, 1000 이상의 값인지 판별 후 반환한다.")
    @Test
    void validationIntUnder1000Pirce() {
        int price = lottoPublisher.validationPrice("1000");

        assertThat(price).isEqualTo(1000);
    }

    @DisplayName("살 수 있는 로또의 개수를 반환한다.")
    @Test
    void getLottoCount() {
        int count = lottoPublisher.getLottoCount(30000);

        assertThat(count).isEqualTo(30);
    }

    @DisplayName("로또 개수에 맞는 로또를 발행한다.")
    @Test
    void publishLotto() {
        List<Lotto> lottos = lottoPublisher.publishLotto(8);

        assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("당첨 번호가 6개인지, 1~45사이의 값인지, 정수형인지, 중복되지 않는지 확인한다.")
    @Test
    void validationWinNumberIsSixNumberAndUnder45AndIntegerAndNotDuplicate() {
        List<Integer> result = lottoPublisher.validationWinNumber(new String[]{"1", "2", "3", "4", "5", "6"});

        assertThat(result).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("문자열 배열을 정수형 배열로 변환한다.")
    @Test
    void stringArrayToIntegerArray() {
        int[] result = lottoPublisher.stringArrayToInteger(new String[]{"1", "2", "3", "4", "5", "6"});

        assertThat(result).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("정수형 배열을 리스트로 변환한다.")
    @Test
    void arrayToList() {
        List<Integer> result = lottoPublisher.arrayToList(new int[]{1, 2, 3, 4, 5, 6});

        assertThat(result).contains(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되는지, 1~45의 값인지, 문자열이 아닌지 확인한다.")
    @Test
    void validationBonusNumberIs() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lottoPublisher.validationBonusNumber(lotto, "7");

        assertThat(result).isEqualTo(7);
    }

}