package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumber;
import view.constants.ConstantMessage;

public class GameService {

    public void play() {

        System.out.println(ConstantMessage.PURCHASE_PRICE_INPUT.getMessage());
        int price = getPrice();

        List<Lotto> lottos = createLottoByPrice(price);
        getLottoByPrice(lottos);

        WinningNumber winningNumber = getWinningNumber();
        printWinningResult(lottos, winningNumber, price);

    }

    public int getPrice() {
        int price = 0;
        while (price == 0) {
            try {
                String priceInput = Console.readLine();
                validatePurchasePrice(priceInput);
                price = Integer.parseInt(priceInput);
                return price;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public void validatePurchasePrice(String price) {
        if (!price.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
        }
        if (Integer.parseInt(price) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }

    public List<Lotto> createLottoByPrice(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int createLottoNumber = price / 1000;
        System.out.println(createLottoNumber + ConstantMessage.PURCHASE_NUMBER_OUTPUT.getMessage());

        for (int i = 0; i < createLottoNumber; i++) {
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(newLotto));
        }
        return lottos;
    }

    public void getLottoByPrice(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public WinningNumber getWinningNumber() {
        System.out.println(ConstantMessage.WINNING_NUMBER_INPUT.getMessage());
        List<Integer> winningNumbers = new ArrayList<>();

        while (winningNumbers.size() != 6) {
            try {
                String[] winningNumberInput = Console.readLine().split(",");
                validateWinningNumber(winningNumberInput);
                for (String number : winningNumberInput) {
                    winningNumbers.add(Integer.parseInt(number));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        WinningNumber winningNumber;

        int bonus = getBonusNumber(winningNumbers);

        winningNumber = new WinningNumber(winningNumbers, bonus);
        return winningNumber;
    }

    public void validateWinningNumber(String[] winningNumber) {
        if (winningNumber.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자여야 합니다.");
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (String number : winningNumber) {
            if (!number.matches("\\d+")) {
                throw new NumberFormatException("[ERROR] 숫자만 입력 가능합니다.");
            }
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (uniqueNumbers.contains(Integer.parseInt(number))) {
                throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
            }
            uniqueNumbers.add(Integer.parseInt(number));
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(ConstantMessage.BONUS_INPUT.getMessage());
        int bonus = 0;
        while (bonus == 0) {
            try {
                String bonusInput = Console.readLine();
                validateBonus(bonusInput, winningNumbers);
                bonus = Integer.parseInt(bonusInput);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    public void validateBonus(String bonus, List<Integer> winningNumbers) {
        if (!bonus.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(bonus) < 1 || Integer.parseInt(bonus) > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되는 숫자입니다.");
        }
    }

    public void printWinningResult(List<Lotto> lottos, WinningNumber winningNumber, int price) {
        int[] lottoResult = new int[lottos.size()];
        int[] bonus = new int[lottos.size()];
        int index = 0;

        for (Lotto lotto : lottos) {
            for (int number : lotto.getLotto()) {
                if (winningNumber.getLotto().contains(number)) {
                    lottoResult[index]++;
                }
                if (winningNumber.getBonus() == number) {
                    bonus[index]++;
                }
            }
            index++;
        }

        int[] winningResult = new int[5];
        for (int i = 0; i < lottos.size(); i++) {
            if (lottoResult[i] == 5 && bonus[i] == 1) {
                winningResult[3]++;
                continue;
            }
            if (lottoResult[i] == 6) {
                winningResult[4]++;
                continue;
            }
            if (lottoResult[i] == 3 || lottoResult[i] == 4 || lottoResult[i] == 5) {
                winningResult[lottoResult[i] - 3]++;
            }
        }

        System.out.println(ConstantMessage.WINNING_RESULT_TITLE.getMessage());
        System.out.println(ConstantMessage.WINNING_RESULT_UNDERSCORE.getMessage());
        System.out.println(ConstantMessage.WINNING_RESULT_THREE.getMessage() + winningResult[0]
                + ConstantMessage.NUMBER_UNIT.getMessage());
        System.out.println(ConstantMessage.WINNING_RESULT_FOUR.getMessage() + winningResult[1]
                + ConstantMessage.NUMBER_UNIT.getMessage());
        System.out.println(ConstantMessage.WINNING_RESULT_FIVE.getMessage() + winningResult[2]
                + ConstantMessage.NUMBER_UNIT.getMessage());
        System.out.println(
                ConstantMessage.WINNING_RESULT_FIVE_AND_BONUS.getMessage() + winningResult[3]
                        + ConstantMessage.NUMBER_UNIT.getMessage());
        System.out.println(ConstantMessage.WINNING_RESULT_SIX.getMessage() + winningResult[4]
                + ConstantMessage.NUMBER_UNIT.getMessage());

        int totalBenefit = 5000 * winningResult[0] + 50000 * winningResult[1] + 1_500_000 * winningResult[2]
                + 30_000_000 * winningResult[3] + 2_000_000_000 * winningResult[4];
        double rateOfReturn =
                roundToTwoDecimalPlaces(totalBenefit, price);

        System.out.println(
                ConstantMessage.TOTAL_BENEFIT_FIRST.getMessage() + rateOfReturn
                        + ConstantMessage.TOTAL_BENEFIT_LAST.getMessage());
    }

    public double roundToTwoDecimalPlaces(int totalBenefit, int price) {
        double result = totalBenefit * 100.0 / price;
        return Math.round(result * 10) / 10.0;
    }

}
