package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.rank.domain.Ranks;
import lotto.rank.service.RankService;
import lotto.rank.domain.RankStatistics;
import lotto.userLotto.service.LottoService;
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
        //로도뜰 발행
        Lottos lottos = lottoService.createLottos(lottoCount);
        OutputView.printLottos(lottos);

        //당첨 번호 입력
        InputView.messageAskLottoNumber();
        LottoNumber lottoNumber = lottoNumberService.createLottoNumber();
        //보너스 번호 입력
        InputView.messageAskBonusNumber();
        LottoBonusNumber lottoBonusNumber = lottoBonusNumberService.createLottoBonusNumber();

        // 위닝 로또 생성
        WinningLotto winningLotto = winningLottoService.createWinningLotto(lottoNumber, lottoBonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto);
        // 당첨 결과 매치
        Ranks ranks = new Ranks(lottoMatcher.matchLottos(lottos));
        System.out.println(ranks.getRanks());

        // 결과 기록
        RankStatistics rankStatistics = rankService.createRankStatistics();
        rankStatistics.recordLottoRanks(ranks.getRanks());
        double revenueRate = rankStatistics.calculateLottoRevenueRate(lottoCount * 1000);

        //결과 출력
        OutputView.printResultRankStatistics(rankStatistics.getRankCount());
        OutputView.printRevenueRate(revenueRate);

    }
}
