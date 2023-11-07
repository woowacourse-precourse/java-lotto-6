package model;

import static model.FixedValues.CORRECT_CNT;
import static model.FixedValues.MAX_NUM;
import static model.FixedValues.MIN_NUM;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import controller.InputMoney;
import controller.InputNumbers;
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
	public void setLotto(String input) {
		this.lotto=new InputNumbers().select_numbers(input);
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
	public void setBonus(String input) {
		this.bonus=new InputNumbers().select_bonus(input);
	}
	public int getLottoCount() {
		return lotto_count;
	}
	public void setLottoCount() {
		this.lotto_count=new InputMoney().purchase_lotto()/UNIT_PRICE;
	}
}
