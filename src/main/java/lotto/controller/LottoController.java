package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.validation.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    Lottos lottos = new Lottos();

    private static final int LOTTO_TICKET_PRIZE = 1000;

    public void lottoService() {
        int numberOfLottoTickets = purchaseLottoTickets();
        generateLottoTickets(numberOfLottoTickets);
        showPurchasedLottoTickets();
        Lotto winningNumbers = makeWinningNumbers();
        int bonsNumber = makeBonusNumber(winningNumbers);
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


    public String getPurchaseAmount() {
        String purchaseAmount = inputView.purchaseAmountInput();
        inputValidation.validatePurchaseAmountInput(purchaseAmount);
        return purchaseAmount;
    }

    public int purchaseLottoTickets() {
        String purchaseAmount = getPurchaseAmount();
        return calculateNumberOfLottoTickets(purchaseAmount);
    }

    public void showPurchasedLottoTickets() {
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

    public void generateLottoTickets(int numberOfLottoTickets) {
        for (int i = 0; i < numberOfLottoTickets; i++) {
            Lotto randomLotto = generateRandomLotto();
            randomLotto.sortNumbers();
            lottos.addLotto(randomLotto);
        }
    }

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
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

}