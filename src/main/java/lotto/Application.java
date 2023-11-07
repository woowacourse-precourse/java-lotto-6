package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private static final int UnitCost = 1000;

    public static List<Integer> convert(String [] tempStr){
        int[] tempInt = Stream.of(tempStr).mapToInt(Integer::parseInt).toArray();
        List<Integer> templist = Arrays.stream(tempInt).boxed().collect(Collectors.toList());

        return templist;
    }

    public static void main(String[] args) {
        // 로또 당첨 금액 ENUM
        enum LottoResult {
            FIFTH(3, 5000, "3개 일치 (5,000원) - "), FOURTH(4, 50000, "4개 일치 (50,000원) - "), THIRD(5, 1500000, "5개 일치 (1,500,000원) - "), SECOND(55, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - ");

            private final int correctNumber;
            private final int reward;
            private final String value;

            LottoResult(int correctNumber, int reward, String value) {
                this.correctNumber = correctNumber;
                this.reward = reward;
                this.value = value;
            }
            public int getCorrectNumber(){ return correctNumber; }
            public int getReward() { return reward; }
            public String getValue() { return value; }
        }


        // 입력 1. 로또 구입 금액 1000원 단위로 입력 받기
        int purchasePrice = 0;

        while (true) {
            Print.message(0);
            purchasePrice = Get.purchaseNumber();

            try{
                if (purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위만 가능합니다.");
                }
                else{
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        // 게임 1. 구입금액에 따른 로또 구매 개수 구하기
        int lottoCount = purchasePrice / UnitCost;

        // 게임 2. 1~45까지의 중복 되지 않는 랜덤 숫자 6개를 구매 개수에 맞게 뽑기
        // 모든 로또 티켓 저장된 리스트
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }


        // 출력 2. 발행한 로또 수량 및 번호 출력
        Print.message(1);
        for(Lotto l:lottos) {
            List<Integer> lottoElement = new ArrayList<Integer>(l.getter());
            lottoElement.sort(Comparator.naturalOrder());
            System.out.println(lottoElement);
        }
        System.out.println();


        // 입력 2. 쉼표 기준으로 구분해서 당첨 번호 입력 받기
        Print.message(2);
        List<Integer> winningNumber = convert(Get.winningNumber());

        try {
            //중복있거나 6자리 수 아니면 예외처리(, 체크는 나중에 추가)
            Set<Integer> wnSet = new HashSet<>(winningNumber);
            if( (wnSet.size()!= winningNumber.size()) || winningNumber.size() != 6){
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }


        //입력 3. 보너스 번호 입력 받기
        Print.message(3);
        int bonusNumber = Get.bonusNumber();


        //게임 3. 당첨번호, 보너스번호와 구매한 로또번호 비교
        int correctCount = 0; // 일치하는 숫자 개수
        List<Integer> correctCounts = new ArrayList<>();

        // 당첨번호와 비교
        for(Lotto l:lottos){
            List<Integer> lottosTemp = new ArrayList<Integer>(l.getter());
            for(int i = 0; i < 6; i++){
                if (lottosTemp.contains(winningNumber.get(i))){
                    correctCount += 1;
                }
            }

            //보너스 체크
            if(correctCount == 5 && lottosTemp.contains(bonusNumber)){
                correctCounts.add(55);
            }
            else {
                correctCounts.add(correctCount);
            }
            correctCount = 0;
        }

        // 출력 1. 당첨 내역 출력
        int totalReward = 0;

        Print.message(4);
        Print.message(5);

        for(LottoResult lr:LottoResult.values()){
            System.out.println(lr.getValue() + Collections.frequency(correctCounts, lr.getCorrectNumber()) + "개");
            if(Collections.frequency(correctCounts, lr.getCorrectNumber()) != 0){
                totalReward += lr.getReward();
            }
        }

        // 게임 4. 비교 결과에 따른 총 수익률 구하기
        float earningRate = ((float) totalReward / purchasePrice) * 100;
        Print.roundEarningRate(earningRate);




    }
}
