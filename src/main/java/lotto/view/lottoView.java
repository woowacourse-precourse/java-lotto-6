package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.List;
import java.util.Map;

public class LottoView {

    public static Integer getNumberOfLottoForPrice() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String priceInput = Console.readLine();
                return LottoService.inputNumberOfLotto(priceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printResult(Map<Integer, Integer> rank) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rank.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rank.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (200,000,000원) - " + rank.getOrDefault(1, 0) + "개");
    }
}
