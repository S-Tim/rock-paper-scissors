package com.codingkata.rps.game.variants;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsOutcomes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Base class for variant tests that provides helper methods
 * to reduce redundancy across tests.
 *
 * @author Tim Silhan
 */
public class VariantTest {
    protected RockPaperScissors rps;

    protected void assertGame(RpsOptions playerOption, RpsOptions aiOption, RpsOutcomes outcome) {
        rps.setAi(options -> aiOption);

        RpsOutcomes result = rps.play(playerOption);

        assertThat(result, equalTo(outcome));
    }
}
