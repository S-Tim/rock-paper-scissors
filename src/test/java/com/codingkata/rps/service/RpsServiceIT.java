package com.codingkata.rps.service;

import com.codingkata.rps.dto.RockPaperScissorsDto;
import com.codingkata.rps.dto.RpsVariantInfo;
import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.game.variants.StandardRps;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Tim Silhan
 */
public class RpsServiceIT {
    private RpsService rpsService;

    @Before
    public void createRpsFactory() {
        rpsService = new RpsService(new RpsFactory());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWithIllegalOption() {
        rpsService.playGame(RpsVariants.STANDARD, RpsOptions.WELL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenVariantIsNull() {
        rpsService.playGame(null, RpsOptions.ROCK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenOptionIsNull() {
        rpsService.playGame(RpsVariants.STANDARD, null);
    }

    @Test
    public void shouldNotReturnNullAfterPlay() {
        RockPaperScissors rps = rpsService.playGame(RpsVariants.WELL, RpsOptions.PAPER);

        assertNotNull(rps);
    }

    @Test
    public void shouldPopulateDtoCorrectly() {
        RockPaperScissors rps = new StandardRps();
        rps.setAi(options -> RpsOptions.ROCK);
        rps.play(RpsOptions.PAPER);

        RockPaperScissorsDto dto = rpsService.getDto(rps);

        assertThat(dto.getVariant(), equalTo(rps.getVariant()));
        assertThat(dto.getPlayerChoice(), equalTo(rps.getPlayerChoice()));
        assertThat(dto.getAiChoice(), equalTo(rps.getAiChoice()));
        assertThat(dto.getOutcome(), equalTo(rps.getOutcome()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenRpsIsNull() {
        rpsService.getDto(null);
    }

    @Test
    public void shouldCreateInfoForAllVariants() {
        List<RpsVariantInfo> ruleSets = rpsService.getRuleSets();

        assertThat(RpsVariants.values().length, equalTo(ruleSets.size()));
    }
}
