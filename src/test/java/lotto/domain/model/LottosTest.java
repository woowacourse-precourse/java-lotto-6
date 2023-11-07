package lotto.domain.model;

import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.Result;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void 로또를_추가한다() {
        Lottos lottos = new Lottos();
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(2, lottos.getLottos().size());
    }

    @Test
    void 로또_결과를_계산한다() {
        Lottos lottos = new Lottos();
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 7));
        lottos.addLotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);

        List<Result> results = lottos.calculateResult(winningNumber, bonusNumber);

        assertEquals(List.of(Result.SIX_MATCH, Result.FIVE_MATCH_WITH_BONUS), results);
    }

    @Test
    void Lottos_내부_필드가_동일하다면_같은_객체로_인식한다() {
        Lottos lottosA = new Lottos();
        lottosA.addLotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottosB = new Lottos();
        lottosB.addLotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(lottosA, lottosB);
    }

    @Test
    void Lottos_내부_필드가_동일하다면_Hash_자료구조에서도_객체로_인식한다() {
        Set<Lottos> set = new HashSet<>();
        Lottos lottosA = new Lottos();
        lottosA.addLotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottosB = new Lottos();
        lottosB.addLotto(List.of(1, 2, 3, 4, 5, 6));

        set.add(lottosA);
        set.add(lottosB);

        assertEquals(1, set.size());
    }
}