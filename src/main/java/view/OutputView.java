package view;

import java.util.List;

import dto.BuyLottoBonusDto;
import enums.Output;
import model.BuyLottoNumber;

public class OutputView {

	public static void showBuyLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println(buyLottoNumberList.size() + Output.YOUR_LOTTO.getOutput());
		for(int i = 0; i < buyLottoNumberList.size(); i++) {
			System.out.println(buyLottoNumberList.get(i).getNumbers());
		}
	}

	public static void showWinStats(BuyLottoBonusDto buyLottoBonusDto) {
		System.out.println();
		System.out.println(Output.WIN_STATS.getOutput());
		System.out.println(Output.LINE.getOutput());
		System.out.println(Output.THREE_MATCHES.getOutput() + buyLottoBonusDto.getThreeMatch() + Output.SOME.getOutput());
		System.out.println(Output.FOUR_MATCHES.getOutput() + buyLottoBonusDto.getFourMatch() + Output.SOME.getOutput());
		System.out.println(Output.FIVE_MATCHES.getOutput() + buyLottoBonusDto.getFiveMatch() + Output.SOME.getOutput());
		System.out.println(Output.FIVE_bONUS_MATCHES.getOutput() + buyLottoBonusDto.getFiveMatchAndBonus() + Output.SOME.getOutput());
		System.out.println(Output.SIX_MATCHES.getOutput() + buyLottoBonusDto.getSixMatch() + Output.SOME.getOutput());
	}

	public static void showRate(BuyLottoBonusDto buyLottoBonusDto) {
		System.out.print(Output.TOTAL_INCOME_RATE_FIRST.getOutput());
		System.out.print(buyLottoBonusDto.getRateOfProfit());
		System.out.print(Output.TOTAL_INCOME_RATE_SECOND.getOutput());
	}

}
