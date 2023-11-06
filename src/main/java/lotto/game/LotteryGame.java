package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PriceValidator;

public class LotteryGame {
    private List<Lotto> lottoList;
    private WinNumber winNumber;
    private InputHandler inputHandler = new InputHandler();
    private OutputHandler outputHandler = new OutputHandler();
    private final String ERROR = "[ERROR]";
    private final String REQUEST_PRICE = "구입금액을 입력해 주세요.";
    private final String REQUEST_NUMBERS = "당첨 번호를 입력해 주세요.";

    public void run() {

    }

    private void init() {
        outputHandler.print(REQUEST_PRICE);
        lottoList = getLottoList(getPrice());
        outputHandler.print(REQUEST_NUMBERS);
        winNumber = getWinNumber();
    }

    private int getPrice() {
        while (true) {
            try {
                String inputPrice = inputHandler.readLine();
                PriceValidator.isInteger(inputPrice);

                int price = Integer.parseInt(inputPrice);

                PriceValidator.validateCost(price);
                PriceValidator.validateThousand(price);

                return price;
            } catch (IllegalArgumentException e) {
                outputHandler.print(ERROR+e.getMessage());
            }
        }
    }

    private List<Lotto> getLottoList(int price) {
        int count = price / 1000;
        Lotto[] lottos = new Lotto[price / 1000];
        for (int i = 0; i < count; i++) {
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return Arrays.asList(lottos);
    }

    private WinNumber getWinNumber(){
        while (true){
            try{
                List<Integer> numbers = getLottoNumbers();
                return new WinNumber(numbers, getBonusNumber(numbers));
            }catch (IllegalArgumentException e){
                outputHandler.print(e.getMessage());
            }
        }
    }

    private List<Integer> getLottoNumbers() {
        while (true) {
            try {
                String[] inputNumbers = inputHandler.readLine().split(",");
                Integer[] numbers = new Integer[inputNumbers.length];
                for (String number : inputNumbers){
                    LottoNumberValidator.isInteger(number);
                }

                return Arrays.asList(numbers);
            } catch (IllegalArgumentException e) {
                outputHandler.print(ERROR+e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> numbers){
        while (true) {
            try {
                String inputNumber = inputHandler.readLine();
                LottoNumberValidator.isInteger(inputNumber);
                int bonusNumber = Integer.parseInt(inputNumber);
                LottoNumberValidator.validateDuplicatedNumber(numbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputHandler.print(ERROR+e.getMessage());
            }
        }
    }
}