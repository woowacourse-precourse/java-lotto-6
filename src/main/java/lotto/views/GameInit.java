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

        for(int i=0; i< list.size(); i ++){
            sb.append(list.get(i));
            if(i != 5){
                sb.append(", ");
            }
        }

        sb.append("]\n");
        System.out.println(sb);
    }
}
