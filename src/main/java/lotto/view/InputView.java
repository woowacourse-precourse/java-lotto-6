package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Constant.lottoCost;

public class InputView {
    public static int getLottoNum(int price) {
        int lottoNum = price / lottoCost;
        System.out.println();
        System.out.println(lottoNum + "개를 구매했습니다.");
        return lottoNum;
    }

    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String readLine = Console.readLine();
        if (!readLine.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        int price = Integer.parseInt(readLine);
        return price;
    }

    public static int getBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> getPickedNums() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");

        List<Integer> pickedNums = new ArrayList<>();
        String[] input = Console.readLine().split(",");
        for (String s : input) {
            pickedNums.add(Integer.parseInt(s));
        }

        return pickedNums;
    }
}
