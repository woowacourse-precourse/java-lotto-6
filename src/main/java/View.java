public class View {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요. ";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요. ";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요. ";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";


    public void display_purchase_amount_message() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void display_lotto_number_message() {
        System.out.println(LOTTO_NUMBER_MESSAGE);
    }

    public void display_bonus_number_message() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void display_winning_statistics_message() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }
}
