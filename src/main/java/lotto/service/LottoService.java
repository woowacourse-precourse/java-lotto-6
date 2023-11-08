package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Match;

public interface LottoService {

    void buyLotto(int price);

    List<String> boughtLottoList();

    void setAnswer(Lotto winLotto, int bonusNum);

    void setScore();

    int countMatch(Match match);

    double calculateYield(int price);

    void clearAll();

}
