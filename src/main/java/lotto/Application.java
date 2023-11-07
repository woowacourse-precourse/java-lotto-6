package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//         TODO: 프로그램 구현
        // 판매자 객체 생성 | "구입금액을 입력해 주세요" 출력
        Seller seller = new Seller();

        // 구매자 객체 생성 | 금액 입력 받음
        Customer customer = new Customer();

        // 구매한 로또 개수 출력
        seller.checkByPurchaseCount(customer);

        // 로또기계 객체 생성
        LottoMachine lottoMachine = new LottoMachine();

        /**
         *  count값 만큼 로또 번호 생성
         *  선언한 배열리스트에 6개의 로또 리스트들을 저장
         */

        List<Integer>[] LottoNumberBox = new ArrayList[seller.count];

        for(int i = 0; i < seller.count; i++){
            LottoNumberBox[i] = new ArrayList<>();
            List<Integer> lottoNumbers = lottoMachine.getRandomLottoNumbers();
            LottoNumberBox[i].addAll(lottoNumbers);
            System.out.println(lottoNumbers);
        }

        // Lotto객체 생성
        Lotto lotto = new Lotto();

        // 보너스 번호 입력받아 로또 당첨 번호 리스트에 저장
        lotto.bonusNumber();

        // 당첨 번호 + 보너스 번호가 담긴 리스트
        List<Integer> Numbers = lotto.getNumbers();




        }






}
