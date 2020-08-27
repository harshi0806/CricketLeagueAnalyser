package cricketleagueanalyser;

import com.google.gson.Gson;

import java.util.*;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {
    public enum Play { BATTING , BOWLING }
    Map<String, IPLCensusDAO> censusMap = new HashMap<>();

    public int loadIPLCensusData(Play play, String... csvFilePath) throws CricketLeagueAnalyserException {
        censusMap = new IPLCensusLoader().loadIPLCensusData(play, csvFilePath);
        return censusMap.size();
    }

    public String getBattingAverageWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.average);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getStrikingRateWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.strikeRate);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
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
