package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

public class WellRpsTest {
    private RockPaperScissors rps;

    @Before
    public void createRpsGame() {
        rps = new WellRps();
    }

    @Test
    public void PlayerShouldWinWithWellVsRock() {
        assertGame(RpsOptions.WELL, RpsOptions.ROCK, RpsOutcomes.PLAYER_WINS);
    }

    @Test
    public void AiShouldWinWithWellVsScissors() {
        assertGame(RpsOptions.SCISSORS, RpsOptions.WELL, RpsOutcomes.AI_WINS);
    }

    @Test
    public void PlayerShouldWinWithPaperVsWell() {
        assertGame(RpsOptions.PAPER, RpsOptions.WELL, RpsOutcomes.PLAYER_WINS);
    }

    @Test
    public void GameShouldBeDrawnWithSameOption() {
        for (RpsOptions option : rps.getValidOptions()) {
            assertGame(option, option, RpsOutcomes.DRAW);
        }
    }

    @Test
    public void ValidOptionsShouldBeRockPaperScissors() {
        RpsOptions[] options = rps.getValidOptions();

        assertThat(options, arrayContainingInAnyOrder(RpsOptions.SCISSORS, RpsOptions.ROCK, RpsOptions.PAPER,
                RpsOptions.WELL));
    }

    private void assertGame(RpsOptions playerOption, RpsOptions aiOption, RpsOutcomes outcome) {
        rps.setAi(options -> aiOption);

        RpsOutcomes result = rps.play(playerOption);

        assertThat(result, equalTo(outcome));
    }
}