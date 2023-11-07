package lotto.service;

import lotto.domain.UserLottos;
import lotto.exception.InputPriceException;
import lotto.view.IssueLottoView;

public class GenerateLottosService {
    InputPriceException inputPriceException = new InputPriceException();
    IssueLottoView issueLottoView = new IssueLottoView();

    public UserLottos setLottos(String price) {
        UserLottos lottos = new UserLottos();
        printAmmount(lottos, price);
        generateLottos(lottos);
        return lottos;
    }

    public void generateLottos(UserLottos lottos) {
        for (int i = 0; i < lottos.getAmmount(); i++) {
            lottos.setLottos();
            issueLottoView.printLottos(lottos.getLottos().get(i).getLotto());
        }
    }

    public void setBuyingPrice(UserLottos lottos, String price) {
        inputPriceException.validateAll(price);
        lottos.setBuyingPrice(Integer.parseInt(price));
    }

    public void setAmmount(UserLottos lottos, String price) {
        setBuyingPrice(lottos, price);
        lottos.setAmmount(price);
    }

    public void printAmmount(UserLottos lottos, String price) {
        setAmmount(lottos, price);
        issueLottoView.printAmmount(lottos.getAmmount());
    }
}
