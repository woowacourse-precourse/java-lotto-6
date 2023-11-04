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
                System.out.println();

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
        System.out.println(lottoNum + "개를 구매했습니다.");

        // stream.Collectors 사용하기
        List<List<Integer>> allLottoList = IntStream.range(0, lottoNum)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        System.out.println(allLottoList);
        System.out.println();

        // TODO: 당첨 번호 입력 받기
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String userNum = Console.readLine();
                System.out.println();

                String[] userNumListStr = userNum.split(",");

                int[] userNumListInt = new int[userNumListStr.length];
                for (int i = 0; i < userNumListStr.length; i++) {
                    userNumListInt[i] = Integer.parseInt(userNumListStr[i]);
                }

                if (userNum.startsWith(",") || userNum.endsWith(",")) {
                    throw new IllegalArgumentException("콤마(,)로 시작하거나 끝날 수 없습니다.");
                }
                if (userNumListInt.length != 6) {
                    throw new IllegalArgumentException("6개의 숫자를 입력해 주세요.");
                }
                for (int i = 0; i < userNumListInt.length; i++) {
                    if (userNumListInt[i] > 45 || userNumListInt[i] < 1) {
                        throw new IllegalArgumentException("숫자는 1~45까지 입력할 수 있습니다.");
                    }
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // TODO: 보너스 번호 입력 받기

        // TODO: 로또 번호와 당첨 번호 비교

        // TODO: 당첨 통계 출력

        // TODO: 수익률 계산

        // TODO: 수익률 출력
    }
}
