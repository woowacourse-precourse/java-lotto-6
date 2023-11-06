package lotto;

import lotto.model.Draw;
import lotto.model.Awards;

import java.util.List;

public class Perform {
    private final String PRINT_RESULT = "당첨 통계";
    private final String UPPER_SCORE = "---";
    private final String PERFOEM_IS = "총 수익률은 ";
    private final String N_PERCENT = "%입니다.";
    Awards[] values = Awards.values();

    public void checknumbers(List<Draw> tickets, List<Integer> lotto, int bonus) {
        for (Draw t : tickets) {
            total(t.match(lotto, bonus));
        }
    }
    public void total(int result) {
        for (Awards value : values) {
            if (result == value.getMatching()) {value.addCount();}
        }
    }
    public void result(int cnt) {
        int sum = 0;
        System.out.println(PRINT_RESULT);
        System.out.println(UPPER_SCORE);
        for (Awards value : values) {
            System.out.println(value.getMark()+value.getCount()+"개");
            sum += value.getAward()*value.getCount();
        }
        System.out.println(PERFOEM_IS+calculateResult(sum, cnt*1000)+N_PERCENT);
    }
    public String calculateResult(int winningSum,int ticketCnt) {
        return String.format("%.1f", (float) winningSum/ticketCnt*100);
    }
}
