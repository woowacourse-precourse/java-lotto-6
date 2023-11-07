package View;

import Input.LottoInput;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {
    public static int getPrice() {
        int price;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                price = LottoInput.inputPrice();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위의 가격을 입력해주세요");
            }
        }
        return price;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer;
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                answer = LottoInput.makeAnswerNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return answer;
    }

    public static int getBonus() {
        int bonus;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonus = LottoInput.makeBonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return bonus;
    }

    public static void showTotalLotto(Lotto[] lottos){
        System.out.println(lottos.length+"개를 구매했습니다.");
        for(int i=0;i<lottos.length;i++){
            List<Integer> numbers=new ArrayList<>(lottos[i].getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void showLottoResult(int[] result,int price){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+result[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+result[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+result[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+result[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+result[4]+"개");
        float rate= (float) (result[0] * 5000 + result[1] * 50000 + result[2] * 1500000 + result[3] * 30000000 + result[4] * 2000000000)*100/price;
        System.out.printf("총 수익률은 %.1f%%입니다.",rate);
    }
}
