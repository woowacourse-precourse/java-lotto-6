package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    static final String INPUT_PROMPT_AMOUNT_TO_PAY = "구입금액을 입력해 주세요.";
    static final String PROMPT_LOTTO_COUNT = "8개를 구매했습니다.";
    static final String INPUT_PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    static final String INPUT_PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    static final int LOTTO_PRICE = 1000;

    private int lottoCount;
    private List<Lotto> issuedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoController() {
        issuedLottos = new ArrayList<>();
    }

    private void inputAmountToPay() {
        int totalAmountToPay;

        System.out.println(INPUT_PROMPT_AMOUNT_TO_PAY);
        totalAmountToPay = Integer.parseInt(Console.readLine());
        this.lottoCount = calculateLottoTicketCount(totalAmountToPay);
    }

    private void inputWinningNumbers() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        String winningNumbersInput = Console.readLine();
        String[] winningNumbers = winningNumbersInput.split(",");

        validate(winningNumbers);

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

}
