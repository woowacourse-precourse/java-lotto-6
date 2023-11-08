package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @DisplayName("로또 당첨자를 확인하여 1등~5등의 수를 반환한다.")
    @Test
    void returnWinnerCount() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(11, 33, 22, 13, 2, 5)));
        lottos.add(new Lotto(List.of(1, 6, 44, 24, 11, 9)));
        lottos.add(new Lotto(List.of(4, 5, 6, 33, 11, 22)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);
        int[] result = {1, 0, 0, 1, 1};

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(result).isEqualTo(lottoResultTest.getRankCount());
    }

    @DisplayName("1등 로또의 수를 카운트한다.")
    @Test
    void count1stPlace() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(4, 5, 6, 33, 11, 22)));
        lottos.add(new Lotto(List.of(4, 5, 6, 33, 11, 22)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(2).isEqualTo(lottoResultTest.getRankCount()[0]);
    }

    @DisplayName("2등 로또의 수를 카운트한다.")
    @Test
    void count2ndPlace() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 5, 6, 33, 11, 22)));
        lottos.add(new Lotto(List.of(4, 5, 6, 33, 11, 10)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(1).isEqualTo(lottoResultTest.getRankCount()[1]);
    }

    @DisplayName("3등 로또의 수를 카운트한다.")
    @Test
    void count3rdPlace() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 5, 6, 33, 11, 22)));
        lottos.add(new Lotto(List.of(4, 5, 6, 33, 11, 10)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(1).isEqualTo(lottoResultTest.getRankCount()[2]);
    }

    @DisplayName("4등 로또의 수를 카운트한다.")
    @Test
    void count4thPlace() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(4, 5, 6, 3, 11, 2)));
        lottos.add(new Lotto(List.of(1, 5, 6, 33, 11, 12)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(2).isEqualTo(lottoResultTest.getRankCount()[3]);
    }

    @DisplayName("5등 로또의 수를 카운트한다.")
    @Test
    void count5thPlace() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(12, 1, 6, 33, 11, 2)));
        lottos.add(new Lotto(List.of(1, 5, 6, 3, 11, 10)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        assertThat(2).isEqualTo(lottoResultTest.getRankCount()[4]);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateRateOfReturn() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(12, 1, 6, 30, 11, 2)));
        lottos.add(new Lotto(List.of(1, 5, 6, 3, 11, 10)));
        lottos.add(new Lotto(List.of(30, 10, 20, 5, 11, 2)));
        lottos.add(new Lotto(List.of(1, 7, 8, 9, 11, 10)));
        Lotto winningNumbers = new Lotto(List.of(4, 5, 6, 33, 11, 22));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.calculateRateOfReturn(lottos, winningNumbers, bonus.getNumber());
        assertThat(125.0).isEqualTo(lottoResultTest.getRateOfReturn());
    }

    @DisplayName("당첨 통계를 출력 형식에 맞게 출력합니다.")
    @Test
    void printLottoResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(5, 10, 15, 20, 25, 30)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(5, 10, 15, 20, 25, 30)));
        lottos.add(new Lotto(List.of(10, 20, 30, 44, 1, 2)));
        lottos.add(new Lotto(List.of(9, 8, 7, 6, 5, 4)));
        Lotto winningNumbers = new Lotto(List.of(11, 22, 33, 44, 1, 2));
        BonusNumber bonus = new BonusNumber();
        bonus.setNumber(winningNumbers, 10);

        LottoResult lottoResultTest = new LottoResult();
        lottoResultTest.totalRanking(lottos, winningNumbers, bonus.getNumber());
        lottoResultTest.calculateRateOfReturn(lottos, winningNumbers, bonus.getNumber());

        String result = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 83.3%입니다.""";
        assertThat(result).isEqualTo(lottoResultTest.toString());
    }
}
