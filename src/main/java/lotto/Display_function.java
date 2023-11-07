package lotto;

import java.util.List;

public class Display_function {
    public void displayScore(int[] scoreBoard) {
        System.out.printf("\n당첨통계\n---\n");
        showFifth(scoreBoard[3]);
        showFourth(scoreBoard[4]);
        showThird(scoreBoard[5]);
        showSecond(scoreBoard[7]);
        showFirst(scoreBoard[6]);
    }
    public void showFifth(int number){
        System.out.println("3개 일치 (5,000원) - "+ number +"개");
    }
    public void showFourth(int number){
        System.out.println("4개 일치 (50,000원) - "+ number +"개");
    }
    public void showThird(int number){
        System.out.println("5개 일치 (1,500,000원) - "+ number +"개");
    }
    public void showSecond(int number){
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+ number +"개");
    }
    public void showFirst(int number){
        System.out.println("6개 일치 (2,000,000,000원) - "+ number +"개");
    }

    public void displayUserLottonumbers(List<List<Integer>> all_lotto_numbers, int game_count) {
        System.out.println(game_count + "개를 구매했습니다.");
        for(List<Integer> user_lotto_number:all_lotto_numbers) {
            System.out.println(user_lotto_number.toString());
        }
    }

    public void displayEarningRate(int prize, int money) {
        float earningRate = 0;
        if(prize ==0) {
            System.out.println("수익률은 0%입니다.");
        }
        if(prize != 0) {
            earningRate = ((float)prize/money)*100;
            System.out.printf("총 수익률은 %.1f%%입니다.",earningRate);
        }
    }

}
