package com.goldencodes.zbattle.manager.phase.util.misc;

import org.bukkit.Material;

public class Currency {

    private final String _plural;
    private final String _singular;
    private final String _color;
    private final Material _displayMaterial;

    public Currency(String plural, String singular, String color, Material displayMaterial) {
        this._plural = plural;
        this._singular = singular;
        this._color = color;
        this._displayMaterial = displayMaterial;
    }

    public String getPrefix() { return _plural; }

    public String getString(int amount, boolean color) {
        return (color ? _color : "") + amount + " " + (amount == 1 ? _singular : _plural);
    }

    public String getString(int amount) { return getString(amount, true); }

    public String getColor() { return _color; }

    public Material getDisplayMaterial() { return _displayMaterial; }
}
