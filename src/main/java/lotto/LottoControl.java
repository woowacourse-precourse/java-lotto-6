package lotto;
import camp.nextstep.edu.missionutils.Console; import java.util.ArrayList; import java.util.List;
import static java.lang.Integer.parseInt;

public class LottoControl {
    public static int inputLottoPrice() {
        String boughtLottoPrice = Console.readLine();
        inputLottoPriceErrorCheck(parseInt(boughtLottoPrice));

        return parseInt(boughtLottoPrice);
    }

    private static void inputLottoPriceErrorCheck(int boughtLottoPrice) {
        if (boughtLottoPrice <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입한 값은 0 초과의 정수여야 합니다.");
        } else if (boughtLottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입한 값은 1000의 배수인 정수여야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        String[] winningNumbers = Console.readLine().split(",");

        inputWinningNumbersErrorCheck(winningNumbers);

        List<Integer> numbers = new ArrayList<>();

        for(String winningNumber : winningNumbers) {
            numbers.add(parseInt(winningNumber));
        }

        return new Lotto(numbers);
    }

    private static void inputWinningNumbersErrorCheck(String[] winningNumbers) {
        if(winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다.");
        }

        for(String winningNumber : winningNumbers) {
            if(parseInt(winningNumber) < 1 || parseInt(winningNumber) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static int inputBonusNumber(Lotto winningNumbers) {
        int bonusNumber = parseInt(Console.readLine());

        inputBonusNumberErrorCheck(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private static void inputBonusNumberErrorCheck(int bonusNumber, Lotto winningNumbers) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        } else if(winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
