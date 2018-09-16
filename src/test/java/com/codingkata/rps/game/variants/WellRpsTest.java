package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

/**
 * @author Tim Silhan
 */
public class WellRpsTest extends VariantTest {
    @Before
    public void createRpsGame() {
        this.rps = new WellRps();
    }

    @Test
    public void playerShouldWinWithWellVsRock() {
        assertGame(RpsOptions.WELL, RpsOptions.ROCK, RpsOutcomes.PLAYER_WINS);
    }

    @Test
    public void aiShouldWinWithWellVsScissors() {
        assertGame(RpsOptions.SCISSORS, RpsOptions.WELL, RpsOutcomes.AI_WINS);
    }

    @Test
    public void playerShouldWinWithPaperVsWell() {
        assertGame(RpsOptions.PAPER, RpsOptions.WELL, RpsOutcomes.PLAYER_WINS);
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
    public void aiShouldWinWithPaperVsRock() {
        assertGame(RpsOptions.ROCK, RpsOptions.PAPER, RpsOutcomes.AI_WINS);
    }

    @Test
    public void gameShouldBeDrawnWithSameOption() {
        for (RpsOptions option : rps.getValidOptions()) {
            assertGame(option, option, RpsOutcomes.DRAW);
        }
    }

    @Test
    public void gameShouldSaveStateAfterPlay() {
        rps.setAi(options -> RpsOptions.WELL);

        RpsOutcomes outcome = rps.play(RpsOptions.ROCK);

        assertThat(rps.getPlayerChoice(), equalTo(RpsOptions.ROCK));
        assertThat(rps.getAiChoice(), equalTo(RpsOptions.WELL));
        assertThat(rps.getOutcome(), equalTo(outcome));
    }

    @Test
    public void validOptionsShouldBeRockPaperScissorsWell() {
        RpsOptions[] options = rps.getValidOptions();

        assertThat(options, arrayContainingInAnyOrder(RpsOptions.SCISSORS, RpsOptions.ROCK, RpsOptions.PAPER,
                RpsOptions.WELL));
    }
}