package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.object.LottoNumber;

public class LottoUtil {
	private static final int lottoPrice = 1000;
	
	public static void moneyCheck(String money) throws IllegalArgumentException  {
		try {
			Application.purchaseAmount = Integer.parseInt(money);
			if (Application.purchaseAmount % lottoPrice != 0) {
				throw new IllegalArgumentException();
			}
			Application.ticketNumber = Application.purchaseAmount / lottoPrice;
			System.out.println(Application.ticketNumber + "개를 구매했습니다.");
			makeLotto();
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 금액을 1000 단위의 숫자만 입력하세요.");
			LottoStart.buyLotto();
		}
	}
	
	public static void makeLotto() {
		List<LottoNumber> lottoList = new ArrayList<LottoNumber>();
		
		for (int i = 0; i < Application.ticketNumber; i++) {
			// 로또 티켓 각 장마다 인스턴스 생성
			int lottoIndex = 0;
			LottoNumber lottoInstance = new LottoNumber(lottoIndex, LottoUtil.numberMaker());
			lottoIndex++;
			lottoList.add(lottoInstance);				
		}
		Application.lottoList = lottoList;
		LottoUtil.printTicket(Application.lottoList);
	}
	
	public static List<Integer> numberMaker() {
		List<Integer> computerNumber = new ArrayList<Integer>();
		computerNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Collections.sort(computerNumber); // 오름차순으로 정렬
		
		Application.computerNumber = computerNumber; 
		return computerNumber;
	}
	
	public static void printTicket(List<LottoNumber> lottoList) {
		List<LottoNumber> lottoTicket = lottoList;
		for (LottoNumber tmpObj : lottoTicket) {
			System.out.println(tmpObj.getComputerNumber());
		}
	}
	
	public static void numberCheck(String inputNumber) {
		String[] splitInputNumber = inputNumber.split(",");
		try { 
			if (splitInputNumber.length != 6) {
				throw new IllegalArgumentException();
		}
			LottoUtil.saveNumber(splitInputNumber);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 6개의 숫자를 입력해 주세요.");
			LottoStart.inputNumber();
		}
	}
		
	public static void saveNumber(String[] splitInputNumber) {
		try {
			for (int i = 0; i < splitInputNumber.length; i++) {
				int eachNumber = Integer.parseInt(splitInputNumber[i]);
				if (eachNumber < 1 || eachNumber > 45) {
					throw new IllegalArgumentException();
				}
				Application.playerNumber.add(eachNumber);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
			LottoStart.inputNumber();
		}			
	}
	
	public static void bonusNumberCheck(int bonusNumber) {
		try {
			if (bonusNumber < 1 || bonusNumber > 45) {
					throw new IllegalArgumentException();
				}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 1부터 45 사이의 숫자 하나만 입력해 주세요.");
			LottoStart.inputBonusNumber();
		}
	}
}
