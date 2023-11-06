package lotto;


import lotto.entity.Lotto;
import lotto.generator.LottoQuantity;
import lotto.io.BonusNumberReader;
import lotto.generator.ClientLottoNumber;
import lotto.io.LottoNumberReader;
import lotto.io.MoneyReader;

public class Application {
    public static void main(String[] args) {
        ClientLottoNumber lottoNumberGenerator =new ClientLottoNumber();
        lottoNumberGenerator.NumberGenerator();
        System.out.println("보너스 번호 입력");
        BonusNumberReader bonusNumber = new BonusNumberReader();
        bonusNumber.bonusnumber();
        System.out.println("로또번호입력");
        LottoNumberReader lottoNumberReader=new LottoNumberReader();
        lottoNumberReader.lotto_reader();


        // TODO: 프로그램 구현
    }
}
