package lotto.application;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoService {
    private final UserService userService;
    private WinningNumber winningNumber;

    private final IOService ioService;

    public LottoService() {
        this.userService = new UserService();
        this.ioService = new IOService();
    }

    public void sellLottos() {
        ioService.printBeforePurchaseLottoMessage();
        int amount = ioService.scanPurchaseAmount();
        int cnt = amount / 1000;
        List<Lotto> lottos = generateLottos(cnt);
        userService.updateUser(lottos, cnt);
    }

    public void informPurchaseHistory(){
        User user = userService.getUser();

        ioService.printLottoCount(user.getLottoCnt());
        ioService.printLottos(user);
    }

    public void requestWinningNumber() {
        WinningNumber winningNumber = ioService.scanWinningNumber();
        this.winningNumber = winningNumber;
    }

    public void showResult(){
        User user = userService.getUser();
        checkLottos();

        ioService.printResult(user);
    }

    public List<Lotto> generateLottos(int cnt) {
        List<Lotto> lottos = new ArrayList<>(cnt);

        for (int i = 0; i < cnt; ++i) {
            lottos.add(LottoGenerator.generate());
        }

        return lottos;
    }

    public void setWinningNumber() {
        winningNumber = ioService.scanWinningNumber();
    }

    public void checkLottos() {
        User user = userService.getUser();

        List<Lotto> lottos = user.getLottos();
        for (Lotto lotto : lottos) {
            Rank rank = checkLottoRank(lotto);
            user.addCntrank(rank);
        }

        setTotalPriceToUser(user);
    }

    private Rank checkLottoRank(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> prizeNumbers = winningNumber.getPrizeNumbers();

        int cntPrizeNumberMatch = calCntPrizeNumberMatch(prizeNumbers, lottoNumbers);
        int cntBonusNumberMatch = calCntBonusNumberMatch(winningNumber.getBonusNumber(), lottoNumbers);
        int symbolNumber = 10 * cntPrizeNumberMatch + cntBonusNumberMatch;

        return Rank.generateRank(symbolNumber);
    }

    private boolean isMatched(List<Integer> numbers, int target) {
        for (Integer number : numbers) {
            if (target == number)
                return true;
        }

        return false;
    }

    private int calCntPrizeNumberMatch(List<Integer> prizeNumbers, List<Integer> lottoNumbers) {
        int ret = 0;

        for (Integer lottoNumber : lottoNumbers) {
            if (isMatched(prizeNumbers, lottoNumber))
                ret++;
        }

        return ret;
    }

    private int calCntBonusNumberMatch(int bonusNumber, List<Integer> lottoNumbers) {
        int ret = 0;

        if(isMatched(lottoNumbers, bonusNumber))
            ret++;

        return ret;
    }

    private void setTotalPriceToUser(User user) {
        HashMap<Rank, Integer> cntRank = user.getCntRank();
        List<Rank> ranks = List.of(Rank.FirstRank, Rank.SecondRank, Rank.ThirdRank, Rank.ForthRank, Rank.FifthRank, Rank.None);

        long totalPrize = 0L;
        for (Rank rank : ranks) {
            int cnt = cntRank.get(rank);

            totalPrize += cnt * rank.getPrize();
        }

        user.setTotalPrize(totalPrize);
    }


}
