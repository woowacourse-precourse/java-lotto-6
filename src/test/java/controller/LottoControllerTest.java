package controller;

import constant.LottoConfig;
import lotto.Lotto;
import org.junit.jupiter.api.Test;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    public List<Lotto> issueLottos(int issueCount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0; i<issueCount; i++){
            List<Integer> numbers = RandomNumberGenerator.create(
                    LottoConfig.NUM_COUNT.getValue(),
                    LottoConfig.START_INCLUSIVE.getValue(),
                    LottoConfig.END_INCLUSIVE.getValue()
            );
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    @Test
    void issueLottos_정해진_수량_발행() {
        int issueCount = 10;
        List<Lotto> lottos = issueLottos(issueCount);

        assertThat(lottos.size()).isEqualTo(issueCount);

    }
}