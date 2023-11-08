package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 결과 체크 테스트")
class LottoResultCheckerTest {
    @DisplayName("성공: 로또 번호 검사기를 생성할 수 있다.")
    @Test
    void test1() {
        assertThatCode(LottoResultChecker::new)
                .doesNotThrowAnyException();
    }

    @DisplayName("성공: 등수를 확인할 수 있다.")
    @Test
    void test2() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));
        lottos.add(new Lotto(List.of(31, 32, 33, 34, 35, 36)));

        Lotto pickedLotto = new Lotto(List.of(3, 4, 5, 6, 9, 10));
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 20);

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        assertThatCode(() -> lottoResultChecker.checkLotto(lottos, winningLotto))
                .doesNotThrowAnyException();
    }

    @DisplayName("성공: 당첨 내역을 출력할 수 있다.")
    @Test
    void test3() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));
        lottos.add(new Lotto(List.of(3, 4, 5, 6, 9, 10)));
        lottos.add(new Lotto(List.of(31, 32, 33, 34, 35, 36)));

        Lotto pickedLotto = new Lotto(List.of(3, 4, 5, 6, 9, 10));
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 20);

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.checkLotto(lottos, winningLotto);
        assertThatCode(() -> lottoResultChecker.getProfitRatio(8000))
                .doesNotThrowAnyException();
    }

    @DisplayName("성공: 수익률을 출력할 수 있다.")
    @Test
    void test4() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        Lotto pickedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(pickedLotto, 7);

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.checkLotto(lottos, winningLotto);
        assertThatCode(() -> lottoResultChecker.getProfitRatio(8000))
                .doesNotThrowAnyException();
    }
}