package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    enum Prize {
        THREE(5000), FOUR(50000), FIVE(1500000), FIVEBONUS(30000000), SIX(2000000000);
        private final int prizeMoney;
        Prize(int prizeMoney) {
            this.prizeMoney = prizeMoney;
        }
        public int getPrizeMoney() {
            return this.prizeMoney;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int unit = 1000;
        final int startLottoNumber = 1;
        final int endLottoNumber = 45;
        final int pickLottoCount = 6;

        int money = 0;
        List<Lotto> purchasedLottos = new ArrayList<>();
        List<Integer> inputLottoNumber = new ArrayList<>();
        Lotto winLotto = null;
        int bonusLotto;
        int[] counts = new int[5];
        int sumMoney = 0;
        float returnRate = 0.0f;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입금액은 정수여야 합니다.");
            return;
        }
        if(money % unit != 0) {
            System.out.println("[ERROR] 구입금액은 " + unit + "원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        System.out.println("\n" + (money / unit) + "개를 구매했습니다.");
        for(int i=0; i<money/unit; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(startLottoNumber, endLottoNumber, pickLottoCount));
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
            purchasedLottos.add(new Lotto(numbers));
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] inputs = Console.readLine().split(",");
        for(int i=0; i<inputs.length; i++) {
            int input = Integer.parseInt(inputs[i]);
            inputLottoNumber.add(input);
        }
        winLotto = new Lotto(inputLottoNumber);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonusLotto = Integer.parseInt(Console.readLine());
        validateRange(bonusLotto, startLottoNumber, endLottoNumber);
        validateDuplicate(bonusLotto, inputLottoNumber);

        for(int i=0; i<purchasedLottos.size(); i++) {
            int count = countMatchNumber(purchasedLottos.get(i), winLotto, bonusLotto);
            int index = classifyCountByIndex(count);

            if(index == -1) continue;

            sumMoney += prizeMoney(index);
            counts[index]++;
        }
        returnRate = (float)sumMoney / money * 100;

        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + counts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + counts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts[4] + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
    }

    public static void validateDuplicate(int number, List<Integer> inputLottoNumber) {
        if(inputLottoNumber.contains(number)) {
            System.out.println("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(int number, int startLottoNumber, int endLottoNumber) {
        if(number > endLottoNumber || number < startLottoNumber) {
            System.out.println("[ERROR] 로또 번호는 " + startLottoNumber + "부터 " + endLottoNumber + " 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static int countMatchNumber(Lotto purchasedLotto, Lotto winLotto, int bonusLotto) {
        int count = 0;

        for(int i=0; i<purchasedLotto.getNumbers().size(); i++) {
            if(winLotto.getNumbers().contains(purchasedLotto.getNumbers().get(i))) {
                count++;
            }
            if(bonusLotto == purchasedLotto.getNumbers().get(i)) {
                count += 10;
            }
        }

        return count;
    }

    public static int classifyCountByIndex(int count) {
        if(count == 15) return 3;
        if(count%10 == 3) return 0;
        if(count%10 == 4) return 1;
        if(count%10 == 5) return 2;
        if(count%10 == 6) return 4;
        return -1;
    }

    public static int prizeMoney(int index) {
        Prize prize = null;

        if(index == 0) prize = Prize.THREE;
        if(index == 1) prize = Prize.FOUR;
        if(index == 2) prize = Prize.FIVE;
        if(index == 3) prize = Prize.FIVEBONUS;
        if(index == 4) prize = Prize.SIX;

        return prize.getPrizeMoney();
    }
}