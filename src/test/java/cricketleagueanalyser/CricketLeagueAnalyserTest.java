package cricketleagueanalyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {
    private static final String IPL_MOST_RUN_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WKTS_CENSUS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    //This test case is used to ensure number of record matches from IPLMostRuns CSV file
    @Test
    public void givenIPLMostRunsCSVFileReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(100,numOfRecords);
        } catch (CricketLeagueAnalyserException e) { }
    }
    //This test case is used to ensure number of record matches from IPLMostRuns CSV file
    @Test
    public void givenIPLMostWktsCSVFileReturnsCorrectRecords() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int numOfRecords = cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BOWLING, IPL_MOST_WKTS_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(99,numOfRecords);
        } catch (CricketLeagueAnalyserException e) { }
    }
    // This test case checks for Sorted Factsheet Data in a Json format according to Batting Averages of Cricketers
    @Test
    public void givenMostRunsFactSheet_WhenSortedOnBattingAverage_ShouldReturnSortedResult() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
            String sortedCensusData = cricketLeagueAnalyser.getBattingAverageWiseSortedCensusData();
            IPLMostRunsCensusCSV[] censusCSV =  new Gson().fromJson(sortedCensusData, IPLMostRunsCensusCSV[].class);
            Assert.assertEquals("MS Dhoni", censusCSV[0].player);
        } catch (CricketLeagueAnalyserException e ) { }
    }
    // This test case checks for Sorted Factsheet Data in a Json format according to top Striking Rates of Batsman
    @Test
    public void givenMostRunsFactSheet_WhenSortedOnStrikingRate_ShouldReturnSortedResult() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
            String sortedCensusData = cricketLeagueAnalyser.getStrikingRateWiseSortedCensusData();
            IPLMostRunsCensusCSV[] censusCSV =  new Gson().fromJson(sortedCensusData, IPLMostRunsCensusCSV[].class);
            Assert.assertEquals("Ishant Sharma", censusCSV[0].player);
        } catch (CricketLeagueAnalyserException e ) { }
    }
    // This test case checks for Sorted Factsheet Data in a Json format according to MAX 6s and 4S of Batsman
    @Test
    public void givenMostRunsFactSheet_WhenSortedOnMax6sAnd4s_ShouldReturnSortedResult() {
        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadIPLCensusData(CricketLeagueAnalyser.Play.BATTING, IPL_MOST_RUN_CENSUS_CSV_FILE_PATH);
            String sortedCensusData = cricketLeagueAnalyser.getMax6sAnd4sWiseSortedCensusData();
            IPLMostRunsCensusCSV[] censusCSV =  new Gson().fromJson(sortedCensusData, IPLMostRunsCensusCSV[].class);
            Assert.assertEquals("Andre Russell", censusCSV[0].player);
        } catch (CricketLeagueAnalyserException e ) { }
    }
}
