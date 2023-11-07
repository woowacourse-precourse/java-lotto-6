package ui;

import dto.LottoMoneyDTO;
import java.text.MessageFormat;
import java.util.List;

class OutputView {
    private OutputView() {
    }

    public static void printForInputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void printAmount(LottoMoneyDTO lottoMoney) {
        String formatted = MessageFormat.format("{0}개를 구매했습니다.", lottoMoney.getAmount());
        System.out.println(formatted);
    }

    public static void printLottoNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printForInputCommonNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printForInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
