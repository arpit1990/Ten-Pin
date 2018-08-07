public class BowlingGame {

  private int currentRoll = 0;
  private int[] rolls = new int[21];

  public void roll(int pins) {
    rolls[currentRoll++] = pins;
  }

  public int score() {
    int score = 0;
    int rollIndex = 0;

    for(int frameIndex = 0; frameIndex < 10; frameIndex++) {
      if(isSpare(rollIndex)) {
        score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
      } else {
        score += rolls[rollIndex] + rolls[rollIndex + 1];
      }
      rollIndex += 2;
    }

    return score;
  }

  private boolean isSpare(int rollIndex) {
    return rolls[rollIndex] + rolls[rollIndex+1] == 10;
  }
}
