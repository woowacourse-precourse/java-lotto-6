package lotto.company;

import java.util.List;

interface Company {
    List<Lotto> generateLottoList(int buyAmount);
    void printLottoList(List<Lotto> lottoList);
    LotteryResult getLotteryResult();
}
