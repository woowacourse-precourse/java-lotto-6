package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoController {
    List<Lotto> lottoList = new ArrayList<>();
    Lotto lotto;
    List<Integer> lottoNumbers = new ArrayList<>();
    List<Integer> winNumbers = new ArrayList<>();
    int amount;
    int bonusNum;
    int num;
    int sameNum=0, lucky=0;
    Map<Rank,Integer> map = new HashMap<>();

    public void run(){
       try {
           play();
       }catch(IllegalArgumentException e){
           e.printStackTrace();
       }
    }

    public void play(){
        System.out.println("구입금액을 입력해 주세요.");
        amount = inputMoney();
        System.out.println(amount+"개를 구매했습니다.");
        setLottoList();
        for (int i = 0; i < amount; i++) {
            System.out.println(lottoList.get(i).getLottoNumbers());
        }
        System.out.println("당첨 번호를 입력해 주세요.");
        System.out.println(inputWinNumbers());
        System.out.println("보너스 번호를 입력해 주세요.");
        System.out.println(bonusNum());
        System.out.println("당첨 통계");
        System.out.println("---");
        setResult();
        isWin();

    }

    public Lotto setLottoNumbers(){
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> list = new ArrayList<>(lottoNumbers);
        lotto.duplicateNumbers(list);
        Collections.sort(list);
        return new Lotto(list);
    }

    public List<Lotto> setLottoList(){
        for(int i=0;i<amount;i++) {
            lottoList.add(setLottoNumbers());
        }
        return lottoList;
    }

    public int inputMoney(){
        try{
            String inputMoney = Console.readLine();
            num = Integer.parseInt(inputMoney);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]");
            e.printStackTrace();
        }
        return num/1000;
    }

    public List<Integer> inputWinNumbers(){
        String winNums = Console.readLine();

        for(String num : winNums.split(",")){
            winNumbers.add(Integer.parseInt(num));
        }

        if(winNums.length()!=6){
            throw new IllegalArgumentException("[ERROR]");
        }
        return winNumbers;
    }

    public int bonusNum(){
         bonusNum = Integer.parseInt(Console.readLine());
        return bonusNum;
    }
    public void isWin() {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = lottoList.get(i);
            int sameNum = countMatchingNumbers(lotto);
            boolean bonusMatch = lotto.getLottoNumbers().contains(bonusNum);

            Rank rank = Rank.valueOf(sameNum, bonusMatch);
            if (rank != null) {
                int currentValue = map.getOrDefault(rank, 0);
                map.put(rank, currentValue + 1);
            }
        }
        outputResult();
    }
    private int countMatchingNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        Set<Integer> processedNumbers = new HashSet<>();
        int sameNum = 0;

        for (int j = 0; j < numbers.size(); j++) {
            int number = numbers.get(j);
            if (winNumbers.contains(number) && !processedNumbers.contains(number)) {
                sameNum++;
                processedNumbers.add(number);
            }
        }

        return sameNum;
    }


    public void setResult(){
        for(Rank rank : Rank.values()){
            map.put(rank,0);
        }
    }
    public void outputResult(){
        Rank[] ranks = Rank.values();
        Collections.reverse(Arrays.asList(ranks));
        for(Rank rank : ranks){
            System.out.println(rank.getMessage() + map.get(rank) + "개");
        }
        System.out.println("총 수익률은 "+rate()+"%입니다.");
    }

    public String rate(){
        double sum=0, money=num;

        for(Rank rank : Rank.values()){
            sum+=rank.getPrize()*map.get(rank);
        }
        double rate = sum/money*100;
        return String.format("%.1f", rate);
    }
}
