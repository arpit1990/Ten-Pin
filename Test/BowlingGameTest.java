import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

  private BowlingGame bowlingGame;

  @BeforeEach
  void setUp() {
    bowlingGame = new BowlingGame();
  }

  @AfterEach
  void tearDown() {
    bowlingGame = null;
  }

  @Test
  public void expectsZeroWhenAllGutterRolls() {
    rollPins(0, 20);
    assertEquals(0, bowlingGame.score());
  }

  @Test
  public void expectsTwentyWhenAllOneRolls() {
    rollPins(1, 20);
    assertEquals(20, bowlingGame.score());
  }

  @Test
  public void canRollSpare() {
    bowlingGame.roll(5);
    bowlingGame.roll(5);
    bowlingGame.roll(3);
    rollPins(0, 17);
    assertEquals(16, bowlingGame.score());
  }

  private void rollPins(int rolls, int pins) {
    for(int i = 0; i < rolls; i++) {
      bowlingGame.roll(pins);
    }
  }
}