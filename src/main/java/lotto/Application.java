package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Get.GetPurchaseNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static List<Integer> strArrTointList(String [] tempStr){
        int[] tempInt = Stream.of(tempStr).mapToInt(Integer::parseInt).toArray();
        List<Integer> templist = Arrays.stream(tempInt).boxed().collect(Collectors.toList());

        return templist;
    }

    public static void main(String[] args) {
        /*
        // 로또 당첨 금액 ENUM
        enum LottoAmount {
            FIFTH(5000), FOURTH(50000), THIRD(1500000), SECOND(30000000), FIRST(2000000000);

            private final int value;
            LottoAmount(int value) { this.value = value; }
            public int getValue() { return value; }
        }
         */


        // 출력 메시지 열거형
        enum Message {
            GetPurchasePrice("구입금액을 입력해 주세요."), GetWinningNumber("당첨 번호를 입력해 주세요."), GetBonusNumber("보너스 번호를 입력해 주세요.");
            private final String value;

            Message(String value) {
                this.value = value;
            }

            public String getValue() {
                return value;
            }
        }

        // 입력 1. 로또 구입 금액 1000원 단위로 입력 받기

        System.out.println(Message.GetPurchasePrice.getValue());
        int purchasePrice = GetPurchaseNumber();

        /* *********입력기능1 입력받고 예외처리 할떄 pp값 받은걸 while밖에서 사용 못함, 반복 언제까지 해야할지 판단 문제
        while (true) {

            // -1000원으로 안 나누어지면 예외처리(+ 메시지 출력, 다시 입력받기)
            try {
                if (purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

                System.out.println(Message.GetPurchasePrice.getValue());
                purchasePrice = GetPurchaseNumber();
            }
        }
        */


        // 게임 1. 구입금액에 따른 로또 구매 개수 구하기
        int lottoCount = purchasePrice / 1000;

        // 게임 2. 1~45까지의 중복 되지 않는 랜덤 숫자 6개를 구매 개수에 맞게 뽑기
        // 모든 로또 티켓 저장된 리스트
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        /* 게임기능2 확인
        for(Lotto l:lottos){
            List<Integer> intlotto = new ArrayList<Integer>(l.getter());
            for(Integer i:intlotto){
                System.out.println(i);
            }
            System.out.println("---");
        }
        */


        // 입력 2. 쉼표 기준으로 구분해서 당첨 번호 입력 받기
        System.out.println(Message.GetWinningNumber.getValue());
        String[] tempStr = readLine().split(",");
        List<Integer> winningNumber = strArrTointList(tempStr);

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
        System.out.println(Message.GetBonusNumber.getValue());
        int bonusNumber = Integer.parseInt(readLine());


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
            correctCounts.add(correctCount);
            correctCount = 0;
        }

        //보너스 번호와 비교
        List<Boolean> correctBonus = new ArrayList<>();

        for(Lotto l:lottos){
            List<Integer> lottosTemp = new ArrayList<Integer>(l.getter());

            if (lottosTemp.contains(bonusNumber)) {
                correctBonus.add(true);
            }
            else{
                correctBonus.add(false);
            }
        }



    }
}
