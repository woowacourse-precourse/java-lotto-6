package lotto;

public class OutputReturn {
    public void print(int total_return, int purchase_amount) {
        float return_rate = ((float) total_return / purchase_amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", return_rate);
    }
}
