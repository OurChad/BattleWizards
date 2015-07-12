package com.tcg.dlc.battlewizards.entity;

import com.tcg.dlc.battlewizards.enums.SpellCardType;

public class DeliverySpellCard extends SpellCard{

    private int initiative;
    
    DeliverySpellCard(){
        setSpellType(SpellCardType.DELIVERY);
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}
