package cricketleagueanalyser;

import java.util.*;

public class CricketLeagueAnalyser {
    public enum Play { BATTING , BOWLING }
    Map<String, IPLCensusDAO> censusMap = new HashMap<>();

    public int loadIPLCensusData(Play play, String... csvFilePath) throws CricketLeagueAnalyserException {
        censusMap = new IPLCensusLoader().loadIPLCensusData(play, csvFilePath);
        return censusMap.size();
    }
    private static <E> List<E> descendingSort(Comparator<E> censusComparator, List<E> censusList) {
        for (int i = 0; i < censusList.size()-1; i++) {
            for (int j =0; j< censusList.size() -i -1; j++) {
                E census1 = censusList.get(j);
                E census2 = censusList.get(j+1);
                if (censusComparator.compare(census1, census2) < 0){
                    censusList.set(j, census2);
                    censusList.set(j+1, census1);
                }
            }
        }
        return censusList;
    }
}
