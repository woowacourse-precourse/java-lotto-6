# 프로그램 소개
  - 기본적으로 1부터 45까지 서로 다른 6개의 수로 이루어진 당첨번호 및 보너스 번호와, 사용자가 발행한 로또를 비교하여
    상금을 반환해주는 게임이다.

  - 같은 수가 6개 일치한다면 1등, 5개 일치 + 보너스 번호 일치 시 2등, 5개 번호 일치 시 3등, 4개 번호 일치 시 4등,
3개 번호 일치 시 5등의 결과를 가진다.

  - e.g., 당첨번호를 1,2,3,4,5,6이고 보너스 번호를 7이라 하자: 이때 사용자가 랜덤으로 발행한 로또가 1,2,3,4,5,10이고
보너스 번호가 7이라면, 사용자는 5등에 당첨된다.

  - 로또 한 장의 금액 단위(1000원)로 사용자가 발행할 로또의 구입 금액을 입력하면, 구입 개수만큼 로또가 랜덤으로 발행되고
당첨 내역을 확인한다. 당첨 내역에 해당하는 총 상금을 파악하여 수익률을 반환한다.

# 프로그램 기능
  1. 입력
      - 로또 구입 금액 입력 받기 - UI.priceInput()
      - 당첨번호 입력 받기 - UI.numberInput()
      - 보너스번호 입력받기 - UI.bonusInput()
  
  2. 출력
      - 발행한 로또 수량 출력 - UI.purchaseComment()
      - 발행한 로또 번호 출력 - UI.lottoOutput(List<Lotto> memberLotto)
      - 당첨내역 출력 - UI.staticOutput(List<Integer> result)
      - 수익률 출력 - UI.profitOutput()
  
  3. 핵심 로직
      - 발행한 로또 수량 계산 - Member.setCount(int price)
      - 입력받은 구매 개수만큼 로또 발행 - Member.createMemberLotto(int count)
      - 당첨번호와 발행한 로또와의 비교  - WinningNumber.correctBonus(Lotto lotto, List<Integer> winNumbers, int bonusNumber)
      - 당첨번호와 발행 로또와의 비교 결과를 당첨 내역에 추가- WinningNumber.calculate(List<Lotto> memberLotto,Member member)
      - 당첨 결과(1~5등, 무당첨)와 그에 해당하는 상금 저장 - <enumType> Prize
      - 당첨내역 총계 계산 - Member.prizeResult()
      - 수익률 계산 - Member.getProfit()
  
  4. 예외 처리
      - 번호 입력 시,
        - 번호 입력 시, 같은 값을 입력한 경우 - Lotto.numberValid(List<Integer> numbers)
        - 0 이하 값을 입력한 경우 - Lotto.numberValid(List<Integer> numbers)
        - 46 이상 값을 입력한 경우 - Lotto.numberValid(List<Integer> numbers)
        - 6개의 번호를 입력하지 않은 경우 - Lotto.validate(List<Integer> numbers)
        - 숫자가 아닌 값을 입력한 경우 - WinningNumber.digitValid(String[] checkNumber)
        
      - 보너스 번호 입력 시,
        - 번호 입력 시, 당첨번호와 같은 값을 입력한 경우 - WinningNumber.bonusValid(int bonusNumber)
        - 0 이하 값을 입력한 경우 - WinningNumber.bonusValid(int bonusNumber)
        - 46 이상 값을 입력한 경우 - WinningNumber.bonusValid(int bonusNumber)
        - 숫자가 아닌 값을 입력한 경우 - WinningNumber.setBonusValid(String bonus)
        
      - 로또 구입 금액 입력 시,
        - 구입 금액이 1000원으로 나누어 떨어지지 않은 경우 - Member.priceValid(int price)
        - 구입 금액이 0원 이하의 경우 - Member.priceValid(int price)
        - 숫자가 아닌 값을 입력한 경우 - Member.setPriceValid(String prices)
    
