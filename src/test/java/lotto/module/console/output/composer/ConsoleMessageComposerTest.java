package lotto.module.console.output.composer;

import lotto.module.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ConsoleMessageComposerTest {
    private final ConsoleMessageComposer consoleMessageComposer = ConsoleMessageComposer.newInstance();

    @Test
    void 구매한_로또_목록_출력_메시지_변환_성공_테스트() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(14, 15, 16, 18, 19, 20));
        List<Lotto> list = new ArrayList<>();
        list.add(lotto1);
        list.add(lotto2);
        list.add(lotto3);
        // when
        String message = consoleMessageComposer.makePurchasedLottoTicketMessage(list);

        // then
        Assertions.assertThat(message)
                .contains("3개를 구매했습니다.")
                .contains("[7, 8, 9, 10, 11, 12]")
                .contains("[1, 2, 3, 4, 5, 6]")
                .contains("[14, 15, 16, 18, 19, 20]");
    }

}