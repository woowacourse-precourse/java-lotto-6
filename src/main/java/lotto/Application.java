package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.rank.domain.Ranks;
import lotto.rank.service.RankService;
import lotto.rank.domain.RankStatistics;
import lotto.userLotto.service.LottoService;
import lotto.util.LottoConstant;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.winningLotto.domain.LottoBonusNumber;
import lotto.winningLotto.domain.LottoMatcher;
import lotto.winningLotto.domain.LottoNumber;
import lotto.userLotto.domain.Lottos;
import lotto.winningLotto.domain.WinningLotto;
import lotto.winningLotto.domain.WinningLottoService;
import lotto.winningLotto.service.LottoBonusNumberService;
import lotto.winningLotto.service.LottoNumberService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        LottoNumberService lottoNumberService = new LottoNumberService();
        LottoBonusNumberService lottoBonusNumberService = new LottoBonusNumberService();
        WinningLottoService winningLottoService = new WinningLottoService();
        RankService rankService = new RankService();

        int lottoCount = InputView.getLottoCount();
        OutputView.printLottoCount(lottoCount);
        Lottos lottos = lottoService.createLottos(lottoCount);
        OutputView.printLottos(lottos);

        InputView.messageAskLottoNumber();
        LottoNumber lottoNumber = lottoNumberService.createLottoNumber();
        InputView.messageAskBonusNumber();
        LottoBonusNumber lottoBonusNumber = lottoBonusNumberService.createLottoBonusNumber();

        WinningLotto winningLotto = winningLottoService.createWinningLotto(lottoNumber, lottoBonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);
        Ranks ranks = new Ranks(lottoMatcher.matchLottos(lottos));

        RankStatistics rankStatistics = rankService.createRankStatistics();
        rankStatistics.recordLottoRanks(ranks.getRanks());
        double revenueRate = rankStatistics.calculateLottoRevenueRate(lottoCount * LottoConstant.LOTTO_PRICE);

        OutputView.printResultRankStatistics(rankStatistics.getRankCount());
        OutputView.printRevenueRate(revenueRate);

    }
}
