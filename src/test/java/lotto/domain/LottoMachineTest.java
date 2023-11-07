package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LottoMachineTest {
    private static final long LOTTO_TICKET_PRICE = 1000L;

    @DisplayName("입력한 금액에 따른 로또 생성 테스트")
    @Test
    void createLotto() {
        long money = 14000;
        long total_lotto_count = money / LOTTO_TICKET_PRICE;

        List<Lotto> lottoList = LottoMachine.make(money);
        assertThat(lottoList.size()).isEqualTo(total_lotto_count);
    }

    @DisplayName("오름차순으로 정상 정렬 되는지 테스트")
    @Test
    void sortTest() {
        long money = 10000;
        List<Lotto> lottoList = LottoMachine.make(money);

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
            Collections.sort(sortedLottoNumbers);
            assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
        }

    }


}