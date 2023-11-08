package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.Constant.LOTTO_BEST_RANK;
import static lotto.global.Constant.LOTTO_PRICE;
import static lotto.global.Constant.LOTTO_WORST_RANK;
import static lotto.ui.ConsoleMessage.PRINT_LOTTOS;
import static lotto.ui.ConsoleMessage.PRINT_RATE_OF_PRIZE_FORMAT;
import static lotto.ui.ConsoleMessage.PRINT_RESULT_FORMAT;
import static lotto.ui.ConsoleMessage.PRINT_RESULT_HEADER;
import static lotto.ui.ConsoleMessage.PRINT_SECOND_RESULT_FORMAT;
import static lotto.ui.ConsoleMessage.REQUEST_BONUS_NUMBER;
import static lotto.ui.ConsoleMessage.REQUEST_PURCHASE_AMOUNT;
import static lotto.ui.ConsoleMessage.REQUEST_WINNING_NUMBERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.error.exception.InvalidInputException;
import lotto.input.InputProcessor;
import lotto.lotto.Lotto;
import lotto.lotto.LottoEvaluator;
import lotto.lotto.LottoResult;
import lotto.lotto.LottoVendor;

public class ConsoleUI {
    private InputProcessor inputProcessor = new InputProcessor();
    private LottoVendor lottoVendor = new LottoVendor();
    private LottoEvaluator lottoEvaluator = new LottoEvaluator();

    public void play() {
        Integer purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = lottoVendor.generateLottos(purchaseAmount);
        printLottosInfo(lottos);

        List<Integer> winningNumbers = inputWinningNumbers();
        Integer bonusNumber = inputBonusNumber(winningNumbers);

        List<LottoResult> lottoResults = evaluateLottos(lottos, winningNumbers, bonusNumber);
        printLottoResults(lottoResults);
    }

    private Integer inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());
        while (true) {
            String input = readLine();
            try {
                Integer purchaseAmount = inputProcessor.processPurchaseAmount(input);
                System.out.println();
                return purchaseAmount;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottosInfo(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_LOTTOS.getMessage());
        for (Lotto lotto : lottos) {
            List<Integer> sortedLottoNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLottoNumbers);
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }

    private List<Integer> inputWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS.getMessage());
        while (true) {
            String input = readLine();
            try {
                List<Integer> winningNumbers = inputProcessor.processWinningNumbers(input);
                System.out.println();
                return winningNumbers;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
        while (true) {
            String input = readLine();
            try {
                Integer bonusNumber = inputProcessor.processBonusNumber(input, winningNumbers);
                System.out.println();
                return bonusNumber;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<LottoResult> evaluateLottos(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Integer rank = lottoEvaluator.evaluateLottoRank(lotto, winningNumbers, bonusNumber);
            lottoResults.add(new LottoResult(rank));
        }
        return lottoResults;
    }

    private void printLottoResults(List<LottoResult> lottoResults) {
        System.out.println(PRINT_RESULT_HEADER.getMessage());

        for (int rank = LOTTO_WORST_RANK.getNumber(); rank >= LOTTO_BEST_RANK.getNumber(); rank--) {
            Long countOfRank = getCountOfRank(lottoResults, rank);
            System.out.println(formatLottoResult(rank, countOfRank));
        }

        double rateOfPrize = calculateRateOfPrize(lottoResults);
        System.out.println(formatRateOfPrize(rateOfPrize));
    }

    private Long getCountOfRank(List<LottoResult> lottoResults, Integer rank) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.getRank() == rank)
                .count();
    }

    private String formatLottoResult(Integer rank, Long countOfRank) {
        LottoResult lottoResult = new LottoResult(rank);
        long matchNumbersCount = lottoResult.getMatchNumbersCount();
        long prize = lottoResult.getPrize();
        if (rank == 2) {
            return String.format(PRINT_SECOND_RESULT_FORMAT.getMessage(), matchNumbersCount, prize, countOfRank);
        }
        return String.format(PRINT_RESULT_FORMAT.getMessage(), matchNumbersCount, prize, countOfRank);
    }

    private double calculateRateOfPrize(List<LottoResult> lottoResults) {
        int purchaseAmount = lottoResults.size() * LOTTO_PRICE.getNumber();
        long totalPrize = lottoResults.stream().mapToLong(LottoResult::getPrize).sum();

        double rateOfPrize = ((double) totalPrize / purchaseAmount) * 100;
        return rateOfPrize;
    }

    private String formatRateOfPrize(double rateOfPrize) {
        return String.format(PRINT_RATE_OF_PRIZE_FORMAT.getMessage(), rateOfPrize);
    }
}
