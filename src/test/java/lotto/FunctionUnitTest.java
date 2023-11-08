package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class FunctionUnitTest {

    private BuyLotto buyLotto = new BuyLotto();
    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 무작위_값_리스트_정렬() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(integers);
        System.out.println(integers);
    }

    @Test
    void 사용자가_입력한_금액만큼_로또_횟수_구하기() {
        int lottoAmount = buyLotto.setPurchasePrice(8000);

        assertThat(lottoAmount).isEqualTo(8);

    }

    @Test
    void 로또_횟수만큼_Lottos_리스트_크기_확인() {
        Lottos lottos = lottoMachine.spinLotto(8);

        List<Lotto> lottoList = lottos.getLottos();
        lottoList.stream().map(Lotto::getNumbers).forEach(System.out::println);

        assertThat(lottos.getLottos().size()).isEqualTo(8);
    }

    @Test
    void 입력한_당첨번호_문자열을_정수형_리스트로_전환() {
        String winningNumber = "1,2,3,4,5";
        int bonusNumber = 7;

        PlayerNumber playerNumber = new PlayerNumber(winningNumber, bonusNumber);

        playerNumber.getPlayerNumbers().forEach(System.out::println);

        assertThat(playerNumber.getPlayerNumbers().size()).isEqualTo(5);
    }

}
