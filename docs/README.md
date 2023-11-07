# 기능 요구사항

- [] 로또를 시작한다. LottoGame#run
    - [X] 입력문구를 출력한다. InputView#inputPrice
    - [X] 가격 입력 문구 출력 InputView#inputPrice
    - [X] 가격을 입력받는다.
        - [X] 1000원 단위를 입력 받았는지 검증. Customer#validatePrice
    - [] 가격에 맞는 갯수로 로또를 생성한다. Customer#buy
        - [] 로또 생성 LottoRandomGenerator#generateLottoSortedNumbers
            - 유효성검사 Lotto#validateLotto
            - [] 1 ~ 45 사이의 값이여야 한다. Validation#validateLottoNumberRange
            - [] 6자리 숫자여야한다. Validation#validateLottoSize
            - [] 중복값이 없어야한다. Validation#validateNumberIsUnique
            - 정렬한다.
                - [] 생성 후 리스트 형식으로 출력한다. Customer#getLotto
    - [] 당첨 번호를 생성한다. WinningLotto#WinningLotto
        - [] 로또 번호 입력 문구를 출력한다. InputView#inputWinningLottoNumber
        - [] 당첨 번호를 입력받는다. InputView#inputWinningLottoNumber
            - [] 로또 생성과 똑같은 검증을 거친다. WinningLotto#validationWinningLottoNumbers
        - [] 보너스 번호를 입력받는다. InputView#inputWinningBonusNumber
            - 보너스 번호 유효성 검사 WinningLotto#validationBonusNumber
                - [] 1 ~ 45 사이의 숫자여야한다. Validation#validateLottoNumberRange
                - [] 로또의 숫자와 중복되지 않아야 한다. Validation#validateBonusNumber

- [] 결과를 도출한다.
    - [] 각각의 로또들을 당첨 번호와 비교하여 list를 추출한다. WinningLotto#compareLottosToRank
    - [] list를 가지고 구매가와 당첨금을 비교한다. LottoGame#getResult
    - [] 결과를 출력한다. OutputView#resultOutput

## 이외의 예외처리

---
- [X] 정적 클래스는 객체로 생성되어선 안된다. ShouldNotCreatedClassException 
 
