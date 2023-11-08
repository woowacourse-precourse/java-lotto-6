### Domain

- LottoFactory
    - 입력받은 값을 , 으로 파싱하여 List<Integer> 로 반환하는 팩토리 클래스
- Lotto
    - LottoFactory 객체의 값이 중복이 있거나 1 ~ 45 사이의 수 인지 valid 하여 객체 생성
- LottoBonusNumber
    - 추가로 입력받은 로또 번호 클래스
- Price
    - 입력받은 가격이 숫자인지, 1000으로 나누어 떨어지는지 valid 하여 객체 생성
- Quantity
    - Price 를 인자로 받아 1000으로 나누어서 객체 생성
- ComputeLottoGenerator
    - 구매한 수량에 맞춰서 랜덤 로또 번호를 생성해주는 클래스
- PrizeStatisticsCalculator
    - ComputeLottoGenerator 와 Lotto, LottoBonusNumber 를 비교하여 당첨 통계를 내는 클래스
- ReturnOnInvestmentCalculator
    - 수익률 계산하는 클래스

### Valid

- 가격 입력 시 숫자가 아닐경우
- 가격 입력 시 1000 으로 나누어지지 않을경우
- 숫자 입력 시 1 ~ 45 사이의 수가 아닐경우
- 입력받은 로또번호의 갯수가 6개가 아닐경우
- 추가로 입력받은 번호가 숫자가 아닐경우
- 입력받은 로또번호 + 추가로 입력받은 로또번호 중에 중복이 있는경우