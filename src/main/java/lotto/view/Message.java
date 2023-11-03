package lotto.view;

public class Message {
    public static void  messageAboutPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void messageAboutLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void messageAboutUserLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void messageAboutUserBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void messageAboutWinningStatistic() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
