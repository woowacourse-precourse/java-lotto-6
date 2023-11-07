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
    InputValidation inputValidation = new InputValidation();

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

    public int makeBonusNumber(Lotto winningNumbers) {
        String inputBonusNumber = getBonusNumber();
        validateBonusNumber(winningNumbers.getNumbers(), inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    public String getBonusNumber() {
        return inputView.bonusNumberInput();
    }

    public void validateBonusNumber(List<Integer> winningNumbers, String inputBonusNumber) {
        inputValidation.validateBonusNumberInput(winningNumbers, inputBonusNumber);
    }

    public int getPurchaseAmount() {
        String purchaseAmount = inputView.purchaseAmountInput();
        inputValidation.validatePurchaseAmountInput(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public int purchaseLottoTickets(int purchaseAmount) {
        return calculateNumberOfLottoTickets(purchaseAmount);
    }

    public void showPurchasedLottoTickets(Lottos lottos) {
        List<Lotto> generatedLottos = lottos.getLottos();
        showNumberOfLottos(generatedLottos.size());
        for (Lotto lotto : generatedLottos) {
            showGeneratedLottos(lotto.getNumbers());
        }
    }

    public Lotto makeWinningNumbers() {
        List<String> inputWinningNumbers = splitWinningNumbers(getWinningNumbers());
        validateWinningNumbers(inputWinningNumbers);
        return makeWinningNumbersToLotto(inputWinningNumbers);
    }

    public String getWinningNumbers() {
        return inputView.winningNumbersInput();
    }

    public List<String> splitWinningNumbers(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }

    public void validateWinningNumbers(List<String> numbers) {
        inputValidation.validateWinningNumbersInput(numbers);
    }

    public Lotto makeWinningNumbersToLotto(List<String> winningNumbers) {
        List<Integer> winningLottoNumbers = winningNumbers.stream()
            .map(Integer::parseInt)
            .toList();
        return new Lotto(winningLottoNumbers);
    }

    public Lottos generateLottoTickets(int numberOfLottoTickets) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto randomLotto = generateRandomLotto();
            randomLotto.sortNumbers();
            lottos.addLotto(randomLotto);
        }
        return lottos;
    }

    public int calculateNumberOfLottoTickets(int purchaseAmount) {
        int parsedPurchaseAmount = purchaseAmount;
        return parsedPurchaseAmount / LOTTO_TICKET_PRIZE;
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
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
        long tempPurchaseAmount = purchaseAmount;
        double totalRevenue = (double) totalPrize / tempPurchaseAmount;
        return totalRevenue;
    }

    private void showTotalRevenue(double totalRevenue) {
        outputView.printTotalRevenue(totalRevenue);
    }

}