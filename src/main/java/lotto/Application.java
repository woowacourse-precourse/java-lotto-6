package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int purchase = 0; // 구입 금액
        try{
            // 1-1. 로또 금액 입력 받음
            System.out.println("구입금액을 입력해 주세요.");
            purchase = Integer.parseInt(Console.readLine());
            if(purchase % 1000 != 0){
                throw new IllegalArgumentException("구매 금액은 1000원 단위여야 합니다.");
            }
        } catch (IllegalArgumentException e){
            // 1-2. 금액이 1000원 단위가 아니면 예외 발생
            System.out.println("[ERROR] "+e.getMessage());
        }

        // 2-1. 구입한 금액만큼 로또 번호 생성
        int count = purchase / 1000; // 생성할 로또 수량
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<count; i++){
            Lotto lotto = new Lotto(createRandomLottoNum());
            lottoList.add(lotto);
        }

        // 2-2. 발행한 로또 수량 출력
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        // 2-3. 발행한 로또 번호를 출력 (오름차순으로)
        for(int i=0; i<lottoList.size(); i++){
            printLottoInfo(lottoList.get(i));
        }

    }

    // 로또 번호 생성
    public static List<Integer> createRandomLottoNum(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    // 발행한 로또 수향 및 번호를 출력
    public static void printLottoInfo(Lotto lotto){
        Collections.sort(lotto.lottoNumbers());
        System.out.println(lotto.lottoNumbers());
    }
}
