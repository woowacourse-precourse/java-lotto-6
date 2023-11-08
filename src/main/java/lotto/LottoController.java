package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {

    static final String INPUT_PROMPT_AMOUNT_TO_PAY = "구입금액을 입력해 주세요.";
    static final String PROMPT_LOTTO_COUNT = "개를 구매했습니다.";
    static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final String PROMPT_WINNING_STATISTIC = "당첨 통계\n---";
    static final int LOTTO_PRICE = 1000;
    static InputValidation inputValidation = new InputValidation();

    private int totalAmountToPay;
    private int lottoCount;
    private final List<Lotto> issuedLottos;
    private final List<Integer> winningNumbers;
    private int bonusNumber;
    private final Map<LottoWinningStatus, Integer> winningStatistics;

    public LottoController() {
        issuedLottos = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        winningStatistics = new LinkedHashMap<>();

        for (LottoWinningStatus match :LottoWinningStatus.values()) {
            winningStatistics.put(match, 0);
        }
    }

    public void LottoStart() {

        firstPart();

        createLotto();
        displayIssuedLottos();

        calculateWinningResult();

        secondPart();

        thirdPart();

        calculateWinningResult();

        double rateOfRevenue = calculateRateOfRevenue();
        displayWinningStatistics(rateOfRevenue);
    }

    private void firstPart() {
        boolean validInput = false;
        while (!validInput) {
            try {
                inputAmountToPay();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 형식에 맞춰 입력해주세요.");
            }
        }
    }


    private void secondPart() {
        boolean validInput = false;
        while (!validInput) {
            try {
                inputWinningNumbers();
                validInput = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 형식에 맞춰 입력해주세요.");
            }
        }
    }

    private void thirdPart() {
        boolean validInput = false;
        while (!validInput) {
            try {
                inputBonusNumber();
                validInput = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 형식에 맞춰 입력해주세요.");
            }
        }
    }

    private void inputAmountToPay() {
        System.out.println(INPUT_PROMPT_AMOUNT_TO_PAY);
        String amountToPay = Console.readLine();

        inputValidation.validateAmountToPay(amountToPay);

        this.totalAmountToPay = Integer.parseInt(amountToPay);
        this.lottoCount = calculateLottoTicketCount();
    }

    private void inputWinningNumbers() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        String winningNumbersInput = Console.readLine();
        String[] winningNumbers = winningNumbersInput.split(",");

        inputValidation.validateWinningNumbers(winningNumbers);

        for (String number : winningNumbers) {
            this.winningNumbers.add(Integer.parseInt(number));
        }
    }

    private void inputBonusNumber() {
        System.out.println(INPUT_PROMPT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();

        inputValidation.validateBonusNumber(bonusNumber);

        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private int calculateLottoTicketCount() {
        return this.totalAmountToPay / LOTTO_PRICE;
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
