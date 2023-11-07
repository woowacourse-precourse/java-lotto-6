package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Display {
    static int readPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            int price = Integer.parseInt(input);
            if(price % 1000 > 0) {
                throw new IllegalStateException();
            }
            System.out.println(price / 1000 + "개를 구매했습니다.");
            return price;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        try {
            String[] tokens = input.split(",");
            return Arrays.stream(tokens).map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    static int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void showIssuedLottos(List<Lotto> issuedLottos) {
        for(Lotto lotto : issuedLottos) {
            System.out.println(lotto);
        }
    }
}
