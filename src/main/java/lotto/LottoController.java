package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {

    static final String INPUT_PROMPT_AMOUNT_TO_PAY = "구입금액을 입력해 주세요.";
    static final String PROMPT_LOTTO_COUNT = "8개를 구매했습니다.";
    static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final int LOTTO_PRICE = 1000;

    private int totalAmountToPay;
    private int lottoCount;
    private List<Lotto> issuedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<LottoWinningStatus, Integer> winningStatistics;

    public LottoController() {
        issuedLottos = new ArrayList<>();
        winningStatistics = new HashMap<>();

        winningStatistics.put(LottoWinningStatus.THREE_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FOUR_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FIVE_MATCH, 0);
        winningStatistics.put(LottoWinningStatus.FIVE_MATCH_WITH_BONUS, 0);
        winningStatistics.put(LottoWinningStatus.SIX_MATCH, 0);
    }

    public void inputAmountToPay() {
        System.out.println(INPUT_PROMPT_AMOUNT_TO_PAY);
        this.totalAmountToPay = Integer.parseInt(Console.readLine());
        this.lottoCount = calculateLottoTicketCount(totalAmountToPay);
    }

    public void inputWinningNumbers() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        String winningNumbersInput = Console.readLine();
        String[] winningNumbers = winningNumbersInput.split(",");

        validate(winningNumbers);

        for (String number : winningNumbers) {
            this.winningNumbers.add(Integer.parseInt(number));
        }
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_PROMPT_BONUS_NUMBER);
        this.bonusNumber = Integer.parseInt(Console.readLine());
    }

    private int calculateLottoTicketCount(int totalAmountToPay) {
        return totalAmountToPay / LOTTO_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void createLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);

            this.issuedLottos.add(lotto);
        }
    }

    public void displayIssuedLottos() {
        System.out.println(PROMPT_LOTTO_COUNT);

        for(Lotto lotto: this.issuedLottos) {
            lotto.displayLottoNumbers();
        }
    }

    private void validate(String[] numbers) {
        validateInputCount(numbers);
        validateInputIsNumbers(numbers);
        validateInputNumberRange(numbers);
    }

    private void validateInputCount(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 형식에 맞춰 입력해주세요.");
        }
    }

    private void validateInputIsNumbers(String[] numbers) {
        for (String numberStr : numbers) {
            try {
                int number = Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    private void validateInputNumberRange(String[] numbers) {
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요.");
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

    private void updateWinningCount(LottoWinningStatus MATCH) {
        int currentValue = winningStatistics.get(MATCH);
        int newValue = currentValue + 1;
        this.winningStatistics.replace(MATCH, newValue);

    }

    private void updateWinningStatistics(int count, boolean bonus) {
        if (count == 3) {
           updateWinningCount(LottoWinningStatus.THREE_MATCH);
        }
        if (count == 4) {
            updateWinningCount(LottoWinningStatus.FOUR_MATCH);
        }
        if (count == 5 && !bonus) {
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

    public void displayWinningStatistics(double rateOfRevenue) {
        String commonString = "개";

        for (Map.Entry<LottoWinningStatus, Integer> entry : winningStatistics.entrySet()) {
            System.out.println(entry.getKey().getPrompt() + entry.getValue() + commonString);
        }

        System.out.println("총 수익률은 " + rateOfRevenue + "%입니다.");
    }


}
