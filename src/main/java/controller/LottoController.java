package controller;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import model.Lotto;
import view.WinningPrize;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_PER_TICKET = 6;
    private static final String FIFTH = "3";
    private static final String FOURTH = "4";
    private static final String THIRD = "5";
    private static final String BONUS = "bonus";
    private static final String FIRST = "6";

    List<Lotto> generatedLottos = new ArrayList<>();
    HashMap<String, Integer> results = new HashMap<>();

    public int calculatelottoMount(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoMount) {
        for (int i = 0; i < lottoMount; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_TICKET);
            Collections.sort(numbers);
            generatedLottos.add(new Lotto(numbers));
        }
        return generatedLottos;
    }

    public HashMap<String, Integer> calculateHowManyCorrectNumber(List<Integer> userLottoNumbers, int bonusNumber) {
        setResultDefault(results);
        for (Lotto lottoTicket : generatedLottos) {
            int bonusCount = 0;
            List<Integer> lottoNumbers = lottoTicket.getNumbers();
            int correctCount = isExistInUserLottoNumber(lottoNumbers, userLottoNumbers);
            if (correctCount == 5) {
                bonusCount = isThereBonusNumber(lottoNumbers, bonusNumber);
            }
            System.out.println(correctCount + " " + bonusCount);
            if (correctCount < 3) {
                continue;
            }
            saveCountResults(correctCount, bonusCount);
        }
        return results;
    }

    private void saveCountResults(int correctCount, int bonusCount) {
        if (correctCount == 3) {
            results.put(FIFTH, results.getOrDefault(FIFTH, 0) + 1);
        } else if (correctCount == 4) {
            results.put(FOURTH, results.getOrDefault(FOURTH, 0) + 1);
        } else if (correctCount == 5) {
            results.put(THIRD, results.getOrDefault(THIRD, 0) + 1);
        } else if (correctCount == 5 && bonusCount == 1) {
            results.put(BONUS, results.getOrDefault(BONUS, 0) + 1);
        } else if (correctCount == 6) {
            results.put(FIRST, results.getOrDefault(FIRST, 0) + 1);
        }
    }

    private int isThereBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        int count = 0;
        if (lottoNumbers.contains(bonusNumber)) {
            count++;
        }
        return count;
    }

    private int isExistInUserLottoNumber(List<Integer> lottoNumbers, List<Integer> userLottoNumber) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            if (userLottoNumber.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private void setResultDefault(HashMap<String, Integer> results) {
        results.put("3", 0);
        results.put("4", 0);
        results.put("5", 0);
        results.put("6", 0);
        results.put("bonus", 0);

    }

    public double calculateWinningRate(int lottoAmount, HashMap<String, Integer> winningResults) {
        int totalSpent = lottoAmount * LOTTO_PRICE;
        int winningPrizeSum = 0;
        for (String grade : winningResults.keySet()) {
            int eachLottoPrizeAmount = winningResults.get(grade);
            if (eachLottoPrizeAmount != 0) {
                winningPrizeSum += calculatePrizeSum(grade, eachLottoPrizeAmount);
            }
        }
        return (double) winningPrizeSum / totalSpent * 100;
    }

    private int calculatePrizeSum(String grade, int eachLottoPrizeAmount) {
        int prizeSum = 0;
        if (grade.equals(WinningPrize.FIFTH.getMatchCount())) {
            prizeSum = eachLottoPrizeAmount * WinningPrize.FIFTH.getPrizeAmount();
        } else if (grade.equals(WinningPrize.FOURTH.getMatchCount())) {
            prizeSum = eachLottoPrizeAmount * WinningPrize.FOURTH.getPrizeAmount();
        } else if (grade.equals(WinningPrize.THIRD.getMatchCount())) {
            prizeSum = eachLottoPrizeAmount * WinningPrize.THIRD.getPrizeAmount();
        } else if (grade.equals(WinningPrize.SECOND.getMatchCount())) {
            prizeSum = eachLottoPrizeAmount * WinningPrize.SECOND.getPrizeAmount();
        } else if (grade.equals(WinningPrize.FIRST.getMatchCount())) {
            prizeSum = eachLottoPrizeAmount * WinningPrize.FIRST.getPrizeAmount();
        }
        return prizeSum;
    }


}
