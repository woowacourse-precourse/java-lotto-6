# *Model*
## consumer
- [ ] record Consumer(Price, List<Integer>, Count)
    - 구입한 로또의 번호를 관리하는 레코드
    - Price 만 활용하여 Consumer 인스턴스 만들도록 생성자 추가
    - List<Integer>, Count 는 null
    - validation 추가
- [ ] record Price(Integer)
    - 구입한 로또의 금액을 관리하는 레코드
    - validation 추가
- [ ] record Count(int)
    - 구입한 로또의 갯수를 관리하는 레코드
## producer
- [ ] record Producer(Lotto, Bonus)
    - Lotto, Bonus 관리하는 레코드
- [ ] record Bonus(Lotto, int)
    - 로또 당첨 보너스 번호 관리하는 레코드
    - 로또 당첨 번호와의 중복 검증을 위해 Lotto 필드 추가
    - validation 추가
## common
- [ ] record Lotto(List<Integer>)
    - Consumer 와 Producer 인스턴스를 생성할 때 사용하는 레코드
    - Consumer 와 Producer 인스턴스를 생성하기 전에 검증하기 위해 Lotto 생성자에 validation 추가
- [ ] enum Rank
    - 로또 당첨순위에 따른 정보들을 열거형으로 관리하는 열거형

- - -

# *View*
## InputView
- [ ] inputPrice()
    - 로또 구매 금액 입력받는 메서드
    - validation 추가
- [ ] inputLotto
    - 로또 당첨 번호 입력받는 메서드
    - validation 추가
- [ ] inputLottoBonus
    - 로또 당첨 보너스 번호 입력받는 메서드
    - validation 추가

## OutputView
- [ ] printPriceMessage()
  - 로또 구매 금액 입력을 유도하는 메시지를 출력하는 메서드
- [ ] printConsumerLotto()
  - 로또 구매 금액만큼 자동 발행된 로또를 출력하여 보여주는 메서드
- [ ] printProducerLottoMessage()
  - 로또 당첨 번호 입력을 유도하는 메시지를 출력하는 메서드
- [ ] printProducerBonusMessage()
  - 로또 당첨 보너스 번호 입력을 유도하는 메시지를 출력하는 메서드
- [ ] printWinningResultMessage()
  - 로또 당첨 결과 메시지를 출력하는 메서드
- [ ] printWinningProfitRatioMessage()
  - 로또 당첨 결과 수익률 메시지를 출력하는 메서드

- - -

# *Controller*

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

