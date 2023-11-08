package PrintEnums;

public enum Messages {
    ASK_LOTTO_MONNEY("구입금액을 입력해 주세요."),
    SAY_HOWMANY_BOUGHT("개를 구매했습니다."),
    //구매내역 내역 그냥 SET으로 출력 때리면 될듯? []로 되어있으니까.
    ASK_WINNING_PRIZE_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    CHECK_MATCH_THREE("3개 일치 (5,000원) - "),
    CHECK_MATCH_FOUR("4개 일치 (50,000원) - "),
    CHECK_MATCH_FIVE("5개 일치 (1,500,000원) - "),
    CHECK_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CHECK_MATCH_SIX("6개 일치 (2,000,000,000원) - "),
    CHECK_EARN_RATIO("총 수익률은 ");

    // print 출력값 포장할 것
    final private String PrintInterface;

    public String getMessage() {
        return PrintInterface;
    }

    Messages(String printInterface) {
        this.PrintInterface = printInterface;
    }
}

