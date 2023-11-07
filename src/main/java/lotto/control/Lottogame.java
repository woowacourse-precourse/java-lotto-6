package lotto.control;public class Lottogame {
  Lottogameview view = new Lottogameview();

    public void runLottoGame() {
        int purchaseAmount = inputPurchaseAmount();
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        List<Lotto> lottos = generateLottos(purchaseAmount);
        view.printPurchasedLottosCount(lottos.size());
        view.printPurchasedLottos(lottos);


        int[] winCounts = checkWinCounts(lottos, winningNumbers, bonusNumber);

        view.printWinningResult(winCounts, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        int purchaseAmount = readPurchaseAmount();
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private int readPurchaseAmount() {
        int purchaseAmount = 0;
        while (purchaseAmount < 1000) {
            purchaseAmount = readIntWithMessage("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.\n로또 구입 금액을 입력해 주세요.");
        }
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        while (winningNumbers.size() != 6) {
            try {
                String input = readLineWithMessage("당첨 번호를 입력해 주세요. (쉼표(,)로 구분)");
                winningNumbers = parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private List<Integer> parseWinningNumbers(String input) {
        String[] numbers = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            try {
                int num = parseIntWithMessage(number, "[ERROR] 유효한 번호를 입력해 주세요.");
                validateWinningNumber(num);
                winningNumbers.add(num);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        validateWinningNumbersCount(winningNumbers);
        return winningNumbers;
    }

    private void validateWinningNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 유효한 번호를 입력해 주세요.");
        }
    }

  
}
