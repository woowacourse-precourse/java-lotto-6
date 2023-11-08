package game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.WinningNumber;
import validator.InputValidator;
import view.constants.ConstantMessage;

public class GameService {

    public void play() {

        System.out.println(ConstantMessage.PURCHASE_PRICE_INPUT.getMessage());
        int price = getPrice();

        List<Lotto> lottos = createLottoByPrice(price);
        getLottoByPrice(lottos);

        List<Integer> winningNumber = getWinningNumber();
        int bonus = getBonusNumber(winningNumber);
        WinningNumber winningNumberAndBonus = new WinningNumber(winningNumber, bonus);

        printWinningResult(lottos, winningNumberAndBonus, price);

    }

    public int getPrice() {
        int price = 0;
        while (true) {
            try {
                String priceInput = Console.readLine();
                InputValidator.validatePurchasePrice(priceInput);
                price = Integer.parseInt(priceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    public List<Lotto> createLottoByPrice(int price) {
        List<Lotto> lottos = new ArrayList<>();
        int createLottoNumber = price / 1000;
        System.out.println(createLottoNumber + ConstantMessage.PURCHASE_NUMBER_OUTPUT.getMessage());

        for (int i = 0; i < createLottoNumber; i++) {
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(newLotto);
            lottos.add(new Lotto(newLotto));
        }
        return lottos;
    }

    public void getLottoByPrice(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println(ConstantMessage.WINNING_NUMBER_INPUT.getMessage());

        String[] winningNumberInput;
        while (true) {
            try {
                winningNumberInput = Console.readLine().split(",");
                InputValidator.validateWinningNumber(winningNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Integer> winningNumbers = getWinningNumberStringToInteger(winningNumberInput);
        return winningNumbers;
    }

    public List<Integer> getWinningNumberStringToInteger(String[] winningNumberInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumberInput) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(ConstantMessage.BONUS_INPUT.getMessage());

        int bonus = 0;
        while (true) {
            try {
                String bonusInput = Console.readLine();
                InputValidator.validateBonus(bonusInput, winningNumbers);
                bonus = Integer.parseInt(bonusInput);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
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