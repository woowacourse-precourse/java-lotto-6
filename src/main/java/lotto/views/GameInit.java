package lotto.views;

import java.util.ArrayList;
import java.util.Scanner;

public class GameInit {
    public int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);

        int coin = scan.nextInt();
        return coin;
    }

    public void showLotto(int lottoNum, String [] list){
        System.out.println(lottoNum+"개를 구입했습니다.");
        StringBuilder sb = new StringBuilder();
        for (String paper:list){
            sb.append(paper+"\n");
        }
        System.out.println(sb);
    }
}
