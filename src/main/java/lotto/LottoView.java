package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoView {

    public int price;
    public int number;
    public String winNumber;
    public int bonusNumber;
    LottoService lottoService = new LottoService();

    public void inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String numberRead = Console.readLine();
        while(true){
            try{
                price = Integer.parseInt(numberRead);
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
                System.out.println("구입금액을 다시 입력해 주세요.");
                numberRead = Console.readLine();
            }
        }
    }

    public void inputValidate(){
        double tempNumber = 0;
        while(true){
            try{
                if (price % 1000 == 0){
                    tempNumber = price/1000;
                    break;
                }
                IllegalArgumentException e = new IllegalArgumentException("[ERROR] 가격은 1000단위여야 합니다.");
                throw e;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("구입금액을 다시 입력해 주세요.");
                price = Integer.parseInt(Console.readLine());
            }
        }
        number = (int) tempNumber;
    }

    public void printNumber(){
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printLottoList(List<Integer> randomNumbers){
        System.out.println(randomNumbers);
    }

    public void inputWinNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        winNumber = Console.readLine();
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        while(true){
            try {
                bonusNumber = Integer.parseInt(Console.readLine());
                break;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 보너스 번호가 잘못된 값을 가집니다.");
                System.out.println("보너스 번호를 다시 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine());
            }
        }
    }

    public void printWin(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(Ranking.FIFTH.getRankingName() + Ranking.FIFTH.getRankingNumber() + "개");
        System.out.println(Ranking.FOURTH.getRankingName() + Ranking.FOURTH.getRankingNumber() + "개");
        System.out.println(Ranking.THIRD.getRankingName() + Ranking.THIRD.getRankingNumber() + "개");
        System.out.println(Ranking.SECOND.getRankingName() + Ranking.SECOND.getRankingNumber() + "개");
        System.out.println(Ranking.FIRST.getRankingName() + Ranking.FIRST.getRankingNumber() + "개");
    }

    public void printProfit() {
        double percentage = lottoService.calculateProfit(price);
        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", percentage));
        System.out.print("%입니다.");
    }

}
