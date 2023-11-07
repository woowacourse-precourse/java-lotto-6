package view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class InputView {
    private static final int START = 1;
    private static final int END = 45;
    private static final int SIZE = 6;

    private static List<Integer> winner;

    public static int inputNumber() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int count = convertToInt(Console.readLine());
                countCheck(count);
                negativeCheck(count);

                return count;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static List<Lotto> generateLotto(int count) {
        int index = 0;
        List<Lotto> lottos = new ArrayList<>();

        while (index < count) {
            try {
                List<Integer> lotto = Randoms.pickUniqueNumbersInRange(START, END, SIZE);
                lottos.add(new Lotto(lotto));
                index += 1;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] 로또 번호를 확인해 주세요.");
            }
        }

        return lottos;
    }

    public static Lotto inputWinnerLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                winner = makeLottoList(Console.readLine());

                return new Lotto(winner);
           } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        System.out.println();

        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonusNumber = convertToInt(Console.readLine());
                duplicationCheck(winner, bonusNumber);
                rangeCheck(bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void countCheck(int count) throws IllegalArgumentException {
        if (count % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매가격은 1,000원 단위로 입력해주세요.");
        }
    }

    public static void negativeCheck(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 가격은 0이상의 정수로 입력해주세요.");
        }
    }

    public static int convertToInt(String number) {
        try {
            int count = Integer.parseInt(number);
            return count;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void duplicationCheck(List<Integer> lotto, int bonusNumber) throws IllegalArgumentException {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 보너스 번호를 포함하고 있습니다.");
        }
    }

    public static void rangeCheck(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < START || bonusNumber > END) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1과 45사이 정수입니다.");
        }
    }

    public static List<Integer> makeLottoList(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        List<Integer> lotto = new ArrayList<>();

        for (String number : numbers) {
            lotto.add(convertToInt(number));
        }

        return lotto;
    }
}
