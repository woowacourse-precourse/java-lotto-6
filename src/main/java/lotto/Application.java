package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int total = 0;
        int count = inputMoney();
        List<Lotto> lottos = new ArrayList<>();

        for(int i=0;i<count;i++){
            lottos.add(new Lotto(makeRandom()));
            System.out.println(lottos.get(i).getNumbers());
        }
        List<Integer> answer = inputLotto();
        List<Integer> score = calScore(lottos, answer, answer.get(answer.size()-1));
        total = printScore(score);

        double res_score = (total/(count*1000)) * 100;
        System.out.println("총 수익률은 "+res_score+"%입니다.");
    }

    //구매 금액 입력
    public static int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        System.out.println();
        System.out.println(money/1000+"개를 구매했습니다.");
        return money/1000;
    }

    //랜던값 만들기
    public static List<Integer>  makeRandom(){
        List<Integer> resRand = Randoms.pickUniqueNumbersInRange(1,45,6);
        return resRand;
    }

    //당첨번호 입력
    public static List<Integer> inputLotto(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> res = new ArrayList<>();
        String[] test= Console.readLine().split(",");
        for(int i=0;i<test.length;i++){
            res.add(Integer.parseInt(test[i]));
        }
        if(validate_dup(res)){
            throw new IllegalArgumentException();
        }


        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        res.add(Integer.parseInt(Console.readLine()));
        return res;
    }

    //중복값 존재
    public static boolean validate_dup(List<Integer> numbers){
        boolean res = false;
        int before = numbers.get(0);
        for(int i=1;i<numbers.size();i++){
            if(before == numbers.get(i)){
                res = true;
                break;
            }
            before = numbers.get(i);
        }
        return res;
    }

    //당첨 통계
    public static List<Integer> calScore(List<Lotto> Lottos, List<Integer> answer, int bonus){
        List<Integer> resultScore = new ArrayList<>();
        resultScore.add(0);resultScore.add(0);resultScore.add(0);resultScore.add(0);resultScore.add(0);
        Collections.sort(answer);

        int gCount =0;
        for(int i=0;i<Lottos.size();i++){
            gCount = checkCount(Lottos.get(i), answer);
            if(gCount == 3){resultScore.set(0, resultScore.get(0)+1); }
            else if(gCount == 4){resultScore.set(1, resultScore.get(1)+1); }
            else if(gCount == 6){resultScore.set(4, resultScore.get(4)+1); }
            else if(gCount == 5){
                if(checkBonus(Lottos.get(i), bonus)){
                    resultScore.set(2, resultScore.get(2)+1);
                }else{
                    resultScore.set(3, resultScore.get(3)+1);
                }
            }
        }
        return resultScore;
    }


    // 몇개 일치
    public static int checkCount(Lotto ALotto, List<Integer> answer){
        int res =0;
        Collections.sort(ALotto.getNumbers());
        for(int i=0;i<ALotto.getNumbers().size();i++){
            for(int j=0;j<answer.size()-1;j++){
                if(ALotto.getNumbers().get(i) == answer.get(j)){
                    res++;
                }
            }
        }
        return res;
    }

    //보너스볼 일치 + 5개일치
    public static boolean checkBonus(Lotto ALotto,int bonus){
        boolean res = false;
        for(int i=0;i<ALotto.getNumbers().size();i++){
            if(bonus == ALotto.getNumbers().get(i)){
                res = true;
                break;
            }
        }
        return res;
    }

    //결과 출력
    public static int printScore(List<Integer> scores){
        int res =0 ;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+scores.get(0)+"개"); res += scores.get(0)*5000;
        System.out.println("4개 일치 (50,000원) - "+scores.get(1)+"개");res += scores.get(1)*50000;
        System.out.println("5개 일치 (1,500,000원) - "+scores.get(2)+"개");res += scores.get(2)*1500000;
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+scores.get(3)+"개");res += scores.get(3)*30000000;
        System.out.println("6개 일치 (2,000,000,000원) - "+scores.get(4)+"개");res += scores.get(4)*2000000000;

        return res;
    }

    //수익률
    public static double percent(int total, int money){
        double res=0;
        res = (total/money)*100;
        res *=100;
        return res;
    }
}
