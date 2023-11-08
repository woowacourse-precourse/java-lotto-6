package lotto;



import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {

        Money.inputMoney();
        Money.printLottoNum();

        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<Money.lottoNum;i++){

            List<Integer> lottoNumbers = Lotto.makeLotto();
            lottoNumbers.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
            lotto.printLotto();

        }
        System.out.println();
        User.inputLottoNumber();
        System.out.println();
        User.inputBonusNumber();
        System.out.println();
        User.compareLottoNum(lottos);
        User.printLottoResult();




    }
}
