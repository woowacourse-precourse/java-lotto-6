package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class LottoGame{
    private int pay;
    private List<Lotto> lottoes = new ArrayList<>();
    private int bonusNumber;
    private boolean isbonus = false;
    private List<Integer> winNumbers = new ArrayList<>();
    private int counts[] = new int[7];
    private float totalwon = 0;
    LottoGame(String p){
        this.pay = Integer.parseInt(p);
        int size = pay / 1000;
        for (int i = 0; i<size; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
    }
    void printResult(){
        System.out.println("3개 일치 (5,000원) - " + counts[3] + "개");
        System.out.println("4개 일치 (50,000원) - " + counts[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + counts[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts[0] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + counts[6] + "개");

        totalwon = counts[3] * 5000 + counts[4] * 50000 + counts[5] * 1500000 + counts[0] * 30000000 + counts[6] * 2000000000;
        System.out.println("총 수익률은 " + String.format("%.1f",totalwon/pay*100) +"%입니다.");
    }
    int winner(int index){
        int count =0;
        isbonus = false;
        for (int i = 0; i < 6; i++) {
            for (int w : winNumbers){
                if (lottoes.get(index).getNumber(i) == w) count++;
            }
            if(lottoes.get(index).getNumber(i) == bonusNumber) {
                count++;
                isbonus = true;
            }
        }
        return count;
    }
    void setCounts(){
        for (int i = 0; i<pay/1000;i++){
            int c = winner(i);
            if(c != 0)
                counts[c]++;
            if(c == 6 && isbonus)
                counts[0]++;
        }
    }
    void setWinNumbers(String input){
        String[] str = input.split(",");
        for (int i = 0; i<6 ;i++){
            winNumbers.add(Integer.parseInt(str[i]));
        }
    }
    void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    void printLottoes(){
        System.out.println(pay / 1000 + "개를 구매했습니다.");
        for (Lotto l : lottoes){
            System.out.print("[");
            for (int i =0;i<6;i++){
                System.out.print(l.getNumber(i));
                if(i != 5)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

}


public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요");
        //int pay = Integer.parseInt(readLine());
        //System.out.println(pay);
        String input = "";

        while(true) {
            try {
                input = readLine();
                for (int i = 0; i<input.length();i++){
                    if(input.charAt(i)< '0' || input.charAt(i) > '9'){
                        throw new IllegalArgumentException();
                    }
                }
                int pay = Integer.parseInt(input);
                if (pay % 1000 != 0) {
                    //System.out.println("[ERROR] 입력 금액은 1000원 단위이어야 합니다");
                    throw new IllegalStateException();
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 입력 금액은 숫자이어야 합니다.");
            }catch (IllegalStateException e) {
                System.out.println("[ERROR] 입력 금액은 1000원 단위이어야 합니다.");
            }
        }

        LottoGame lottoGame = new LottoGame(input);
        lottoGame.printLottoes();

        System.out.println("당첨 번호를 입력해 주세요.");
        lottoGame.setWinNumbers(readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        lottoGame.setBonusNumber(Integer.parseInt(readLine()));

        System.out.println("당첨 통계\n---");
        lottoGame.setCounts();
        lottoGame.printResult();

    }

}
