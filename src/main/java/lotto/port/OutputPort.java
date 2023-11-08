package lotto.port;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankInfo;

public interface OutputPort {
    void printLottos(List<Lotto> lottos);
    void printRankStatistics(List<RankInfo> rankInfos);
    void printProfitRate(Double profitRate);
}
