package lotto;

import java.util.ArrayList;
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
    private void validateDuplicated_2(List<Integer> numbers, int count){
        int duplicatedCount = -1;
        for (int j = 0; j < numbers.size(); j++) {
            Integer standard = numbers.get(count);
            Integer target = numbers.get(j);
            if (standard.equals(target)) {
                duplicatedCount++;
            }

            if (duplicatedCount >= 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    protected static int inputYourMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(readLine());

        return validatePrice(price);
    }

    private static int validatePrice(int price) {
        String rest = price % 1000 + "";

        try {
            if (!rest.equals("0")) {
                throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위 이어야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputYourMoney();
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

        try{
            winningNumberLogic(result, deletedCommaWinningNumbers);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
            winningNumber();
        }

        return result;
    }

    private static List<Integer> winningNumberLogic(List<Integer> result, String[] deletedCommaWinningNumbers) {
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
        System.out.println("보너스 번호를 입력해주세요");
        int bonusNumber = Integer.parseInt(readLine());

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
System.out.println(numbers);
        return bonusNumber;
    }

    protected void lottoGame(int count, int bonusNumber, List<List<Integer>> myLottoNumber) {
        List<Integer> gameResult = new ArrayList<>();

        for (int i = 0; i <  myLottoNumber.size(); i++) {
            System.out.println("로또게임 : "+numbers.get(i));
        }

        lottoResult(gameResult);
    }


    private void lottoResult(List<Integer> lottoResult) {
        System.out.println("당첨통계");
        System.out.println("---");
//        System.out.printf(LottoNotice.FIFTH_PLACE+"%d개",lottoResult.get(2));
//        System.out.printf(LottoNotice.FORTH_PLACE+"%d개",lottoResult.get(3));
//        System.out.printf(LottoNotice.THIRD_PLACE+"%d개",lottoResult.get(4));
//        System.out.printf(LottoNotice.SECOND_PLACE+"%d개",lottoResult.get(5));
//        System.out.printf(LottoNotice.FIRST_PLACE+"%d개",lottoResult.get(6));

    }


}
