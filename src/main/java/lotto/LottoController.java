package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    static final String INPUT_PROMPT_AMOUNT_TO_PAY = "구입금액을 입력해 주세요.";
    static final String PROMPT_LOTTO_COUNT = "개를 구매했습니다.";
    static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String PROMPT_WINNING_STATISTIC = "당첨 통계\n---";
    static final int LOTTO_PRICE = 1000;

    private int totalAmountToPay;
    private int lottoCount;
    private List<Lotto> issuedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<LottoWinningStatus, Integer> winningStatistics;

    public LottoController() {
        issuedLottos = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        winningStatistics = new HashMap<>();

        winningStatistics.put(LottoWinningStatus.THREE_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FOUR_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FIVE_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FIVE_MATCH_WITH_BONUS, 0);
        winningStatistics.put(LottoWinningStatus.SIX_MATCH, 0);
    }

    public void LottoStart() {
        while (true) {
            try {
                inputAmountToPay();
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요");
                continue;
            }

            createLotto();

            displayIssuedLottos();
            try {
                inputWinningNumbers();
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요");
                continue;
            }
            inputBonusNumber();
            calculateWinningResult();


            double rateOfRevenue = calculateRateOfRevenue();
            displayWinningStatistics(rateOfRevenue);

            return;
        }
    }

    private void inputAmountToPay() {
        System.out.println(INPUT_PROMPT_AMOUNT_TO_PAY);
        try {
            this.totalAmountToPay = Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }
        this.lottoCount = calculateLottoTicketCount(totalAmountToPay);
    }

    private void inputWinningNumbers() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        String winningNumbersInput = Console.readLine();
        String[] winningNumbers = winningNumbersInput.split(",");

        validateWinningNumbers(winningNumbers);

        for (String number : winningNumbers) {
            this.winningNumbers.add(Integer.parseInt(number));
        }
    }

    private void inputBonusNumber() {
        System.out.println(INPUT_PROMPT_BONUS_NUMBER);
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    private int calculateLottoTicketCount(int totalAmountToPay) {
        return totalAmountToPay / LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void createLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);

            this.issuedLottos.add(lotto);
        }
    }

    private void displayIssuedLottos() {
        System.out.println(this.lottoCount + PROMPT_LOTTO_COUNT);

        for(Lotto lotto: this.issuedLottos) {
            lotto.displayLottoNumbers();
        }
    }

    private void validateWinningNumbers(String[] numbers) {
        validateInputCount(numbers);
        validateInputIsNumbers(numbers);
        validateNumberRange(numbers);
        validateDuplication(numbers);
    }

    private void validateBonusNumber(String number) {
        validateInputIsNumbers(number);
        validateNumberRange(number);
    }

    private void validateInputCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 형식에 맞춰 입력해주세요.");
        }
    }

    private void validateInputIsNumbers(String[] numbers) {
        for (String inputNumber : numbers) {
            try {
                int number = Integer.parseInt(inputNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    private void validateInputIsNumbers(String inputNumber) {
        try {
            int number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void validateNumberRange(String[] numbers) {
        for (String inputNumber : numbers) {
            int number = Integer.parseInt(inputNumber);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
            }
        }
    }

    private void validateNumberRange(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
        }
    }

    private void validateDuplication(String[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    throw new IllegalArgumentException("[ERROR] 중복 값을 입력했습니다.");
                }
            }
        }
    }

    private int compareToWinningNumber(Lotto lotto) {
        int count = 0;
        for (Integer lottoNumber: lotto.getNumbers()) {
            if (this.winningNumbers.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean compareToBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private void calculateWinningResult() {
        for (Lotto lotto : this.issuedLottos) {
            int winningCount = compareToWinningNumber(lotto);
            boolean isContainBonus = compareToBonusNumber(lotto);
            updateWinningStatistics(winningCount, isContainBonus);
        }
    }

    private void updateWinningCount(LottoWinningStatus MATCH) {
        int currentValue = winningStatistics.get(MATCH);
        int newValue = currentValue + 1;
        this.winningStatistics.replace(MATCH, newValue);

    }

    private void updateWinningStatistics(int count, boolean isContainBonus) {
        if (count == 3) {
           updateWinningCount(LottoWinningStatus.THREE_MATCH);
        }
        if (count == 4) {
            updateWinningCount(LottoWinningStatus.FOUR_MATCH);
        }
        if (count == 5 && !isContainBonus) {
            updateWinningCount(LottoWinningStatus.FIVE_MATCH);
        }
        if (count == 5) {
            updateWinningCount(LottoWinningStatus.FIVE_MATCH_WITH_BONUS);
        }
        if (count == 6) {
            updateWinningCount(LottoWinningStatus.SIX_MATCH);
        }
    }

    private double calculateRateOfRevenue() {
        double revenue = 0;
        for (Map.Entry<LottoWinningStatus, Integer> entry : winningStatistics.entrySet()) {
            revenue += entry.getKey().getPrize() * entry.getValue();
        }
        return revenue / totalAmountToPay;
    }

    private void displayWinningStatistics(double rateOfRevenue) {
        String commonString = "개";

        System.out.println(PROMPT_WINNING_STATISTIC);

        for (Map.Entry<LottoWinningStatus, Integer> entry : winningStatistics.entrySet()) {
            System.out.println(entry.getKey().getPrompt() + entry.getValue() + commonString);
        }

        System.out.println("총 수익률은 " + Math.round(rateOfRevenue * 10000)/100.0 + "%입니다.");
    }


}
