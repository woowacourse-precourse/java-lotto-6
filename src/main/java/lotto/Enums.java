package lotto;

enum Messages {
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
    CHECK_EARN_RATIO("총 수익률은 %f%입니다."),
    OUTPUT_ERROR("[ERROR] "),
    OUTPUT_ERROR_THOUSAND("1000원으로 나누어 떨어지게 자료를 입력하셔야 합니다."),
    // 구입 금액 입력부분 확인
    OUTPUT_ERROR_OUTOFRANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUTPUT_ERROR_OUTOFTYPE("숫자만 입력해주세요");
    // 보너스 번호, 당첨번호 공통 확인 OUTPUT_ERROR




    // print 출력값 포장할 것
    final private String PrintInterface;

    String getMessages() {
        return PrintInterface;
    }

    private Messages(String printInterface) {
        this.PrintInterface = printInterface;
    }
}

enum MagicNumbers {
    CHECK_NUMBER_ONE(1),
    CHECK_NUMBER_FOURTYFIVE(45);

    // print 출력값 포장할 것
    final private int PrintInterface;

    public int getMagicNumbers() {
        return PrintInterface;
    }

    MagicNumbers(int printInterface) {
        this.PrintInterface = printInterface;
    }
}
