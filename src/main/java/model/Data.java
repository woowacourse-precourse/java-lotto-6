package model;

import static model.FixedValues.CORRECT_CNT;
import static model.FixedValues.MAX_NUM;
import static model.FixedValues.MIN_NUM;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import features.InputMoney;
import features.InputNumbers;
import lotto.Lotto;

import static model.FixedValues.*;

public class Data {

	private Lotto lotto;
	
	private List<List<Integer>> lotto_list=new ArrayList<List<Integer>>();
	private int bonus;
	private int lotto_count;
	
	public Lotto getLotto() {
		return lotto;
	}
	public void setLotto() {
		this.lotto=CREATOR.numbersCreator().select_numbers();
	}
	public List<List<Integer>> getLottoList(){
		return lotto_list;
	}
	public void addLottoList() {
		List<Integer> random=Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, CORRECT_CNT);
		this.lotto_list.add(random);
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus() {
		this.bonus=CREATOR.numbersCreator().select_bonus();
	}
	public int getLottoCount() {
		return lotto_count;
	}
	public void purchaseLotto() {
		this.lotto_count=CREATOR.moneyCreator().purchase_lotto()/UNIT_PRICE;
	}
}
