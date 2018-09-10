package com.codingkata.rps.dto;

import com.codingkata.rps.game.RpsOptions;
import com.codingkata.rps.game.RpsVariants;

import java.util.List;
import java.util.Map;

/**
 * Represents the rules of a RPS Game in a DTO fashion.
 *
 * @author Tim Silhan
 */
public class RpsVariantInfo {
    private RpsVariants variant;
    private Map<RpsOptions, List<RpsOptions>> ruleSet;

    public RpsVariantInfo() {

    }

    public RpsVariantInfo(RpsVariants variant, Map<RpsOptions, List<RpsOptions>> ruleSet) {
        this.variant = variant;
        this.ruleSet = ruleSet;
    }

    public RpsVariants getVariant() {
        return variant;
    }

    public void setVariant(RpsVariants variant) {
        this.variant = variant;
    }

    public Map<RpsOptions, List<RpsOptions>> getRuleSet() {
        return ruleSet;
    }

    public void setRuleSet(Map<RpsOptions, List<RpsOptions>> ruleSet) {
        this.ruleSet = ruleSet;
    }
}
