package lotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    public Controller() {
    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static LottoAmount LottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static Check checkresult;


    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        checkresult = validateBonus();

        lottoResult(lottoList, checkresult, ticketCount);

    }

    public int inputPlayerAmount() {
        LottoAmount = new LottoAmount(InputView.inputPlayerAmount());
        return LottoAmount.LottoCount();
    }

    public Check validateBonus() {
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer> checknum = lotto.getLottoNumbers();

        int ball = InputView.inputBonusNumber();
        lotto.validateBonusNumber(checknum, ball);
        checkresult = new Check(new Lotto(checknum), ball);

        return checkresult;
    }


    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }


    private static Lotto makeLotto() {
        LottoRandom lottoNumbers = new LottoRandom();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.randomNum();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, Check winningLotto, int amount) {
        Map<Result, Integer> result = setResult();
        Result rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Result, Integer> result) {
        for (int i = Result.values().length - 1; i >= 0; i--) {
            Result.values()[i].printMessage(result.get(Result.values()[i]));
        }
    }

    private void printEarningRate(Map<Result, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Result rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }


    private Map<Result, Integer> setResult() {
        Map<Result, Integer> result = new LinkedHashMap<>();

        for (Result rank : Result.values()) {
            result.put(rank, 0);
        }
        return result;
    }
}
