package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanking;
import lotto.view.*;

import java.util.*;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private String amount;
    private int lottoCnt;
    private int bonusNumber;
    private List<Integer> winNumber = new ArrayList<>();
    private List<Lotto> lottoList = new ArrayList<>();

    InputView inputView = new InputView();
    LottoNumbers lottoNumbers = new LottoNumbers();
    OutputView outputView = new OutputView();

    public void run() {
        inputPurchaseAmount();
        printLottoCnt();
        purchaseLotto();
        inputWinNumber();
        inputBonusNumber();
        printResult(lottoList, winNumber);
    }

    public void inputPurchaseAmount() {
        this.amount = inputView.inputAmount2();
    }

    public void printLottoCnt() {
        this.lottoCnt = getLottoCnt(this.amount);
        outputView.printLottoCnt(this.lottoCnt);
    }

    public void purchaseLotto() {
        List<Lotto> lottoList;
        lottoList = lottoNumbers.getLottoNumbers(this.lottoCnt);
        outputView.printLotto(lottoList);
        this.lottoList = lottoList;
    }

    public void inputWinNumber() {
        String winNumber = inputView.inputWinNumber();
        String[] winNumberList = winNumber.trim().split("\\s*,\\s*");
        for (String numberStr : winNumberList) {
            this.winNumber.add(Integer.parseInt(numberStr));
        }
        Collections.sort(this.winNumber);
    }

    public void inputBonusNumber() {
        String bonusNumber = inputView.inputBonusNumber();
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public Map<LottoRanking, Integer> lottoResult(List<Lotto> lottoList, List<Integer> win) {
        Map<LottoRanking, Integer> result = new HashMap<>();
        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, 0);
            // result.forEach((LottoRanking, Integer) -> {System.out.println(LottoRanking + ":" + Integer);});
            // System.out.println("--");
        }
        for (Lotto lotto : lottoList) {
            // System.out.println("--");
            // System.out.println(lotto.getNumbers().toString());
            int count = 0;
            // System.out.println(count);
            for (int number : win) {
                // System.out.println(number);
                // System.out.println(lotto.getNumbers().contains(number));
                if (lotto.getNumbers().contains(number)) {
                    count++;
                }
            }
            // System.out.println("최종: " + count);
            // System.out.println("Bonus: " + containBonusNumber(lotto.getNumbers()));
            LottoRanking rank = LottoRanking.valueOf(count, containBonusNumber(lotto.getNumbers()));
            // System.out.println("rank:" + rank.getMsg());
            result.put(rank, result.get(rank) + 1);
            // result.forEach((LottoRanking, Integer) -> {System.out.println(LottoRanking + ":" + Integer);});
        }
        return result;
    }

    public void printResult(List<Lotto> lottoList, List<Integer> win) {
        Map<LottoRanking, Integer> result = lottoResult(lottoList, win);
        outputView.printLottoResultHead();
        for (int i = LottoRanking.values().length - 2; i >= 0; i--) {
            outputView.printLottoResultBody(LottoRanking.values()[i].getMsg(), result.get(LottoRanking.values()[i]));
        }
        outputView.printLottoResultTail(rewardResult(result));
    }

    public boolean containBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private double rewardResult(Map<LottoRanking, Integer> result) {
        double rateOfReturn = 0;
        double totalCost = this.lottoCnt * LOTTO_PRICE;
        double winReward = 0;
        for (LottoRanking rank : result.keySet()) {
            winReward = winReward + (rank.getReward() * result.get(rank));
        }
        rateOfReturn = (winReward / totalCost) * 100;
        return rateOfReturn;
    }

    private int getLottoCnt(String amount) { return (Integer.parseInt(amount) / LOTTO_PRICE); }
}
