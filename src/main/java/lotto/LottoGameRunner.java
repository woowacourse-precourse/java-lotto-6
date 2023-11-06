package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lotto.Lotto;
import lotto.lotto.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameRunner {

    private Lottos lottos;
    private PurchaseAmount purchaseAmount;

    private WinningLottoCounter winningLottoCounter;

    public void run() {
        Long amount = getPurchaseAmountFromUser();
        purchaseAmount = new PurchaseAmount(amount);
        int numberOfLotto = purchaseAmount.calculateNumberOfLotto();
        Printer.printNumberOfLotto(numberOfLotto);

        lottos = new Lottos(issueLottos(numberOfLotto));
        lottos.print();

        List<Integer> winningNumber = getWinningNumberFromUser();
        System.out.println();
        Integer bonusNumber = getBonusNumberFromUser(winningNumber);

        winningLottoCounter = new WinningLottoCounter();
        lottos.calculateMatchesOfNumber(bonusNumber, winningNumber, winningLottoCounter);
        double percentage = ((double) winningLottoCounter.getTotalPrizeMoney() /
                purchaseAmount.getPurchaseAmount()) * 100;

        Printer.printStatistics(winningLottoCounter, percentage);
    }

    private Long getPurchaseAmountFromUser() {
        String input = null;
        boolean check = false;

        while (!check) {
            input = UserInputReceiver.receivePurchaseAmount();
            check = isPurchaseAmountValid(input);
        }
        return Long.parseLong(input);
    }

    private boolean isPurchaseAmountValid(String input) {
        try {
            GlobalValidator.validatePurchaseAmount(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Lotto> issueLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> getWinningNumberFromUser() {
        String input = null;
        boolean check = false;
        List<String> separatedInput = null;

        while(!check) {
            input = UserInputReceiver.receiveWinningNumber();
            separatedInput = Arrays.asList(input.split(", *"));
            check = isWinningNumberValid(separatedInput);
        }
        return convertToInteger(separatedInput);
    }


    private boolean isWinningNumberValid(List<String> separatedInput) {
        try {
            GlobalValidator.validateWinningNumber(separatedInput);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private List<Integer> convertToInteger(List<String> separatedInput) {
        return separatedInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Integer getBonusNumberFromUser(List<Integer> winningNumber) {
        String input = null;
        boolean check = false;

        while (!check) {
            input = UserInputReceiver.receiveBonusNumber();
            check = isBonusNumberValid(winningNumber, input);
        }
        return Integer.parseInt(input);
    }

    private boolean isBonusNumberValid(List<Integer> winningNumber, String input) {
        try {
            GlobalValidator.validateBonusNumber(winningNumber, input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
