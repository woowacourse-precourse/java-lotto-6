<h1>구현할 기능 목록</h1>

<h3>Lotto</h3>
- 주어진 값 내부 변수에 넣기 (Lotto 생성자)
- 주어진 값의 크기가 유효한지 판별 (validateSize)
- 중복 값이 있는 지 판별 (validateDuplication)
- 로또 번호 확인(getLotto)

<h3>WinningNumber</h3>
- 당첨 번호 입력 받기(WinningNumber 생성자, 잘못된 값일 경우 다시 입력 받기)
- 숫자인지 판별(isNumber)
- 값의 크기가 6인지 판별(isSizeSix)
- 중복 값이 있는지 판별(isDuplication)
- 1~45사이 숫자인지 판별(isInRange)
- 보너스 번호 입력 받기(inputBonus)
- 로또가 몇 등 했는지(findRanking)

<h3>CashInHand</h3>
- 값 입력 받기(CashInHand 생성자, 잘못된 값일 경우 다시 입력 받기)
- 숫자인지 판별(isNumber)
- 숫자가 1000의 배수 인지 확인(isThousandMultiple)
- 돈 확인(getCash)

<h3>PrintResult</h3>
- 로또 번호 출력(printLotto)
- 당첨 통계 출력(printStatistics)

<h3>RandomNumber</h3>
- 랜덤 숫자 리스트 생성(makeRandomList)
- 리스트 정렬(sortList)

<h3>Buyer</h3>
- 초기값 초기화
- 돈 입력 받기(Money)
- 돈만큼 lotto 사기(buyLotto)
- 당첨 번호 보기(WinningNumber)
- 일치 확인(findRanking)