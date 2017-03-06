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
        sibiu.put(FAGARAS, 99);
        sibiu.put(ARAD, 140);
        sibiu.put(RIMNICU_VILCEA, 80);
        ways.put(SIBIU, sibiu);

        Map<String, Integer> zerind = new LinkedHashMap<String, Integer>();
        zerind.put(ORADEA, 71);
        zerind.put(ARAD, 75);
        ways.put(ZERIND, zerind);

        Map<String, Integer> arad = new LinkedHashMap<String, Integer>();
        arad.put(ZERIND, 75);
        arad.put(SIBIU, 140);
        arad.put(TIMISOARA, 118);
        ways.put(ARAD, arad);

        Map<String, Integer> timisoara = new LinkedHashMap<String, Integer>();
        timisoara.put(LUGOJ, 111);
        timisoara.put(ARAD, 118);
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
        craiova.put(PITESTI, 138);
        craiova.put(RIMNICU_VILCEA, 146);
        ways.put(CRAIOVA, craiova);

        Map<String, Integer> rimnicuVilcea = new LinkedHashMap<String, Integer>();
        rimnicuVilcea.put(SIBIU, 80);
        rimnicuVilcea.put(PITESTI, 97);
        rimnicuVilcea.put(CRAIOVA, 146);
        ways.put(RIMNICU_VILCEA, rimnicuVilcea);

        Map<String, Integer> pitesti = new LinkedHashMap<String, Integer>();
        pitesti.put(RIMNICU_VILCEA, 97);
        pitesti.put(BUCHAREST, 101);
        pitesti.put(CRAIOVA, 138);
        ways.put(PITESTI, pitesti);

        Map<String, Integer> fegaras = new LinkedHashMap<String, Integer>();
        fegaras.put(SIBIU, 99);
        fegaras.put(BUCHAREST, 211);
        ways.put(FAGARAS, fegaras);

        Map<String, Integer> bucharest = new LinkedHashMap<String, Integer>();
        bucharest.put(URZICENI, 85);
        bucharest.put(GIURGIU, 90);
        bucharest.put(PITESTI, 101);
        bucharest.put(FAGARAS, 211);
        ways.put(BUCHAREST, bucharest);

        Map<String, Integer> giurgiu = new LinkedHashMap<String, Integer>();
        giurgiu.put(BUCHAREST, 90);
        ways.put(GIURGIU, giurgiu);

        Map<String, Integer> urziceni = new LinkedHashMap<String, Integer>();
        urziceni.put(BUCHAREST, 85);
        urziceni.put(HIRSOVA, 98);
        urziceni.put(VASLUI, 142);
        ways.put(URZICENI, urziceni);

        Map<String, Integer> vaslui = new LinkedHashMap<String, Integer>();
        vaslui.put(IASI, 99);
        vaslui.put(URZICENI, 142);
        ways.put(VASLUI, vaslui);

        Map<String, Integer> lasi = new LinkedHashMap<String, Integer>();
        lasi.put(NEAMT, 87);
        lasi.put(VASLUI, 99);
        ways.put(IASI, lasi);

        Map<String, Integer> neamt = new LinkedHashMap<String, Integer>();
        neamt.put(IASI, 87);
        ways.put(NEAMT, neamt);

        Map<String, Integer> hirsova = new LinkedHashMap<String, Integer>();
        hirsova.put(EFORIE, 86);
        hirsova.put(URZICENI, 98);
        ways.put(HIRSOVA, hirsova);

        Map<String, Integer> eforie = new LinkedHashMap<String, Integer>();
        eforie.put(HIRSOVA, 86);
        ways.put(EFORIE, eforie);
    }

    public int search(String from, String to){
        int result = 0;
        String curLocation = from;
        String prevLocation = from;

        int cities = 0;

        while (!curLocation.equals(to)){
            Map<String, Integer> city = ways.get(curLocation);
            int way = Integer.MAX_VALUE;
            String nextCity = "";
            for(Entry<String, Integer> w : city.entrySet()){
                String k = w.getKey();
                if(w.getValue() < way && !k.equals(prevLocation)){
                    way = w.getValue();
                    nextCity = k;
                }
            }
            System.out.println(curLocation  + " - " + nextCity + " : " + "total " + (result+way) + " km" );
            result += way;
            prevLocation = curLocation;
            curLocation = nextCity;
            cities++;
        }
        return result;
    }

    public WaySearch() {
        initialization();
    }

    @Override
    public EnvironmentState executeAction(Agent agent, Action action) {
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
        WaySearch roadToBucharest = new WaySearch();
        roadToBucharest.search(ARAD, BUCHAREST);
    }
}
