package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        int cash = inputLottoPayCount();


        int count = cash / 1000;
        System.out.println(count + "개를 구매했습니다.");
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Integer::compareTo);
            lottoList.add(numbers);
        }
        lottoList.forEach(i -> {
            System.out.println(i.toString());
        });

        // todo: 예외처리 진행
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumber = Console.readLine();
        List<Integer> list = Arrays.stream(inputLottoNumber.split(",")).map(i -> isValidNumberFormat()).collect(Collectors.toList());
        // todo: 1  ~ 45까지만 있는지 확인
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = isValidNumberFormat();
        Lotto lotto = new Lotto(list, bonusNumber);

    }

    private static int inputLottoPayCount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int cash = isValidNumberFormat();
            checkNotThousandAndNegativeException(cash);
            return cash;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            inputLottoPayCount();
        }
        return 0;
    }

    private static void checkNotThousandAndNegativeException(int count) {
        if (count % 1000 != 0 || count < 0) throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
    }

    private static int isValidNumberFormat() {
        int count;
        try {
            count = Integer.parseInt(Console.readLine());
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로 입력해주세요.");
        }
    }
}
