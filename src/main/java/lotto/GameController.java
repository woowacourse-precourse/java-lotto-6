package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoAmount;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.rank.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.OutputView.*;

public class GameController {

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static LottoAmount lottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningLotto winningResult;
    private static Map<Rank, Integer> result;

    public GameController() {
    }

    public void start() {
        int ticketCnt = amountToCnt();
        printTicketCnt(ticketCnt);

        lottoList = makeLottoList(ticketCnt);
        winningResult = validateNums();

        printResult(result, winningResult, ticketCnt);
    }

    public int amountToCnt(){
        lottoAmount = new LottoAmount(InputView.getInputAmount());
        return lottoAmount.amountChangeToLottoCnt();
    }

    private List<Lotto> makeLottoList(int ticketCnt) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private Lotto makeLotto(){
        LottoNumber lottoNumbers = new LottoNumber();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setLottoNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public WinningLotto validateNums() {
        Lotto lotto = new Lotto(InputView.getLottoNums());
        List<Integer> winningLotto = lotto.getLottoNums();

        int bonusNum = InputView.getBonusNum();
        winningResult = new WinningLotto(new Lotto(winningLotto), bonusNum);

        return winningResult;
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private void calcResult(WinningLotto winningLotto){
        result = setResult();
        Rank rank;

        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.matchCnt(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
    }

    private void printResult(Map<Rank, Integer> result, WinningLotto winningLotto, int amount){
        OutputView.printSuccessResult();
        calcResult(winningLotto);
        printRank(result);
        printEarningRate(result, amount);
    }

    private void printRank(Map<Rank, Integer> result) {
        for (int i = 0; i < Rank.values().length; i++) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private void printEarningRate(Map<Rank, Integer> result, int amount) {
        double earningRate = 0;
        for (Rank rank : result.keySet()) {
            earningRate += ((double) (rank.getReward()) / (amount * TICKET_PRICE) * (result.get(rank)) * (PERCENTAGE));
        }
        printRevenueRate(earningRate);
    }
}
