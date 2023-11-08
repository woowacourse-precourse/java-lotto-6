package lotto;

import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class LottoServiceTest {
    @Test
    void 구매_금액이_숫자가_아닐때_검증(){
        boolean validated = LottoService.validatePurchaseAmount("111a22");
        assertThat(validated).isFalse();
    }

    @Test
    void 구매_금액이_정수가_아닐때_검증(){
        boolean validated = LottoService.validatePurchaseAmount("1000.1");
        assertThat(validated).isFalse();
    }

    @Test
    void 구매_금액이_1000원_보다_작을때_검증(){
        boolean validated = LottoService.validatePurchaseAmount("999");
        assertThat(validated).isFalse();
    }

    @Test
    void 구매_금액이_1000원_단위가_아닐때_검증(){
        boolean validated = LottoService.validatePurchaseAmount("10001");
        assertThat(validated).isFalse();
    }

    @Test
    void 로또_생성기가_조건에_맞게_로또를_생성하는지_테스트(){
        assertThatCode(()->{
            Lotto lotto = LottoGenerator.generate();
        }).doesNotThrowAnyException();
    }

    @Test
    void 로또_판매시_지정한_개수만큼_로또가_생성되는지_테스트(){
        LottoService lottoService = new LottoService();
        int cnt = 123;

        List<Lotto> lottos = lottoService.generateLottos(cnt);
        assertThat(lottos.size()).isEqualTo(cnt);
    }

}