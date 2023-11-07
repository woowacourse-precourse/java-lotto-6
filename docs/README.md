<h1>구현할 기능 목록</h1>

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
- 로또가 몇 등 했는지(findRanking)

<h3>LottoAmount</h3>
- 값 입력 받기(LottoAmount 생성자)
- 입력값 판별(validate)
  - 숫자인지 판별(validateNumber)
  - 0보다 큰 숫자인지 판별(validateRange)
  - 숫자가 로또 가격의 배수인지 확인(isPriceMultiple)
- 로또 갯수 확인(getLottoAmount)

<h3>PrintResult</h3>
- 로또 번호 출력(printLotto)
- 당첨 통계 출력(printStatistics)

<h3>AutoLottoNumber</h3>
- 랜덤 숫자 리스트 생성(putOutNumber)
  - 리스트 숫자 추가(addNumber) 
  - 리스트 정렬(sortNumber)

<h3>Person</h3>
- 초기값 초기화(Person 생성자)
- 돈 입력 받기(Money)
- 돈만큼 lotto 사기(buyLotto)
- 당첨 번호 보기(WinningNumber)
- 일치 확인(findRanking)