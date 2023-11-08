<h1>구현할 기능 목록</h1>

<h2>Controller</h2>
<h3>Person</h3>
- inputView, outputView 입력(Person 생성자)
- 로또 구매(buyLotto)
- 구매 금액 입력, 틀릴 시 다시 입력(inputCashInHand)
- 갯수만큼 자동으로 복권생성(autoLotto)
- 당첨 번호 입력, 틀릴 시 다시 입력(inputWinningNumber)
- 보너스 번호 입력, 틀릴 시 다시 입력(inputBonusNumber)

<h2>Model</h2>
<h3>Lotto</h3>
- 주어진 값 내부 변수에 넣기 (Lotto 생성자)
- 입력값 판별(validate)
  - 주어진 값의 크기가 유효한지 판별 (validateSize)
  - 중복 값이 있는 지 판별 (validateDuplication)
- 로또 번호 확인(getLotto)

<h3>WinningNumber</h3>
- 당첨 번호 입력 받기(WinningNumber 생성자)
- 입력값 판별(validate)
  - 숫자인지 판별(validateNumber)
  - 숫자 갯수 판별(validateSize)
  - 중복 값이 있는지 판별(validateDuplication)
  - 1~45사이 숫자인지 판별(validateRange)
- 당첨 번호 확인(getWinningNumber)
- 로또가 몇 등 했는지(checkLotto)
- 뒤바뀐 1,2 등 위치 변경(switchRanking)

<h3>LottoAmount</h3>
- 값 입력 받기(LottoAmount 생성자)
- 입력값 판별(validate)
  - 숫자인지 판별(validateNumber)
  - 0보다 큰 숫자인지 판별(validateRange)
  - 숫자가 로또 가격의 배수인지 확인(isPriceMultiple)
- 로또 갯수 확인(getLottoAmount)

<h3>BonusNumber</h3>
- 값 입력 받기(BonusNumber 생성자)
- 입력값 판별(validate)
  - 숫자인지 판별(validateNumber)
  - 1~45 사이 숫자인지 판별(validateRange)
  - 당첨 번호와 중복 값이 있는지 판별(validateDuplication)
- 로또 갯수 확인(getLottoAmount)

<h2>Service</h2>
<h3>AutoLottoNumber</h3>
- 랜덤 숫자 리스트 생성(putOutNumber)
  - 리스트 정렬(sortNumber)(예제 Test가 List.of여서 넣을 시 오류 발생, 코멘트 처리 중)

<h3>TotalReturn</h3>
- 총 수익률을 반환(getTotalReturnRate)

<h2>View</h2>
<h3>InputView</h3>
- 구매금액을 읽음(readCash)
- 당첨 번호를 읽음(readWinningNumber)
- 보너스 번호를 읽음(readBonusNumber)

<h3>OutputView</h3>
- 구매량 출력(printAmount)
- 로또 번호 출력(printLotto)
- 당첨 결과 출력(printResult)


