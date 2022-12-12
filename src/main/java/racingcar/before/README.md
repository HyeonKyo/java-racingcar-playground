## 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

## 기능 정의
* 자동차 이름 입력 (getCarNames())
  * 자동차 이름 구분
  * 예외처리
* 시도 횟수 입력 (getTurn())
  * 예외처리
* 시도 횟수만큼 턴 수행 (gameStart())
  * 자동차들 전진
  * 결과 출력
* 결과 출력
  * 총 거리로 우승자 선택
  * 우승자 출력

## 클래스 설계
* 자동차(Car)
  * 필드 : 이름, 전진거리
  * move()
  * printStatus()
* 자동차들 (Cars)
  * List<Car>의 일급클래스
* 레이싱 게임 (RacingGame)
  * setGame()
  * runGame()
  * printWinner()
* 사용자 입력 파싱 클래스 (GameInput)
* 게임 유저 입출력 (GameIO)

## TDD 순서
* Car 클래스 Test
  * [x] 생성 TEST
  * [x] move() Test
    * [x] 해당 값이 4이상이면 dist++
  * [x] print Test
* [x] 랜덤 숫자 생성 Util 클래스
* Cars Test
  * [x] Car List를 생성자 인자로 받아 생성
  * [x] 턴 수행
    * [x] 각각의 car move호출 및 상태 변경
    * [x] 자동차의 상태 출력
  * [x] 우승자 찾기
    * 가장 높은 dist를 가진 자동차 이름 Array 리턴
* GameIO
  * [x] 자동차 이름 입력 및 예외처리
  * [x] 턴 숫자 입력 및 예외처리
  * [x] 우승자 출력
* [x] RacingGame
  * setGame() -> GameIO로 입력 받아서 게임정보 세팅
  * runGame() -> 게임 진행시키고 정보 출력
  * printWinner() -> 최종 우승자 출력