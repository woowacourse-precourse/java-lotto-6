# *Model*
## consumer
- [x] record Consumer(Price, List<Integer>, Count)
    - 구입한 로또의 번호를 관리하는 레코드
    - Price 만 활용하여 Consumer 인스턴스 만들도록 생성자 추가
    - List<Integer>, Count 는 null
    - validation 추가
- [x] record Price(Integer)
    - 구입한 로또의 금액을 관리하는 레코드
    - validation 추가
- [x] record Count(int)
    - 구입한 로또의 갯수를 관리하는 레코드
## producer
- [x] record Producer(Lotto, Bonus)
    - Lotto, Bonus 관리하는 레코드
- [x] record Bonus(Lotto, int)
    - 로또 당첨 보너스 번호 관리하는 레코드
    - 로또 당첨 번호와의 중복 검증을 위해 Lotto 필드 추가
    - validation 추가
## common
- [x] record Lotto(List<Integer>)
    - Consumer 와 Producer 인스턴스를 생성할 때 사용하는 레코드
    - Consumer 와 Producer 인스턴스를 생성하기 전에 검증하기 위해 Lotto 생성자에 validation 추가
- [x] enum Rank
    - 로또 당첨순위에 따른 정보들을 열거형으로 관리하는 열거형

- - -

# *View*
## InputView
- [x] inputPrice()
    - 로또 구매 금액 입력받는 메서드
    - validation 추가
- [x] inputLotto
    - 로또 당첨 번호 입력받는 메서드
    - validation 추가
- [x] inputLottoBonus
    - 로또 당첨 보너스 번호 입력받는 메서드
    - validation 추가

## OutputView
- [x] printPriceMessage()
  - 로또 구매 금액 입력을 유도하는 메시지를 출력하는 메서드
- [x] printConsumerLotto()
  - 로또 구매 금액만큼 자동 발행된 로또를 출력하여 보여주는 메서드
- [x] printProducerLottoMessage()
  - 로또 당첨 번호 입력을 유도하는 메시지를 출력하는 메서드
- [x] printProducerBonusMessage()
  - 로또 당첨 보너스 번호 입력을 유도하는 메시지를 출력하는 메서드
- [x] printWinningResultMessage()
  - 로또 당첨 결과 메시지를 출력하는 메서드
- [x] printWinningProfitRatioMessage()
  - 로또 당첨 결과 수익률 메시지를 출력하는 메서드

- - -

# *Controller*
## LottoController
- [x] run()
  - LottoController의 메서드들을 종합하는 메서드
- [x] printPriceMessage()
  - OutputView의 printPriceMessage()를 담은 메서드
- [x] createPrice()
  - 사용자로부터 입력값을 받아 Price 객체 생성하고 반환하는 메서드
  - 올바른 값을 입력할 때까지 무한 반복
- [x] createConsumer()
  - Price 객체를 파라미터로 받아 Price, Count, List<Lotto> 필드를 가진 Consumer 객체를 생성하고 반환하는 메서드
- [x] printConsumerLotto() 
  - Consumer 객체를 파라미터로 받아 해당 객체의 Count만큼 만들어진 Lotto객체들(List<Lotto>)를 출력하는 메서드
- [x] printProducerLottoMessage()
  - OutputView의 printPriceLottoMessage()를 담은 메서드
- [x] createProducerLotto()
  - 사용자로부터 입력값을 받아 Lotto 객체 생성하고 반환하는 메서드
  - 로또 당첨 번호를 입력받는 메서드
  - 올바른 값을 입력할 때까지 무한 반복
- [x] printProducerLottoBonusMessage()
  - OutputView의 printProducerLottoBonusMessage()를 담은 메서드
- [x] getProducer()
  - createProducerLottoBonus()와 createProducer()를 담은 메서드
- [x] createProducerLottoBonus()
  - 사용자로부터 입력값을 받아 Bonus 객체 생성하고 반환하는 메서드
  - 로또 당첨 보너스 번호를 입력받는 메서드
  - 올바른 값을 입력할 때까지 무한 반복
- [x] createProducer()
  - Lotto 객체와 Bonus 객체를 파라미터로 받아 Producer 객체를 생성하고 반환하는 메서드
- [x] printWinningResultMessage()
  - OutputView의 printWinningResultMessage()를 담은 메서드
- [x] printWinningLottoResult()
  - Consumer 객체와 Producer 객체를 파라미터로 받아 당첨 결과를 출력하고 총 상금(totalProfit)을 반환하는 메서드
- [x] getCountInCaseOfNotFive()
  - 소비자가 구매한 로또에 당첨 보너스 번호가 존재하지 않을 경우 당첨순위(rank)와 당첨횟수(count)을 계산하여 반환하는 메서드 
  - 2등과 3등이 당첨 번호가 5개 일치하는 문제 때문에 필요
- [x] getCountInCaseOfFive()
  - 소비자가 구매한 로또에 당첨 보너스 번호가 존재할 경우 당첨순위(rank)와 당첨횟수(count)을 계산하여 반환하는 메서드
  - 2등과 3등이 당첨 번호가 5개 일치하는 문제 때문에 필요
- [x] printWinningProfitRatio()
  - OutputView의 printWinningProfitRatioMessage() 메서드를 담은 메서드
  - OutputView의 printWinningProfitRatioMessage() 메서드에 총 삼금(totalProfit)을 전달하여 수익률을 출력하는 메서드
- [x] createMatchCountMap()[
  - 소비자의 Lotto 객체 하나씩을 당첨 Lotto 객체와 비교하며 일치하는 갯수와 당첨 보너스 번호일치 여부를 Map 에 저장하는 메서드
  - countMatchNumber(), countMatchBonusNumber() 메서드들을 담은 메서드
- [x] countMatchNumber()
  - 소비자가 구매한 로또가 당첨 번호와의 일치 갯수를 계산하여 반환하는 메서드
- [x] countMatchBonusNumber()
  - 소비자가 구매한 로또가 당첨 보너스 번호와의 일치 여부를 계산하여 반환하는 메서드

- - -

# *Exception Class*
- [ ] InputLottoNotNumericException
  - 로또 당첨 번호를 숫자가 아닌 한글, 영어로 입력한 경우
- [ ] InputLottoSeparateRegexException
  - 로또 당첨 번호를 구분하기 위해 쉼표가 아닌 특수기호를 사용한 경우
- [ ] InputLottoNotPositiveIntegerException
  - 로또 당첨 번호를 양의 정수가 아닌 수로 입력한 경우
- [ ] BonusDuplicationException
  - 로또 당첨 번호와 로또 당첨 보너스 번호가 중복되는 경우
- [ ] BonusNotNumericException
  - 로또 당첨 보너스 번호가 숫자가 아닌 한글, 영어로 입력한 경우
- [ ] BonusNotInRangeException
  - 로또 당첨 보너스 번호가 1 이상 45 이하의 범위에 없는 경우
- [ ] LottoDuplicationException
  - 로또 당첨 번호가 서로 중복되는 경우
- [ ] LottoNotInRangeException
  - 로또 당첨 번호가 1 이상 45 이하의 범위에 없는 경우
- [ ] LottoNotSizeSixException
  - 로또 당첨 번호가 6개가 아닌 경우
- [ ] PriceNotPositiveIntegerException
  - 가격을 양의 정수가 아닌 수로 입력한 경우
- [ ] PriceNot1KsException
  - 가격을 1000 단위로 입력하지 않은 경우

