package com.tcg.dlc.battlewizards.entity;

import com.tcg.dlc.battlewizards.enums.SpellCardType;
import com.tcg.dlc.battlewizards.enums.SpellGlyph;

public abstract class SpellCard extends Card {

    private SpellCardType spellType;
    private SpellGlyph spellGlyph;

    public SpellCardType getSpellType() {
        return spellType;
    }

    public void setSpellType(SpellCardType spellType) {
        this.spellType = spellType;
    }

    public SpellGlyph getSpellGlyph() {
        return spellGlyph;
    }

    public void setSpellGlyph(SpellGlyph spellGlyph) {
        this.spellGlyph = spellGlyph;
    }

}
