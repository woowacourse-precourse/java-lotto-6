package features;

import model.Data;

public class RunGame {
	
	/*public RunGame() {
		guidance();
		new Statistics(lottery_list, bonus, lotto);
	}
	
	private void guidance() {
		purchaseGuide();
		issueGuide();
		numbersGuide();
	}
	
	private void purchaseGuide() {
		lotto_count=money_in.purchase_lotto()/UNIT_PRICE;
	}*/
	
	public Data issueGuide(Data data) {		
		for(int i=0;i<data.getLottoCount();i++) {
			data.addLottoList();
		}
		return data;
	}
	
	/*private void issueTickets() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, CORRECT_CNT);
		//Collections.sort(numbers);
		
		lottery_list.add(numbers);
	}*/
	
	/*public void numbersGuide() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String num_input=Console.readLine();
		lotto=numbers_in.select_numbers(num_input);
		
		System.out.println("\n보너스 번호를 입력해 주세요.");
		String bonus_input=Console.readLine();
		bonus=numbers_in.select_bonus(bonus_input);
	}*/
}
