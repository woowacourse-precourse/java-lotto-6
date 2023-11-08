package lotto.views;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInit {
    public int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scan = new Scanner(System.in);

        int coin = scan.nextInt();
        return coin;
    }

    public void showLotto(int lottoNum){
        System.out.println(lottoNum+"개를 구입했습니다.");
    }

    public void lottoView(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int paper:list){
            sb.append(paper+", ");
        }
        sb.append("]\n");
        System.out.println(sb);
    }
}
