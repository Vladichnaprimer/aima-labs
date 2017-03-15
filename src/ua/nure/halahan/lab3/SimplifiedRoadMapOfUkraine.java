package ua.nure.halahan.lab3;

import aima.core.environment.map.ExtendableMap;

public class SimplifiedRoadMapOfUkraine extends ExtendableMap {
    public SimplifiedRoadMapOfUkraine() {
        initMap(this);
    }

    public static final String KHARKOV = "KHARKOV";
    public static final String KYIV = "KYIV";
    public static final String LVIV = "LVIV";
    public static final String DNEPR = "DNEPR";
    public static final String CHERKASY = "CHERKASY";
    public static final String SUMY = "SUMY";
    public static final String POLTAVA = "POLTAVA";
    public static final String KIROVOGRAD = "KIROVOGRAD";

    public static void initMap(ExtendableMap map) {
        map.clear();

        // Kharkov
        map.addBidirectionalLink(KHARKOV, POLTAVA, 141.0);
        map.addBidirectionalLink(KHARKOV, DNEPR, 213.0);

        // Kyiv
        map.addBidirectionalLink(KYIV, CHERKASY, 120.0);
        map.addBidirectionalLink(KYIV, SUMY, 427.0);
        map.addBidirectionalLink(KYIV, POLTAVA, 343.0);
        map.addBidirectionalLink(KYIV, LVIV, 440.0);

        // Sumy
        map.addBidirectionalLink(SUMY, KHARKOV, 190.0);

        // Poltava
        map.addBidirectionalLink(POLTAVA, CHERKASY, 271.0);
        map.addBidirectionalLink(POLTAVA, DNEPR, 203.0);
        map.addBidirectionalLink(POLTAVA, KIROVOGRAD, 150.0);

        //Lviv
        map.addBidirectionalLink(LVIV, CHERKASY, 400.0);

        //Kirovograd
        map.addBidirectionalLink(KIROVOGRAD, CHERKASY, 100.0);



        // Set cities position
        map.setPosition(KYIV,-30,15);
        map.setPosition(CHERKASY,-28,98);
        map.setPosition(POLTAVA,106,88);
        map.setPosition(KIROVOGRAD,44,130);
        map.setPosition(SUMY,110,23);
        map.setPosition(DNEPR,120,142);
        map.setPosition(KHARKOV,160,76);
        map.setPosition(LVIV,-210,80);
    }
}
