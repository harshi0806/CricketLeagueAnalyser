package cricketleagueanalyser;

import customcsv.util.CSVBuilderException;
import customcsv.util.CSVBuilderFactory;
import customcsv.util.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IPLCensusLoader {
    public Map<String, IPLCensusDAO> loadIPLCensusData(CricketLeagueAnalyser.Play play, String... csvFilePath) throws CricketLeagueAnalyserException{
        if (play.equals(CricketLeagueAnalyser.Play.BATTING)) {
            return this.loadIPLCensusData(IPLMostRunsCensusCSV.class, csvFilePath);
        } else if (play.equals(CricketLeagueAnalyser.Play.BOWLING)) {
            return this.loadIPLCensusData(IPLMostWktsCensusCSV.class, csvFilePath);
        } else {
            throw new CricketLeagueAnalyserException("Invalid Play", CricketLeagueAnalyserException.ExceptionType.INVALID_PLAY);
        }
    }

    public <E> Map loadIPLCensusData(Class<E> censusCSVClass, String... csvFilePath) throws CricketLeagueAnalyserException {
        Map<String, IPLCensusDAO> censusMap = new HashMap<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]));
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, censusCSVClass);
            Iterable<E> censusCSVIterable = () -> csvFileIterator;
            if (censusCSVClass.getName().equals("cricketleagueanalyser.IPLMostRunsCensusCSV")) {
                StreamSupport.stream(censusCSVIterable.spliterator(), false)
                        .map(IPLMostRunsCensusCSV.class::cast)
                        .forEach(censusCSV -> censusMap.put(censusCSV.player, new IPLCensusDAO(censusCSV)));
            } else if (censusCSVClass.getName().equals("cricketleagueanalyser.IPLMostWktsCensusCSV")) {
                StreamSupport.stream(censusCSVIterable.spliterator(), false)
                        .map(IPLMostWktsCensusCSV.class::cast)
                        .forEach(censusCSV -> censusMap.put(censusCSV.player, new IPLCensusDAO(censusCSV)));
            }
            return censusMap;
        } catch (IOException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.CENSUS_INCORRECT_HEADER);
        } catch (CSVBuilderException e) {
            throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
        }
    }
}
