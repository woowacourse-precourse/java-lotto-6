package lotto;

import java.util.List;

public class LottoCheck {
    private final List<Integer>[] lottoPickNumbers; // 로또 구매 값
    private final List<Integer> lottoNumber; // 로또 뽑기 값
    private final Integer lottoBonus;
    private final Integer[] lottoResult = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0};

    private final LottoConfig[] lottoConfig = LottoConfig.values();

    public LottoCheck(List<Integer>[] lottoPickNumbers, List<Integer> lottoNumber) {
        this.lottoPickNumbers = lottoPickNumbers;
        this.lottoBonus = lottoNumber.remove(lottoNumber.size()-1);
        this.lottoNumber = lottoNumber;
    }

    // 로또 값 비교
    public void lottoCompare() {
        for (List<Integer> lotto : lottoPickNumbers) {
            lottoResult[lottoCount(lotto, lottoNumber)]++;
        }
    }

    // 결과 값 출력
    public void lottoOutput() {
        System.out.println("당첨통계\n---");
        place(lottoResult);
        System.out.println(profit(profit()));
    }

    // 로또 결과 값 전달.
    private int lottoCount(List<Integer> lottoPickNumbers, List<Integer> lottoNumber) {
        int i = 0;
        for (Integer number : lottoNumber) {
            if (lottoCheck(lottoPickNumbers,number)) i++;
        }
        if(i == 5 && (lottoCheck(lottoPickNumbers,lottoBonus))) i++;
        if(i == 6) i++;
        return i;
    }

    // 로또 값 유무 확인.
    private boolean lottoCheck(List<Integer> lottoPickNumbers, Integer lottoNumber) {
        return lottoPickNumbers.contains(lottoNumber);
    }

    //enum을 활용한 출력.
    public void place(Integer[] lottoResult) {
            for(LottoConfig lottoDate : lottoConfig){
                System.out.println(lottoDate.message() + lottoResult[lottoDate.match()] + "개");
            }
    }

    //수익률 리턴
    private String profit(double profit) {
        return "총 수익률은 " + String.format("%.1f", profit) + "%입니다.";
    }

    //수익률
    private double profit(){
        long sum = 0;
        double profit;
        for (int i = 3; i <= 7; i++) {
            sum += (long) lottoResult[i] * lottoConfig[i-3].price();
        }
        long money;
        money = lottoPickNumbers.length * 1000L;
        profit = ((double) sum / money) * 100;
        return profit;
    }
}
