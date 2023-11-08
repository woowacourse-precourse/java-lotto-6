package lotto.controller;

import lotto.domain.Calculator;
import lotto.domain.Customer;
import lotto.domain.Lucky;
import lotto.domain.ResultRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoManager {
    private Customer customer;
    private Lucky lucky;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ResultRepository resultRepository = new ResultRepository();

    public void buyLotto() {
        try {
            customer = new Customer(inputView.inputMoney());
            customer.pay();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
        showPurchaseList();
    }

    private void showPurchaseList() {
        outputView.printCount(customer.getLottos().size());
        showLottoList();
    }

    private void showLottoList() {
        customer.getLottos().stream()
                .forEach(lotto -> outputView.printLotto(lotto));
    }

    public void checkLucky() {
        while (true) {
            try {
                List<Integer> luckyNumber = getLuckyNumber();
                int bonus = getBonus();
                lucky = new Lucky(luckyNumber, bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonus() {
        return inputView.inputBonus();
    }

    private List<Integer> getLuckyNumber() {
        while (true) {
            try {
                String lucky = inputView.inputLucky();
                List<Integer> luckyNumber = translateLucky(lucky);
                return luckyNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자를 입력하세요.");
            }
        }
    }

    private List<Integer> translateLucky(String target) {
        return translateToInt(separateNames(target));
    }

    private List<String> separateNames(String names) {
        String[] luckyNumber = names.split(",");
        List<String> lucky = new ArrayList<>(Arrays.asList(luckyNumber));
        return lucky;
    }

    private List<Integer> translateToInt(List<String> target) {
        List<Integer> lucky = new ArrayList<>();
        target.stream()
                .forEach(t -> lucky.add(Integer.parseInt(t.trim())));
        return lucky;
    }

    public void showResult() {
        saveResult();
        showStatistics();
        solveRateOfReturn();
    }

    private void saveResult() {
        resultRepository.init();
        customer.getLottos().stream()
                .forEach(lotto -> resultRepository.save(lucky.checkWinning(lotto)));
    }

    private void showStatistics() {
        outputView.printWinningStatistics(resultRepository);
    }

    private void solveRateOfReturn() {
        Calculator calculator = new Calculator();
        outputView.printRateOfReturn(calculator.getRateOfReturn());
    }
}
