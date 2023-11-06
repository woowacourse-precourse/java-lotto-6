package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Play {

    private final int lottoCnt;   // 구입한 로또 개수
    private final int lottoNumber = 6;  // 로또는 숫자 6개를 가진다

    public Play(int cost) {
        // 구매 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 발생
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        // 구입한 로또 개수
        this.lottoCnt = cost / 1000;
    }

    // 각 로또의 6자리 숫자 랜덤 생성
    List<Integer> getLottoNums() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);  // 오름차순으로 정렬
        return numbers;
    }

    // 당첨 번호 입력받기
    List<Integer> getAnswerNums() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> nums = Arrays.asList(Console.readLine().split(","));
            if (!checkIs6Num(nums))    // 6개의 숫자가 입력되었는지 확인
                continue;
            List<Integer> answerNums = checkEachNumRange(nums); // 각 숫자가 1~45 사이인지 확인
            if (answerNums != null)
                return answerNums;
        }
    }

    // 6개의 숫자가 입력되었는지 확인
    boolean checkIs6Num(List<String> nums) {
        try {
            if (nums.size() != lottoNumber) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호를 6개 입력해주세요.");
        }
        return false;
    }

    void checkNumRange(int num) {
        if (num <= 0 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자가 1~45범위인지 확인
    List<Integer> checkEachNumRange(List<String> nums) {
        try {
            List<Integer> result = new ArrayList<>();
            for (String n : nums) {
                int eachNum = Integer.parseInt(n);
                checkNumRange(eachNum);
                result.add(Integer.parseInt(n));
            }
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return null;
    }

    int getBonusNum() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonus = Integer.parseInt(Console.readLine());
                checkEachNumRange(new ArrayList<>(bonus));
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void startGame() {
        System.out.println(lottoCnt + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = getLottoNums();
            System.out.println(numbers);
            lottos.add(new Lotto(numbers));
        }
        getAnswerNums();
        getBonusNum();
    }
}
