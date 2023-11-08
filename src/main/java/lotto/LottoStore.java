package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class LottoStore {
    private final int FIRST_PLACE = 6;
    private final int SECOND_PLACE = 2;
    private final int THIRD_PLACE = 5;
    private final int FOURTH_PLACE = 4;
    private final int FIFTH_PLACE = 3;
    private final double RATE = 100D;

    private List<Lotto> myLottos;
    private Lotto winningNumber;
    private int bonusNumber;
    private int money;
    private int[] countRanking;

    public LottoStore() {
        myLottos = new ArrayList<Lotto>();
        countRanking = new int[7];
    }

    public void purchaseLotto() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                this.money = Integer.parseInt(input);
                issueLotto();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void printLottos() {
        System.out.println(myLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : myLottos) {
            lotto.printLotto();
        }
        System.out.println();
    }

    public void getWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해주세요.");
                String input = Console.readLine();
                List<Integer> numbers = parseString(input);
                this.winningNumber = new Lotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해주세요.");
                String input = Console.readLine();
                validateBonusNumber(input);
                this.bonusNumber = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
    }

    public void caculatePrize() {
        for (Lotto lotto : this.myLottos) {
            int count = this.winningNumber.countDuplicated(lotto);
            if (count == 5 && lotto.isIncluded(this.bonusNumber)) {
                this.countRanking[SECOND_PLACE]++;
                continue;
            }
            this.countRanking[count]++;
        }
    }

    public void printPrize() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.print("3개 일치 (5,000원) - ");
        System.out.println(this.countRanking[FIFTH_PLACE] + "개");
        System.out.print("4개 일치 (50,000원) - ");
        System.out.println(this.countRanking[FOURTH_PLACE] + "개");
        System.out.print("5개 일치 (1,500,000원) - ");
        System.out.println(this.countRanking[THIRD_PLACE] + "개");
        System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println(this.countRanking[SECOND_PLACE] + "개");
        System.out.print("6개 일치 (2,000,000,000원) - ");
        System.out.println(this.countRanking[FIRST_PLACE] + "개");
    }

    public void printReturn(double returnRate) {
        String roundedReturnRate = String.format("%.1f", returnRate);
        System.out.print("총 수익률은 " + roundedReturnRate + "%입니다.");
    }

    public double calculateReturn() {
        double totalPrize = (double) countRanking[FIFTH_PLACE] * (double) Value.FIFTH_PRIZE.get()
                + (double) countRanking[FOURTH_PLACE] * (double) Value.FOURTH_PRIZE.get()
                + (double) countRanking[THIRD_PLACE] * (double) Value.THIRD_PRIZE.get()
                + (double) countRanking[SECOND_PLACE] * (double) Value.SECOND_PRIZE.get()
                + (double) countRanking[FOURTH_PLACE] * (double) Value.FIFTH_PRIZE.get();
        return totalPrize / (double) this.money * RATE;
    }

    private void validateBonusNumber(String input) {
        validateString(input);
        int number = Integer.parseInt(input);
        if (number < Value.RAINGE_MIN.get() || number > Value.RAINGE_MAX.get()) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1~45여야 합니다.");
        }
        if (winningNumber.isIncluded(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 번호와 중복됩니다.");
        }
    }

    private List<Integer> parseString(String input) {
        String[] splitInput = input.split(",");
        validateInput(splitInput);
        // 마지막이 쉼표로 끝나는 경우 split에서 사라지므로 해당 메서드에서 예외 처리
        if (input.charAt(input.length() - Value.ONE.get()) == ',') {
            throw new IllegalArgumentException("[ERROR] 값이 비어있습니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String s : splitInput) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private void validateInput(String[] input) {
        if (input.length == Value.IS_EMPTY.get()) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다.");
        }
        for (String s : input) {
            validateString(s);
        }
    }

    private void validateString(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값이 비어있습니다.");
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 값에는 숫자만 입력해야 합니다.");
            }
        }
    }

    private void issueLotto() {
        int number = this.money / Value.LOTTO_PRICE.get();
        for (int i = Value.ZERO.get(); i < number; ++i) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLottos.add(new Lotto(lottoNumbers));
        }
    }

    private void validateMoney(String number) {
        for (int i = Value.ZERO.get(); i < number.length(); ++i) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자로 된 금액을 입력해야 합니다.");
            }
        }
        if (Integer.parseInt(number) <= Value.ZERO.get()) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수를 입력해야 합니다");
        }
        if (Integer.parseInt(number) % Value.LOTTO_PRICE.get() != Value.ZERO.get()) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 금액을 입력해야 합니다.");
        }
    }
}
