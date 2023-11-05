package lotto.Service;

import java.util.List;

public interface LottoService {
    void initializeLottery(int cost);
    int getNumberOfLotto();
    List<List<Integer>> getLotto();
}
