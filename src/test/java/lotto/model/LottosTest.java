package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottosTest {

    @Test
    void 구매한_로또의_수만큼_로또가_발급된다() {
        // given
        long lottoTicketCount = 10;
        NumbersGenerator<LottoNumber> numbersGenerator = new LottoNumbersGenerator();

        // when
        Lottos lottos = Lottos.createWith(lottoTicketCount, numbersGenerator);

        // then
        assertThat(lottos.getPurchasedLottos()).hasSize(10);
    }
}
