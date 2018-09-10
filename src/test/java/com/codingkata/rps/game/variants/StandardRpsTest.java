package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * @author Tim Silhan
 */
public class StandardRpsTest extends VariantTest{

    @Before
    public void createRpsGame() {
        rps = new StandardRps();
    }

    @Test
    public void playerShouldWinWithRockVsScissors() {
        assertGame(RpsOptions.ROCK, RpsOptions.SCISSORS, RpsOutcomes.PLAYER_WINS);
    }

    @Test
    public void playerShouldWinWithScissorsVsPaper() {
        assertGame(RpsOptions.SCISSORS, RpsOptions.PAPER, RpsOutcomes.PLAYER_WINS);
    }

    @Test
    public void AiShouldWinWithPaperVsRock() {
        assertGame(RpsOptions.ROCK, RpsOptions.PAPER, RpsOutcomes.AI_WINS);
    }

    @Test
    public void GameShouldBeDrawnWithSameOption() {
        for (RpsOptions option : rps.getValidOptions()) {
            assertGame(option, option, RpsOutcomes.DRAW);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgumentIfOptionInvalid() {
        rps.play(RpsOptions.WELL);
    }

    @Test
    public void GameShouldSaveStateAfterPlay() {
        rps.setAi(options -> RpsOptions.ROCK);

        RpsOutcomes outcome = rps.play(RpsOptions.PAPER);

        assertThat(rps.getPlayerChoice(), equalTo(RpsOptions.PAPER));
        assertThat(rps.getAiChoice(), equalTo(RpsOptions.ROCK));
        assertThat(rps.getOutcome(), equalTo(outcome));
    }

    @Test
    public void ValidOptionsShouldBeRockPaperScissors() {
        RpsOptions[] options = rps.getValidOptions();

        assertThat(options, arrayContainingInAnyOrder(RpsOptions.SCISSORS, RpsOptions.ROCK, RpsOptions.PAPER));
    }
}
