package com.codingkata.rps.game.ai;

import com.codingkata.rps.game.RpsOptions;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Tim Silhan
 */
public class RandomAiTest {
    private RpsAi ai;

    @Before
    public void createAi() {
        ai = new RandomAi();
    }

    @Test
    public void shouldNotReturnNull() {
        RpsOptions[] options = new RpsOptions[]{RpsOptions.ROCK, RpsOptions.PAPER, RpsOptions.PAPER};

        RpsOptions result = ai.makeChoice(options);

        assertNotNull(result);
    }

    @Test
    public void shouldReturnOnlyOption() {
        RpsOptions[] options = new RpsOptions[]{RpsOptions.ROCK};

        RpsOptions result = ai.makeChoice(options);

        assertThat(result, equalTo(RpsOptions.ROCK));
    }
}
