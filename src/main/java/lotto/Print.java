package lotto;

public class Print {
    // 출력 메시지 열거형
    enum Message {
        GetPurchasePrice(0, "구입금액을 입력해 주세요."), PrintPurchaseCount(1, "개를 구매했습니다."), GetWinningNumber(2, "당첨 번호를 입력해 주세요."), GetBonusNumber(3, "보너스 번호를 입력해 주세요."), WinningStatus(4, "당첨 통계"), Bar(5, "---");
        private final int index;
        private final String value;

        Message(int index, String value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }
        public String getValue() {
            return value;
        }
    }


    public static void message(int n){
        for(Message msg:Message.values()){
            if(msg.index == n){
                System.out.println(msg.getValue());
            }
        }
    }

    public static void roundEarningRate(float earningRate){
        System.out.print(String.format("총 수익률은 " + "%.1f", earningRate) + "%입니다.");
    }


}
