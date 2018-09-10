package com.codingkata.rps.service;

import com.codingkata.rps.game.RockPaperScissors;
import com.codingkata.rps.game.RpsVariants;
import com.codingkata.rps.game.variants.StandardRps;
import com.codingkata.rps.game.variants.WellRps;

/**
 * @author Tim Silhan
 */
public class RpsFactoryImpl implements RpsFactory {
    @Override
    public RockPaperScissors getRpsInstance(RpsVariants variant) {
        switch (variant) {
            case STANDARD:
                return new StandardRps();
            case WELL:
                return new WellRps();
            default:
                throw new IllegalArgumentException("Variant could not be created");
        }
    }
}
