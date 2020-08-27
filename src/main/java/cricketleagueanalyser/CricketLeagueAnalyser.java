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
    public String getMax6sAnd4sWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.sixes * 6 + census.fours * 4);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBestStrikingRateWith6sAnd4sWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> strikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        Comparator<IPLCensusDAO> sixesAndFoursComparator = Comparator.comparing(census -> census.sixes * 6 + census.fours * 4);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(sixesAndFoursComparator.thenComparing(strikeRateComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getGreatAveragesWithBestStrikingRatesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        Comparator<IPLCensusDAO> strikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(strikeRateComparator.thenComparing(averageComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getMaxRunsWithBestAveragesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        Comparator<IPLCensusDAO> runsComparator = Comparator.comparing(census -> census.runs);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(runsComparator.thenComparing(averageComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBowlingAverageWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.average);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBowlingStrikingRateWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.strikeRate);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBowlingEconomyWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> censusComparator = Comparator.comparing(census -> census.economy);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(censusComparator, censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBestStrikingRateWith4wAnd5wWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> strikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        Comparator<IPLCensusDAO> fourAndFiveWktsComparator = Comparator.comparing(census -> census.fourWickets + census.fiveWickets);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(fourAndFiveWktsComparator.thenComparing(strikeRateComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getBowlerGreatAveragesWithBestStrikingRatesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        Comparator<IPLCensusDAO> strikeRateComparator = Comparator.comparing(census -> census.strikeRate);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(strikeRateComparator.thenComparing(averageComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getMaxWktsWithBestAveragesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        Comparator<IPLCensusDAO> wktsComparator = Comparator.comparing(census -> census.wickets);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(wktsComparator.thenComparing(averageComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getAllRounderWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> wktsComparator = Comparator.comparing(census -> census.wickets);
        Comparator<IPLCensusDAO> runsComparator = Comparator.comparing(census -> census.runs);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(runsComparator.thenComparing(wktsComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getMax100WithBestBattingAveragesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> centuryComparator = Comparator.comparing(census -> census.century);
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(averageComparator.thenComparing(centuryComparator), censusDAOList);
        return new Gson().toJson(censusDAOList);
    }
    public String getZero100And50WithBestBattingAveragesWiseSortedCensusData() throws CricketLeagueAnalyserException {
        if (censusMap  == null || censusMap .size() == 0) {
            throw new CricketLeagueAnalyserException("No Census Data", CricketLeagueAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IPLCensusDAO> averageComparator = Comparator.comparing(census -> census.average);
        Comparator<IPLCensusDAO> zero100And50Comparator = Comparator.comparing(census -> census.century + census.halfCentury);
        List<IPLCensusDAO> censusDAOList = censusMap.values().stream().collect(Collectors.toList());
        censusDAOList = descendingSort(zero100And50Comparator.reversed().thenComparing(averageComparator), censusDAOList);
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
