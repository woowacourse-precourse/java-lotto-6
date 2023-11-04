package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static int lottoBought;

    public static void main(String[] args) {
        // TODO: 로또 구입 금액 입력 받기
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                lottoBought = Integer.parseInt(Console.readLine());

                // 예외 처리
                int lottoBought1000 = lottoBought % 1000;
                if (lottoBought1000 != 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1,000원 단위로 입력해 주세요.");
            }
        }

        // TODO: 로또 번호 출력
        int lottoNum = lottoBought / 1000;

        // stream.Collectors 사용하기
        List<List<Integer>> allLottoList = IntStream.range(0, lottoNum)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(allLottoList);

        // TODO: 당첨 번호 입력 받기

        // TODO: 보너스 번호 입력 받기

        // TODO: 로또 번호와 당첨 번호 비교

        // TODO: 당첨 통계 출력

        // TODO: 수익률 계산

        // TODO: 수익률 출력
    }
}
