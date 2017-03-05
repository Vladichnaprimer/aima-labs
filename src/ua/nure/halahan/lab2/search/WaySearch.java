package ua.nure.halahan.lab2.search;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractEnvironment;

public class WaySearch extends AbstractEnvironment {

    private LinkedHashMap<String, Map> ways;
    
    private static final String ORADEA = "Oradea";
    private static final String ZERIND = "Zerind";
    private static final String ARAD = "Arad";
    private static final String TIMISOARA = "Timisoara";
    private static final String LUGOJ = "Lugoj";
    private static final String MEHADIA = "Mehadia";
    private static final String DOBRETA = "Dobreta";
    private static final String SIBIU = "Sibiu";
    private static final String RIMNICU_VILCEA = "RimnicuVilcea";
    private static final String CRAIOVA = "Craiova";
    private static final String FAGARAS = "Fagaras";
    private static final String PITESTI = "Pitesti";
    private static final String GIURGIU = "Giurgiu";
    private static final String BUCHAREST = "Bucharest";
    private static final String NEAMT = "Neamt";
    private static final String URZICENI = "Urziceni";
    private static final String IASI = "Iasi";
    private static final String VASLUI = "Vaslui";
    private static final String HIRSOVA = "Hirsova";
    private static final String EFORIE = "Eforie";

    private void initialization() {
        ways = new LinkedHashMap<String,Map>();

        Map<String, Integer> oradea = new LinkedHashMap<String, Integer>();
        oradea.put(SIBIU, 151);
        oradea.put(ZERIND, 71);
        ways.put(ORADEA, oradea);

        Map<String, Integer> sibiu = new LinkedHashMap<String, Integer>();
        sibiu.put(ORADEA, 151);
        sibiu.put(ARAD, 140);
        sibiu.put(FAGARAS, 99);
        sibiu.put(RIMNICU_VILCEA, 80);
        ways.put(SIBIU, sibiu);

        Map<String, Integer> zerind = new LinkedHashMap<String, Integer>();
        zerind.put(ARAD, 75);
        zerind.put(ORADEA, 71);
        ways.put(ZERIND, zerind);

        Map<String, Integer> arad = new LinkedHashMap<String, Integer>();
        arad.put(ZERIND, 75);
        arad.put(SIBIU, 140);
        arad.put(TIMISOARA, 118);
        ways.put(ARAD, arad);

        Map<String, Integer> timisoara = new LinkedHashMap<String, Integer>();
        timisoara.put(ARAD, 118);
        timisoara.put(LUGOJ, 111);
        ways.put(TIMISOARA, timisoara);

        Map<String, Integer> lugoj = new LinkedHashMap<String, Integer>();
        lugoj.put(TIMISOARA, 111);
        lugoj.put(MEHADIA, 70);
        ways.put(LUGOJ, lugoj);

        Map<String, Integer> mehadia = new LinkedHashMap<String, Integer>();
        mehadia.put(LUGOJ, 70);
        mehadia.put(DOBRETA, 75);
        ways.put(MEHADIA, mehadia);

        Map<String, Integer> dobreta = new LinkedHashMap<String, Integer>();
        dobreta.put(MEHADIA, 75);
        dobreta.put(CRAIOVA, 120);
        ways.put(DOBRETA, dobreta);

        Map<String, Integer> craiova = new LinkedHashMap<String, Integer>();
        craiova.put(DOBRETA, 120);
        craiova.put(RIMNICU_VILCEA, 146);
        craiova.put(PITESTI, 138);
        ways.put(CRAIOVA, craiova);

        Map<String, Integer> rimnicuVilcea = new LinkedHashMap<String, Integer>();
        rimnicuVilcea.put(SIBIU, 80);
        rimnicuVilcea.put(CRAIOVA, 146);
        rimnicuVilcea.put(PITESTI, 97);
        ways.put(RIMNICU_VILCEA, rimnicuVilcea);

        Map<String, Integer> pitesti = new LinkedHashMap<String, Integer>();
        pitesti.put(CRAIOVA, 138);
        pitesti.put(RIMNICU_VILCEA, 97);
        pitesti.put(BUCHAREST, 101);
        ways.put(PITESTI, pitesti);

        Map<String, Integer> fegaras = new LinkedHashMap<String, Integer>();
        fegaras.put(SIBIU, 99);
        fegaras.put(BUCHAREST, 211);
        ways.put(FAGARAS, fegaras);

        Map<String, Integer> bucharest = new LinkedHashMap<String, Integer>();
        bucharest.put(FAGARAS, 211);
        bucharest.put(PITESTI, 101);
        bucharest.put(GIURGIU, 90);
        bucharest.put(URZICENI, 85);
        ways.put(BUCHAREST, bucharest);

        Map<String, Integer> giurgiu = new LinkedHashMap<String, Integer>();
        giurgiu.put(BUCHAREST, 90);
        ways.put(GIURGIU, giurgiu);

        Map<String, Integer> urziceni = new LinkedHashMap<String, Integer>();
        urziceni.put(BUCHAREST, 85);
        urziceni.put(VASLUI, 142);
        urziceni.put(HIRSOVA, 98);
        ways.put(URZICENI, urziceni);

        Map<String, Integer> vaslui = new LinkedHashMap<String, Integer>();
        vaslui.put(URZICENI, 142);
        vaslui.put(IASI, 99);
        ways.put(VASLUI, vaslui);

        Map<String, Integer> lasi = new LinkedHashMap<String, Integer>();
        lasi.put(VASLUI, 99);
        lasi.put(NEAMT, 87);
        ways.put(IASI, lasi);

        Map<String, Integer> neamt = new LinkedHashMap<String, Integer>();
        neamt.put(IASI, 87);
        ways.put(NEAMT, neamt);

        Map<String, Integer> hirsova = new LinkedHashMap<String, Integer>();
        hirsova.put(URZICENI, 98);
        hirsova.put(EFORIE, 86);
        ways.put(HIRSOVA, hirsova);

        Map<String, Integer> eforie = new LinkedHashMap<String, Integer>();
        eforie.put(HIRSOVA, 86);
        ways.put(EFORIE, eforie);
    }

    public int easySearch(String from, String to) {
        int result = 0;
        String currentLocation = from;
        String lastLocation = from;
        int i = 20;
        while(!currentLocation.equals(to) && i!=50) {
            Map<String, Integer> currentCity = this.ways.get(currentLocation);
            int minWay = Integer.MAX_VALUE;
            String minCity = "";
            for(Entry<String, Integer> way : currentCity.entrySet()) {
                String key = way.getKey();
                if(way.getValue() < minWay && !key.equals(lastLocation)) {
                    minWay = way.getValue();
                    minCity = key;
                }
            }
            System.out.println(currentLocation + " -- " + minCity + " = " + (result+minWay) + " km");
            result += minWay;
            lastLocation = currentLocation;
            currentLocation = minCity;
            i++;
        }

        return result;
    }

    public WaySearch() {
        this.initialization();
    }

    @Override
    public EnvironmentState executeAction(Agent arg0, Action arg1) {
        return null;
    }

    @Override
    public EnvironmentState getCurrentState() {
        return null;
    }

    @Override
    public Percept getPerceptSeenBy(Agent arg0) {
        return null;
    }

    public static void main(String[] args) {
        WaySearch test = new WaySearch();
        test.easySearch(ARAD, "Bucharest");
    }
}
