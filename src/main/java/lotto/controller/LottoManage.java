package lotto.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.CreateLottoNumbers;
import lotto.model.Lotto;
import lotto.model.LottoMatchResult;
import lotto.model.PlayerMoney;
import lotto.model.WinnerJudge;
import lotto.view.Input;
import lotto.view.Output;

public class LottoManage {
    private static List<Lotto> lottoBought;
    private static LottoMatchResult lottoMatchResult;

    private static final BonusNumber bonusNumber = new BonusNumber();

    public void gameStart() {
        int number = getPlayerBought();
        Output.boughtLottoNumMessage(number);

        lottoBought = makeLottoBoughtNumbers(number);
        lottoMatchResult = bonusJudgement();
        gameResult(lottoBought, lottoMatchResult, number);
    }

    public LottoMatchResult bonusJudgement() {
        List<Integer> winnerNumbers = getWinnerNumbers();
        int bonus = getBonusNumber(winnerNumbers);
        lottoMatchResult = new LottoMatchResult(new Lotto(winnerNumbers), bonus);
        return lottoMatchResult;
    }

    public int getBonusNumber(List<Integer> numbers) {
        try {
            int bonus = Input.setBonusNumber();
            bonusNumber.isSameNumber(numbers, bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(numbers);
        }
    }

    public List<Integer> getWinnerNumbers() {
        try {
            Lotto lotto = new Lotto(Input.setWinnerNumber());
            return lotto.getWinnerNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinnerNumbers();
        }
    }

    public int getPlayerBought() {
        int number = 0;
        try {
            PlayerMoney playerMoney = new PlayerMoney(Input.setPlayerMoney());
            number = playerMoney.getNumOfLottoBuy();
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerBought();
        }
    }

    private static List<Lotto> makeLottoBoughtNumbers(int number) {
        lottoBought = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoBought.add(createNumbers());
        }
        return lottoBought;
    }

    private static Lotto createNumbers() {
        CreateLottoNumbers createLottoNumbers = new CreateLottoNumbers();
        List<Integer> lotto;
        lotto = createLottoNumbers.createRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void gameResult(List<Lotto> lottoList, LottoMatchResult lottoMatchResult, int number) {
        Map<WinnerJudge, Integer> result = setResult();
        WinnerJudge winnerJudge;
        Output.ResultMessage();
        for (Lotto lotto : lottoList) {
            winnerJudge = lottoMatchResult.match(lotto);
            result.put(winnerJudge, result.get(winnerJudge) + 1);
        }
        printResult(result);
        printProfit(result, number);

    }

    private Map<WinnerJudge, Integer> setResult() {
        Map<WinnerJudge, Integer> result = new LinkedHashMap<>();

        for (WinnerJudge winnerJudge : WinnerJudge.values()) {
            result.put(winnerJudge, 0);
        }
        return result;
    }

    private void printResult(Map<WinnerJudge, Integer> result) {
        for (int i = WinnerJudge.values().length - 1; i >= 0; i--) {
            WinnerJudge.values()[i].printMessage(result.get(WinnerJudge.values()[i]));
        }
    }

    private void printProfit(Map<WinnerJudge, Integer> result, int number) {
        float profit = 0;
        for (WinnerJudge winnerJudge : result.keySet()) {
            profit = profit + ((float) (winnerJudge.getPrice()) / (number * 1000) * result.get(winnerJudge) * 100);
        }
        Output.CalculateResultMessage(profit);
    }
}
