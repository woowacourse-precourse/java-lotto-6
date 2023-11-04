package view;

import java.util.List;

import enums.Output;
import model.BuyLottoNumber;

public class OutputView {

	public static void showBuyLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println(buyLottoNumberList.size() + Output.YOUR_LOTTO.getOutput());
		for(int i = 0; i < buyLottoNumberList.size(); i++) {
			System.out.println(buyLottoNumberList.get(i).getNumbers());
		}
	}

}
