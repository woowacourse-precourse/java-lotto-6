package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int lottoPur = Integer.parseInt(readLine());
        int lottoNum = lottoPur / 1000;
        // 예외처리

        List<List<Integer>> lotto = new ArrayList<>();
        getLotto(lotto, lottoNum);
        printLotto(lotto,lottoNum);

        System.out.println("당첨 번호를 입려해 주세요.");
        String[] input = readLine().split(",");
        List<Integer> userLotto = new ArrayList<>();
        for(String list : input){
            userLotto.add(Integer.valueOf(list));
        }
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        //예외
        userLotto.add(Integer.valueOf(readLine()));

        System.out.println(userLotto);
        System.out.println(lotto);
        System.out.println(lotto.get(0));
        System.out.println(lotto.get(0).get(1));
        winLotto(lotto, userLotto, lottoNum);
    }
    public static List<List<Integer>> getLotto(List<List<Integer>> lotto, int lottoNum){
        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(numbers);
        }
        return lotto;
    }
    public static void printLotto(List<List<Integer>> lotto, int lottoNum){
        System.out.println();
        System.out.println(lottoNum+"개를 구매했습니다.");
        for(int i=0; i<lottoNum; i++){
            Collections.sort(lotto.get(i));
            System.out.println(lotto.get(i));
        }
    }
    public static void winLotto(List<List<Integer>> lotto,List<Integer> userLotto,int lottoNum){
        List<Integer> reward = new ArrayList<>();
        System.out.println("당첨 통계");
        System.out.println("---");
        int total;
        for(int i=0; i<lottoNum; i++){
            winPrice(lotto.get(i)); // indent depth 1
            int idx=0;
            for(int j=0; j<6; j++) {
                if (lotto.get(i).contains(userLotto.get(j))) { // indent depth 2
                    idx += 1;  // indent depth 3
                }
            }
            System.out.println(idx);
            reward.add(idx);
            }
        System.out.println(reward);
    }
    public static void winPrice(List<Integer> lotto){

    }
}
