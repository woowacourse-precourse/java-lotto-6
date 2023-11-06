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
        Lotto lotto =new Lotto(lottoNumberGenerator.NumberGenerator());
        BonusNumberReader bonusNumber = new BonusNumberReader();
        bonusNumber.bonusnumber();
        LottoQuantity.Quantity();
        LottoNumberReader lottoNumberReader=new LottoNumberReader();
        lottoNumberReader.lotto_reader();


        // TODO: 프로그램 구현
    }
}
