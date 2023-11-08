package lotto;

import lotto.application.LottoService;
import lotto.application.UserService;
import lotto.domain.*;
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

    @Test
    void 로또_결과_테스트_1개() {
        LottoService lottoService = new LottoService();

        UserService userService = lottoService.getUserService();
        userService.updateUser(List.of(new Lotto(List.of(1,2,3,4,5,6))), 1);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
        lottoService.setWinningNumber(winningNumber);

        lottoService.checkLottos();

        User user = userService.getUser();

        lottoService.showResult();
        assertThat(user.getLottoCnt()).isEqualTo(1);
        assertThat(user.getCntRank().get(Rank.FirstRank)).isEqualTo(1);
        assertThat(user.getCntRank().get(Rank.SecondRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ThirdRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ForthRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.FifthRank)).isEqualTo(0);

        assertThat(user.getTotalPrize()).isEqualTo(Rank.FirstRank.getPrize());
    }

    @Test
    void 로또_결과_테스트_2개() {
        LottoService lottoService = new LottoService();

        UserService userService = lottoService.getUserService();
        userService.updateUser(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,6))), 2);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
        lottoService.setWinningNumber(winningNumber);

        lottoService.checkLottos();

        User user = userService.getUser();

        assertThat(user.getLottoCnt()).isEqualTo(2);
        assertThat(user.getCntRank().get(Rank.FirstRank)).isEqualTo(2);
        assertThat(user.getCntRank().get(Rank.SecondRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ThirdRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ForthRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.FifthRank)).isEqualTo(0);

        assertThat(user.getTotalPrize()).isEqualTo(2 * Rank.FirstRank.getPrize());
    }

    @Test
    void 로또_결과_테스트_3개() {
        LottoService lottoService = new LottoService();

        UserService userService = lottoService.getUserService();
        userService.updateUser(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(45,7,3,4,5,6))), 3);

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
        lottoService.setWinningNumber(winningNumber);

        lottoService.checkLottos();

        User user = userService.getUser();

        assertThat(user.getLottoCnt()).isEqualTo(3);
        assertThat(user.getCntRank().get(Rank.FirstRank)).isEqualTo(2);
        assertThat(user.getCntRank().get(Rank.SecondRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ThirdRank)).isEqualTo(0);
        assertThat(user.getCntRank().get(Rank.ForthRank)).isEqualTo(1);
        assertThat(user.getCntRank().get(Rank.FifthRank)).isEqualTo(0);

        assertThat(user.getTotalPrize()).isEqualTo(2 * Rank.FirstRank.getPrize() + Rank.ForthRank.getPrize());
    }
}