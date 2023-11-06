package lotto;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers; //인스턴스 변수 (static이 붙으면 클래스 변수)

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicated_1(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated_1(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateDuplicated_2(numbers, i);
        }
    }

    private void validateDuplicated_2(List<Integer> numbers, int count) {
        int duplicatedCount = -1;
        for (int j = 0; j < numbers.size(); j++) {
            Integer standard = numbers.get(count);
            Integer target = numbers.get(j);
            if (standard.equals(target)) {
                duplicatedCount++;
            }

            if (duplicatedCount >= 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야합니다.");
            }
        }
    }

    protected static int inputYourMoney() {
        int result = 0;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            int price = Integer.parseInt(readLine());
            result = validatePrice(price);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자 형식이 아닙니다.");

            return inputYourMoney();

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액은 1,000원 단위 이어야 합니다.");

            return inputYourMoney();
        }

        return result;
    }

//    protected static int StringToInt(String str) {
//        List<Character> zeroToNine = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            char chr = str.charAt(i);
//            if (zeroToNine.contains(chr)) {
//                result.append(chr);
//            }
//
//            if (!zeroToNine.contains(chr)) {
//                throw new NumberFormatException("[ERROR] 숫자 형식이 아닙니다.");
//            }
//        }
//
//
//        return Integer.parseInt(result.toString());
//    }


    private static int validatePrice(int price) {

        String rest = price % 1000 + "";
        if (!rest.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위 이어야 합니다.");
        }

        return price / 1000;
    }

    protected static List<List<Integer>> myLottoNumber(int count) {
        List<List<Integer>> result = new ArrayList<>();
        System.out.printf("%d개를 구매했습니다.\n", count);

        for (int i = 0; i < count; i++) {
            List<Integer> randomNumber6 = pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(randomNumber6);
            result.add(randomNumber6);
        }

        return result;
    }

    protected static List<Integer> winningNumber() {
        List<Integer> result = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요");
        String winningNumbers = readLine();
        String[] deletedCommaWinningNumbers = winningNumbers.split(",");

        try {
            winningNumberLogic(result, deletedCommaWinningNumbers);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            winningNumber();
        }

        return result;
    }

    protected static List<Integer> winningNumberLogic(List<Integer> result, String[] deletedCommaWinningNumbers) {
        for (String deletedCommaWinningNumber : deletedCommaWinningNumbers) {
            int winningNumber = Integer.parseInt(deletedCommaWinningNumber);
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            result.add(winningNumber);
        }

        return result;
    }


    protected int bonusNumber() {
        int bonusNumber = 0;

        try {
            System.out.println("보너스 번호를 입력해주세요");
            bonusNumber = Integer.parseInt(readLine());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            bonusNumber();
        }
        return bonusNumber;
    }

    protected void lottoGame(int bonusNumber, List<List<Integer>> myLottoNumber) {
        validationDuplicateWinningNumbersAndBonusNumber(bonusNumber);

        List<Integer> gameResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        System.out.printf("당첨 번호 : %s\n", numbers);

        for (int i = 0; i < myLottoNumber.size(); i++) {
            int cnt = 0;
            int bonusCnt = 0;
            for (Integer number : numbers) {
                if (myLottoNumber.get(i).contains(number)) {
                    cnt++;
                }
            }
            if (myLottoNumber.get(i).contains(bonusNumber) && cnt == 5) {
                bonusCnt++;
            }

            gameResult = inputResults(cnt, bonusCnt, gameResult);
        }
        String myProfit = getMyProfit(myLottoNumber.size(), gameResult) + "%";

        lottoResult(gameResult, myProfit);
    }

    protected void validationDuplicateWinningNumbersAndBonusNumber(int bonusNumber) {
        for (Integer number : numbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호가 중복됩니다.");
            }
        }
    }

    private List<Integer> inputResults(int cnt, int bonusCnt, List<Integer> gameResult) {

        if (cnt == 3) {
            gameResult.add(3, gameResult.get(3) + 1);
        }
        if (cnt == 4) {
            gameResult.add(4, gameResult.get(4) + 1);
        }
        if (cnt == 5 && bonusCnt != 1) {
            gameResult.add(5, gameResult.get(5) + 1);
        }
        if (cnt == 5 && bonusCnt == 1) {
            gameResult.add(6, gameResult.get(6) + 1);
        }
        if (cnt == 6) {
            gameResult.add(7, gameResult.get(7) + 1);
        }

        return gameResult;
    }

    private void lottoResult(List<Integer> lottoResult, String myProfit) {
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf(LottoNotice.FIFTH_PLACE.getString() + "%d개\n", lottoResult.get(3));
        System.out.printf(LottoNotice.FORTH_PLACE.getString() + "%d개\n", lottoResult.get(4));
        System.out.printf(LottoNotice.THIRD_PLACE.getString() + "%d개\n", lottoResult.get(5));
        System.out.printf(LottoNotice.SECOND_PLACE.getString() + "%d개\n", lottoResult.get(6));
        System.out.printf(LottoNotice.FIRST_PLACE.getString() + "%d개\n", lottoResult.get(7));
        System.out.printf("총 수익률은 %s입니다.", myProfit);
    }

    private String getMyProfit(int investMoney, List<Integer> lottoResult) {

        double returnMoney = 0;

        for (int i = 0; i < lottoResult.size(); i++) {
            if (i == 3)
                returnMoney += LottoReward.FIFTH_PLACE.getReward() * lottoResult.get(3);
            if (i == 4)
                returnMoney += LottoReward.FORTH_PLACE.getReward() * lottoResult.get(4);
            if (i == 5)
                returnMoney += LottoReward.THIRD_PLACE.getReward() * lottoResult.get(5);
            if (i == 6)
                returnMoney += LottoReward.SECOND_PLACE.getReward() * lottoResult.get(6);
            if (i == 7)
                returnMoney += LottoReward.FIRST_PLACE.getReward() * lottoResult.get(7);

        }
        DecimalFormat df = new DecimalFormat("#,###.#");

        return df.format(returnMoney / (investMoney * 1000) * 100);
    }

}
