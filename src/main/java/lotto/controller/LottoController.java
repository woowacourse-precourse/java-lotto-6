package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.validation.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private static final int LOTTO_TICKET_PRIZE = 1000;

    public void lottoService() {
        int purchaseAmount = getPurchaseAmount();
        int numberOfLottoTickets = purchaseLottoTickets(purchaseAmount);
        Lottos generatedLottos = generateLottoTickets(numberOfLottoTickets);
        showPurchasedLottoTickets(generatedLottos);

        Lotto winningNumbers = makeWinningNumbers();
        int bonsNumber = makeBonusNumber(winningNumbers);

        List<Integer> matchResult = totalMatchResult(generatedLottos, winningNumbers, bonsNumber);
        LottoResult lottoResult = calculateWinningCount(matchResult);
        showMatchResult(lottoResult);

        double totalRevenue = calculateTotalRevenue(calculateTotalPrize(lottoResult),
            purchaseAmount);
        showTotalRevenue(totalRevenue);
    }

    private int makeBonusNumber(Lotto winningNumbers) {
        try {
            String inputBonusNumber = getBonusNumber();
            validateBonusNumber(winningNumbers.getNumbers(), inputBonusNumber);
            return Integer.parseInt(inputBonusNumber);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return makeBonusNumber(winningNumbers);
        }
    }

    private String getBonusNumber() {
        return inputView.bonusNumberInput();
    }

    private void validateBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        InputValidation.validateBonusNumberInput(winningNumbers, inputBonusNumber);
    }

    private int getPurchaseAmount() {
        try {
            String purchaseAmount = inputView.purchaseAmountInput();
            InputValidation.validatePurchaseAmountInput(purchaseAmount);
            return Integer.parseInt(purchaseAmount);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return getPurchaseAmount();
        }
    }

    private int purchaseLottoTickets(int purchaseAmount) {
        return calculateNumberOfLottoTickets(purchaseAmount);
    }

    private void showPurchasedLottoTickets(Lottos lottos) {
        List<Lotto> generatedLottos = lottos.getLottos();
        showNumberOfLottos(generatedLottos.size());
        for (Lotto lotto : generatedLottos) {
            showGeneratedLottos(lotto.getNumbers());
        }
    }

    private Lotto makeWinningNumbers() {
        try {
            List<String> inputWinningNumbers = splitWinningNumbers(getWinningNumbers());
            validateWinningNumbers(inputWinningNumbers);
            return makeWinningNumbersToLotto(inputWinningNumbers);
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return makeWinningNumbers();
        }
    }

    private String getWinningNumbers() {
        return inputView.winningNumbersInput();
    }

    private List<String> splitWinningNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }

    private void validateWinningNumbers(List<String> numbers) {
        InputValidation.validateWinningNumbersInput(numbers);
    }

    private Lotto makeWinningNumbersToLotto(List<String> winningNumbers) {
        List<Integer> winningLottoNumbers = winningNumbers.stream()
            .map(Integer::parseInt)
            .toList();
        return new Lotto(winningLottoNumbers);
    }

    private Lottos generateLottoTickets(int numberOfLottoTickets) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto randomLotto = generateRandomLotto();
            lottos.addLotto(randomLotto);
        }
        return lottos;
    }

    private int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / LOTTO_TICKET_PRIZE;
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto randomLotto = new Lotto(randomNumbers);
        List<Integer> sortedNumbers = randomLotto.sortNumbers();
        return new Lotto(sortedNumbers);
    }

    private void showNumberOfLottos(int numberOfLottoTickets) {
        outputView.printNumberOfPurchasedLottoTickets(numberOfLottoTickets);
    }

    private void showGeneratedLottos(List<Integer> lotto) {
        outputView.printGeneratedLottos(lotto);
    }

    private Integer calculateMatchCount(Lotto generatedLotto, Lotto winningNumbers) {
        List<Integer> winningLottoNumbers = winningNumbers.getNumbers();
        Integer matchCount = 0;
        for (Integer number : generatedLotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusNumberMatch(Lotto winningNumbers, Integer bonusNumber) {
        return winningNumbers.getNumbers().contains(bonusNumber);
    }

    private int calculateMatchResult(Lotto generatedLotto, Lotto winningNumbers,
        Integer bonusNumber) {
        int matchCount = calculateMatchCount(generatedLotto, winningNumbers);
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && isBonusNumberMatch(winningNumbers, bonusNumber)) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    private List<Integer> totalMatchResult(Lottos lottos, Lotto winningNumbers, int bonusNumber) {
        List<Integer> matchResult = new ArrayList<>();
        for (Lotto eachLotto : lottos.getLottos()) {
            matchResult.add(calculateMatchResult(eachLotto, winningNumbers, bonusNumber));
        }
        return matchResult;
    }

    private LottoResult calculateWinningCount(List<Integer> matchResults) {
        LottoResult lottoResult = new LottoResult();
        for (int winningRanks : matchResults) {
            lottoResult.incrementCount(winningRanks);
        }
        return lottoResult;
    }

    private void showMatchResult(LottoResult lottoResult) {
        outputView.printWinningStatic();
        outputView.printMatchPrize(lottoResult);
    }

    private long calculateTotalPrize(LottoResult lottoResult) {
        long totalPrize = 0;
        totalPrize += 5000L * lottoResult.getCount(5);
        totalPrize += 50000L * lottoResult.getCount(4);
        totalPrize += 1500000L * lottoResult.getCount(3);
        totalPrize += 30000000L * lottoResult.getCount(2);
        totalPrize += 2000000000L * lottoResult.getCount(1);
        return totalPrize;
    }

    private double calculateTotalRevenue(Long totalPrize, int purchaseAmount) {
        double totalRevenue = (double) totalPrize / (long) purchaseAmount;
        return totalRevenue * 100;
    }

    private void showTotalRevenue(double totalRevenue) {
        outputView.printTotalRevenue(totalRevenue);
    }

}