package lotto.service;

import java.util.List;

public interface LottoService {

    void buyLotto(int price);
    List<String> boughtLottoList();
    void setAnswer(List<Integer> answerList, int bonusNum);
    void setScore();
    Long calculateYield(int price);

}
