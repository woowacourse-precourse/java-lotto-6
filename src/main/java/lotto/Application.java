package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchase = 0; // 구입 금액
        while(true){
            try{
                purchase = inputPurchase();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }

        }

        // 2-1. 구입한 금액만큼 로또 번호 생성
        int lottoCount = purchase / 1000; // 생성할 로또 수량
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<lottoCount; i++){
            Lotto lotto = new Lotto(createRandomLottoNum());
            lottoList.add(lotto);
        }

        // 2-2. 발행한 로또 수량 출력
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        // 2-3. 발행한 로또 번호를 출력 (오름차순으로)
        for(Lotto lotto : lottoList){
            Collections.sort(lotto.lottoNumbers());
            System.out.println(lotto.lottoNumbers());
        }

        // 3. 당험 번호 입력받기
        List<Integer> winningNumbers;
        Lotto inputWinningLotto;
        while(true){
            try{
                // 3-1. 당첨 번호를 입력받음
                // 3-2. 입력받은 당첨 번호를 쉼표(,) 기준으로 구분함
                String[] inputNumbers = Console.readLine().split(",");
                winningNumbers = parseInputNumbers(inputNumbers); // 사용자 입력을 List<Integer>로 변환
                inputWinningLotto = new Lotto(winningNumbers);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


        // 4. 보너스 번호 입력받기
        int bonusNumber = 0;
        while(true){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                bonusNumber = inputBonusNumber();
                break;
            }catch (IllegalArgumentException e){
                System.out.println("[ERROR] "+e.getMessage());
            }
        }

        // 5. 당첨 내역 & 수익률 출력하기
        System.out.println("당첨 통계"); System.out.println("---");
        DecimalFormat formatter1 = new DecimalFormat("###,###,###,###");
        float winningPrizeSum = 0;
        int[] matchCountInfo = new int[LottoRank.values().length];
        for(int i=0; i<lottoCount; i++){
            // 5-1. 구매한 로또 번호와 당첨 번호 비교
            int matchCount = compareLottoNumbers(lottoList.get(i).lottoNumbers(), inputWinningLotto);
            // 5-2. 보너스 번호 비교
            boolean matchBonusNumber = compareBonusNumber(lottoList.get(i).lottoNumbers(), bonusNumber);

            // 당첨 내역 저장
            if(matchCount > 0){
                LottoRank rank = LottoRank.calculateRank(matchCount, matchBonusNumber);
                if(rank != null){
                    matchCountInfo[rank.getIndex()]++;
                    winningPrizeSum += rank.getPrize(); // 5-3. 당첨 금액 계산
                }
            }
        }
        // 5-4. 당첨 내역 출력
        for(LottoRank rank : LottoRank.values()){
            int matchCount = rank.getMatchCount();
            int prize = rank.getPrize();
            int count = matchCountInfo[rank.getIndex()];

            if(rank.getIndex() == 3){
                System.out.println(matchCount+"개 일치, 보너스 볼 일치 ("+formatter1.format(prize)+"원) - "+count+"개");
            }
            if(rank.getIndex() != 3){
                System.out.println(matchCount+"개 일치 ("+formatter1.format(prize)+"원) - "+count+"개");
            }
        }
        // 5-5. 수익률 계산 (소수점 둘째 자리에서 반올림)
        float earningRate = winningPrizeSum/purchase*100;
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);


    }

    // 1-1. 로또 금액 입력 받음
    public static int inputPurchase(){
        int purchase = 0;
        System.out.println("구입금액을 입력해 주세요.");
        purchase = Integer.parseInt(Console.readLine());
        if(purchase % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
        }
        return purchase;
    }

    // 로또 번호 생성
    public static List<Integer> createRandomLottoNum(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    // 사용자 입력을 List<Integer>로 변환
    public static List<Integer> parseInputNumbers(String[] inputNumbers){
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<inputNumbers.length; i++){
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
        return numbers;
    }

    // 4-1. 보너스 번호를 입력받음
    public static int inputBonusNumber(){
        int bonusNumber = Integer.parseInt(Console.readLine());
        if(!validateBonusNumber(bonusNumber)){
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    // 4-2. 번호의 범위가 1~45가 아닐 경우 예외 발생
    public static boolean validateBonusNumber(int bonusNumber){
        boolean validate = true;
        if(bonusNumber < 1 || bonusNumber > 45){
            validate = false;
        }
        return validate;
    }

    // 5-1. 구매한 로또 번호와 당첨 번호 비교
    public static int compareLottoNumbers(List<Integer> lottoNumbers, Lotto inputWinningLotto){
        int matchCount = 0;
        for(int number : inputWinningLotto.lottoNumbers()){
            if(lottoNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    // 5-2. 보너스 번호 비교
    public static boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber){
        boolean matchBonusNumber = false;
        if(lottoNumbers.contains(bonusNumber)){
            matchBonusNumber = true;
        }
        return matchBonusNumber;
    }
}
