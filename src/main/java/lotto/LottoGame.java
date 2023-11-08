package lotto;

import java.util.List;

public class LottoGame {
    Seller seller =new Seller();
    Customer customer = new Customer();
    Lotto lotto = new Lotto();
    LottoMachine lottoMachine = new LottoMachine();

    public void gameStart() {
        seller.printAskPurchaseCount(); // "구입금액을 입력해 주세요."
        customer.inputPrice(); // 구입 금액 입력

        seller.printCheckPurchaseCount(customer.getPrice()); // n개를 구매했습니다
        List<Integer>[] LottoNumberBox = lottoMachine.getBuyLottos(seller.getCount()); // 구매한 로또 리스트 출력

        seller.printAskCorrectNumber(); // "당첨 번호를 입력해 주세요."
        lotto.inputCorrectNumber(); // 당첨 번호 입력

        seller.printAskBonusNumber(); // "보너스 번호를 입력해 주세요."
        lotto.inputBonusNumber(); // 보너스 번호 입력


        List<Integer> correctLottoNumber = lotto.addCorrectWithBonusNumber();           // 7자 로또

        lottoMachine.rateLottosRank(LottoNumberBox, correctLottoNumber);

        lottoMachine.printResult();
        lottoMachine.printEarningsRate(customer.getPrice());
    }


}
